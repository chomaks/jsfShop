package de.hsowl.controller;


import de.hsowl.model.CustomerRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.SQLException;


@ManagedBean
@SessionScoped
public class CustomerRegistrationController implements Serializable {

    private String firstName;
    private String password;
    private CustomerRepository customerRepository = new CustomerRepository();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save() throws SQLException {

        if (firstName.equals("admin") || firstName.equals("Admin")){
            FacesContext
                    .getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sie können sich nicht als Admin registrieren", ""));
        }else {

            try {
                customerRepository.validateCustomer(firstName, password);

                FacesContext
                        .getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hallo " + firstName + ", Du hast dich erfolgreich Regestriert! Du kannst dich jetzt einloggen! :)", ""));

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Benutzer existiert bereits", ""));
            }

            customerRepository.printCustomers();
        }
    }
}
