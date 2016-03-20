package de.hsowl.controller;


import de.hsowl.model.AdminCreateItemRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;


@ManagedBean
@SessionScoped
public class AdminController implements Serializable {

    private String title;
    private String description;
    private double price;

    public AdminController() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private AdminCreateItemRepository adminCreateItemRepository = new AdminCreateItemRepository();

    public void save() throws SQLException {

        try {
            adminCreateItemRepository.validateItem(title, description, price);

            FacesContext
                    .getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hallo Admin, du hast eine neues Produkt im Store verfügbar gemacht! ", ""));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Es existiert bereits ein Produkt mit dem Titel: " +"\""+title + "\"", ""));
        }

        adminCreateItemRepository.printItems();
    }

    public void createItemDatabase() throws IOException, SQLException {

        adminCreateItemRepository.createNewDatabaseItems();
    }
}
