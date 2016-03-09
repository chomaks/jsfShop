package de.hsowl.controller;

import de.hsowl.model.CustomerRepository;
import de.hsowl.model.ShoppingCardRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class CustomerLoginController implements Serializable {

    public String firstName;
    private String password;
    private CustomerRepository customerRepository = new CustomerRepository();
    private ShoppingCardRepository shoppingCardRepository = new ShoppingCardRepository();

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

    public String loginValidationOfUsernameAndPassword(){

        //try to login as admin
        if (firstName.equals("admin") && password.equals("admin")){
            return "admin.xhtml";
        }else{
            //try to login as normal shopping user
            try {
                customerRepository.login(firstName, password);
                shoppingCardRepository.createNewDatabase(firstName);
                shoppingCardRepository.insertNameInTable(firstName);
//                shoppingCardRepository.deleteCustomerGetTableName();
//                shoppingCardRepository.customergGetTableName(firstName);

                return "index.xhtml";

            } catch (Exception e) {
                FacesContext
                        .getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Benutzer oder Password ist falsch!", ""));
            }
            return "login.xhtml";
        }

    }
}
