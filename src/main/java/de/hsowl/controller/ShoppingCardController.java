package de.hsowl.controller;

import de.hsowl.model.DbConnection;
import de.hsowl.model.ShoppingCardRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim on 22.02.2016.
 */
@ManagedBean
@RequestScoped
public class ShoppingCardController implements Serializable{

    public String nameOne = null;
    public int amountOne;
    public List<Double> priceList = new ArrayList<Double>();
    public List<String> titelList = new ArrayList<String>();
    public double sumOne;

    public List<String> getTitelList() {
        return titelList;
    }

    public double getSumOne() {
        return sumOne;
    }

    public List<Double> getPriceList() {
        return priceList;
    }

    public int getAmountOne() {
        return amountOne;
    }

    ShoppingCardRepository shoppingCardRepository = new ShoppingCardRepository();

    //display amount in Shoppingcard
    public void shoppingCardCanDisplayAmountListItemAndSum() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet = statement.executeQuery("SELECT * FROM SHOPPINGCARD_"+nameOne+"" );

        while ( resultSet.next()) {
            String title = resultSet.getString(1);
            int amount = resultSet.getInt(2);
            double price = resultSet.getDouble(3);

            amountOne = amountOne + amount;
            priceList.add(price);
            titelList.add(title);
            sumOne = sumOne + price;
        }

        System.out.println(amountOne);
        System.out.println(priceList);
        System.out.println(titelList);

        resultSet.close();
        statement.close();
    }

    public void deleteRowsInShoppingCardAfterOrder() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        resultSet = statement.executeQuery("DELETE FROM Shoppingcard_"+nameOne+"");

        System.out.println(amountOne);
        System.out.println(priceList);
        System.out.println(titelList);

        resultSet.close();
        statement.close();

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hallo " + nameOne + ", Du hast erfolgreich Bestellt! :)", ""));
    }

    public void deleteRowsInShoppingCardAfterDelete() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        resultSet = statement.executeQuery("DELETE FROM Shoppingcard_"+nameOne+"");

        System.out.println(amountOne);
        System.out.println(priceList);
        System.out.println(titelList);

        resultSet.close();
        statement.close();

        FacesContext
                .getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Warenkorb wurde gelöscht!", ""));
    }


//    public void listItems() throws SQLException {
//
//        Statement statement = DbConnection.getInstance().con.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );
//
//        while ( resultSet.next()) {
//            String name = resultSet.getString(1);
//
//            nameOne = name;
//        }
//
//        System.out.println(nameOne);
//
//        resultSet = statement.executeQuery("SELECT * FROM SHOPPINGCARD_"+nameOne+"" );
//
//        while ( resultSet.next()) {
//            String name = resultSet.getString(1);
//            int amount = resultSet.getInt(2);
//            double price = resultSet.getDouble(3);
//
//            priceList.add(price);
//        }
//
//        System.out.println(priceList);
//
//        resultSet.close();
//        statement.close();
//
//    }





    //Software for text processing
    //word2020
    public void buydWord2020() throws SQLException, IOException {

        shoppingCardRepository.buyItemWord2020();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentWord2020() throws SQLException, IOException {

        shoppingCardRepository.lentItemWord2020();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //wordLite
    public void buydWordLite() throws SQLException, IOException {

        shoppingCardRepository.buyItemWordLite();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentWordLite() throws SQLException, IOException {

        shoppingCardRepository.lentItemWordLite();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //word2010
    public void buydWord2010() throws SQLException, IOException {

        shoppingCardRepository.buyItemWord2010();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentWord2010() throws SQLException, IOException {

        shoppingCardRepository.lentItemWord2010();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //Software for image editing
    //bildbearbeitung2015
    public void buyBildbearbeitung2015() throws SQLException, IOException {

        shoppingCardRepository.buyItemBildbearbeitung2015();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentBildbearbeitung2015() throws SQLException, IOException {

        shoppingCardRepository.lentItemBildbearbeitung2015();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //bildbearbeitung2013
    public void buyBildbearbeitung2013() throws SQLException, IOException {

        shoppingCardRepository.buyItemBildbearbeitung2013();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentBildbearbeitung2013() throws SQLException, IOException {

        shoppingCardRepository.lentItemBildbearbeitung2013();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //bildbearbeitung2010
    public void buyBildbearbeitung2010() throws SQLException, IOException {

        shoppingCardRepository.buyItemBildbearbeitung2013();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentBildbearbeitung2010() throws SQLException, IOException {

        shoppingCardRepository.lentItemBildbearbeitung2013();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //Software for everyday life
    //SoFüAl2015
    public void buySoFüAl2015() throws SQLException, IOException {

        shoppingCardRepository.buyItemSoFüAl2015();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentSoFüAl2015() throws SQLException, IOException {

        shoppingCardRepository.lentItemSoFüAl2015();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //Steuerprüfer2015
    public void buySteuerprüfer2015() throws SQLException, IOException {

        shoppingCardRepository.buyItemSteuerprüfer2015();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentSteuerprüfer2015() throws SQLException, IOException {

        shoppingCardRepository.lentItemSteuerprüfer2015();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    //Steuerprüfer2015
    public void buyZirkusDirektor() throws SQLException, IOException {

        shoppingCardRepository.buyItemZirkusDirektorSymolator();
        shoppingCardCanDisplayAmountListItemAndSum();
    }

    public void lentZirkusDirektor() throws SQLException, IOException {

        shoppingCardRepository.lentItemZirkusDirektorSymolator();
        shoppingCardCanDisplayAmountListItemAndSum();
    }
}
