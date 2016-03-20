package de.hsowl.model;


import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerRepository {

    public void printCustomers() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CUSTOMER" );

        while ( resultSet.next()) {
            String name = resultSet.getString(1);
            String password = resultSet.getString(2);
            System.out.println(name + ", " + password);
        }

        resultSet.close();
        statement.close();
    }

    public void createNewCustomer(String firstName, String password) throws SQLException {

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement("INSERT INTO CUSTOMER (NAME, PASSWORD) VALUES (?,?)");
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, password);

        int i = preparedStatement.executeUpdate();
        System.out.println("test" + i);
    }

    public void validateCustomer(String firstName, String password) throws Exception {

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement("SELECT * FROM CUSTOMER WHERE NAME = ?");

        preparedStatement.setString(1, firstName);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next() == false) {
            createNewCustomer(firstName, password);
        }else{
            throw new Exception("");
        }
    }

    public void login(String firstName, String password) throws Exception {

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement("SELECT * FROM CUSTOMER WHERE NAME = ? AND PASSWORD = ?");

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next() == true) {
        }else {
            throw new Exception("");
        }
    }

    public void createNewDatabaseCustomer() throws SQLException, IOException {

        PreparedStatement preparedStatement = DbConnection.getInstance().con.prepareStatement
                ("CREATE TABLE IF NOT EXISTS PUBLIC.CUSTOMER(NAME VARCHAR(20), PASSWORD VARCHAR(20))");

        int i = preparedStatement.executeUpdate();
        System.out.println("CustomerTable could be created");
    }
}


