package de.hsowl.model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Maksim on 21.02.2016.
 */
public class ShoppingCardRepository {

    int amountOne = 0;
    String nameOne = null;

    //create a shoppingcard with a unique tablename for every user wich include the username
    public void createNewDatabaseForCustomerShoppingCard(String firstName) throws SQLException, IOException {

        PreparedStatement preparedStatement = DbConnection.getInstance().con.prepareStatement
                ("CREATE TABLE IF NOT EXISTS PUBLIC.ShoppingCard_"+ firstName + "(TITLE VARCHAR(32), AMOUNT INT, PRICE DOUBLE)");

        int i = preparedStatement.executeUpdate();
        System.out.println("shoppingCard could be created");
    }

    public void createNewDatabaseFirstNameTable() throws SQLException, IOException {

        PreparedStatement preparedStatement = DbConnection.getInstance().con.prepareStatement
                ("CREATE TABLE IF NOT EXISTS PUBLIC.FIRSTNAMETABLE(NAME VARCHAR(32))");

        int i = preparedStatement.executeUpdate();
        System.out.println("FirstnameTable could be created");
    }


    public void insertNameInTable(String firstName) throws SQLException {

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement("INSERT INTO FIRSTNAMETABLE (NAME) VALUES (?)");
        preparedStatement.setString(1, firstName);

        int i = preparedStatement.executeUpdate();
        System.out.println("test" + i);
    }





    //Software for text processing
    // word-2020
    public void buyItemWord2020() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Word-2020 Students";
        int amount = 1;
        double price = 123.45;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemWord2020() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Word-2020 Students (Fernleihe)";
        int amount = 1;
        double price = 1.50;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    // word-lite
    public void buyItemWordLite() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Word-Lite";
        int amount = 1;
        double price = 12.34;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemWordLite() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Word-Lite (Fernleihe)";
        int amount = 1;
        double price = 0.50;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    // word-2010
    public void buyItemWord2010() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Word 2010 Standard";
        int amount = 1;
        double price = 123.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemWord2010() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Word 2010 Standard (Fernleihe)";
        int amount = 1;
        double price = 2.15;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    //Software for image editing
    //bildbearbeitung2015
    public void buyItemBildbearbeitung2015() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Bildbearbeitung 2015";
        int amount = 1;
        double price = 100.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemBildbearbeitung2015() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Bildbearbeitung 2015 (Fernleihe)";
        int amount = 1;
        double price = 1.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    //bildbearbeitung2013
    public void buyItemBildbearbeitung2013() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Bildbearbeitung 2013";
        int amount = 1;
        double price = 50.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemBildbearbeitung2013() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Bildbearbeitung 2013 (Fernleihe)";
        int amount = 1;
        double price = 0.50;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    //bildbearbeitung2010
    public void buyItemBildbearbeitung2010() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Bildbearbeitung 2010";
        int amount = 1;
        double price = 25.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemBildbearbeitung2010() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Bildbearbeitung 2010 (Fernleihe)";
        int amount = 1;
        double price = 0.25;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    //Software for everyday life
    //SoFüAl2015
    public void buyItemSoFüAl2015() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "SoFüAl 2015";
        int amount = 1;
        double price = 500.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemSoFüAl2015() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "SoFüAl 2015 (Fernleihe)";
        int amount = 1;
        double price = 5.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    //Steuerprüfer2015
    public void buyItemSteuerprüfer2015() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Steuerprüfer 2015";
        int amount = 1;
        double price = 250.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemSteuerprüfer2015() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Steuerprüfer 2015 (Fernleihe)";
        int amount = 1;
        double price = 2.50;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    //ZirkusDirektorSymolator
    public void buyItemZirkusDirektorSymolator() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Zirkusdirektor-Symolator";
        int amount = 1;
        double price = 30.00;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

    public void lentItemZirkusDirektorSymolator() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIRSTNAMETABLE" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);

            nameOne = name;
        }

        System.out.println(nameOne);

        resultSet.close();
        statement.close();

        String title = "Zirkusdirektor (Fernleihe)";
        int amount = 1;
        double price = 0.80;

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement
                ("INSERT INTO SHOPPINGCARD_"+nameOne+"(TITLE, AMOUNT, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setInt(2, amount);
        preparedStatement.setDouble(3, price);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }

}

