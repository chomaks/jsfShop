//package de.hsowl.controller;
//
//
//import de.hsowl.model.AdminCreateItemRepository;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import java.io.Serializable;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@ManagedBean
//@SessionScoped
//public class ShowItemController implements Serializable {
//
//    AdminCreateItemRepository adminCreateItemRepository = new AdminCreateItemRepository();
//    private List<String> items = new ArrayList<String>();
//    private String title;
//    private String description;
//    private double price;
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setItems(List<String> items) {
//        this.items = items;
//    }
//
//    public List<String> getItems() {
//
//        List<String> items = new ArrayList <String>();
//
//        return items;
//    }
//
//    public List<String> showItems() throws SQLException {
//
//        adminCreateItemRepository.showTheItems(title, description, price, items);
//
//        return items;
//    }
//
//}
//
//
////    private String firstName;
////    private String password;
////    private CustomerRepository customerRepository = new CustomerRepository();
////
////    public String getFirstName() {
////        return firstName;
////    }
////
////    public void setFirstName(String firstName) {
////        this.firstName = firstName;
////    }
////
////    public String getPassword() {
////        return password;
////    }
////
////    public void setPassword(String password) {
////        this.password = password;
////    }
////
////    public String loginValidationOfUsernameAndPassword(){
////
////        if (firstName.equals("admin") && password.equals("admin")){
////            return "admin.xhtml";
////        }else{
////            try {
////                customerRepository.login(firstName, password);
////                return "index.xhtml";
////            } catch (Exception e) {
////                FacesContext
////                        .getCurrentInstance()
////                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Benutzer oder Password ist falsch!", ""));
////            }
////            return "login.xhtml";
////        }
////
////    }
