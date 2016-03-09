package de.hsowl.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerRepository {

    public void printCustomers() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CUSTOMER" );

        while ( resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(3);
            System.out.println(id + ", " + name + ", " + password);
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
}


