package de.hsowl.controller;

import de.hsowl.model.AdminCreateItemRepository;
import de.hsowl.model.CustomerRepository;
import de.hsowl.model.ShoppingCardRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;


@ManagedBean
@SessionScoped
public class CustomerLoginController implements Serializable {

    public String firstName;
    private String password;
    private CustomerRepository customerRepository = new CustomerRepository();
    private ShoppingCardRepository shoppingCardRepository = new ShoppingCardRepository();
    private AdminCreateItemRepository adminCreateItemRepository = new AdminCreateItemRepository();

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

    public String loginValidationOfUsernameAndPassword() throws IOException, SQLException {

        //try to login as admin
        if (firstName.equals("admin") && password.equals("admin")){
            adminCreateItemRepository.createNewDatabaseItems();
            return "admin.xhtml";
        }else{
            //try to login as normal shopping user
            try {
                customerRepository.login(firstName, password);
                shoppingCardRepository.insertNameInTable(firstName);
                shoppingCardRepository.createNewDatabaseForCustomerShoppingCard(firstName);
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
