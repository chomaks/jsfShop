package de.hsowl.model;


import de.hsowl.controller.AdminController;
import org.primefaces.model.UploadedFile;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminCreateItemRepository {

    public void printItems() throws SQLException {

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ITEMS" );

        while ( resultSet.next()) {
            String title = resultSet.getString(1);
            String description = resultSet.getString(2);
            double price = resultSet.getDouble(3);
            System.out.println(title + ", " + description + ", " + price );
        }

        resultSet.close();
        statement.close();
    }

    public void createNewItem(String title, String description, double price) throws SQLException, IOException {

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement("INSERT INTO ITEMS (TITLE, DESCRIPTION, PRICE) VALUES (?,?,?)");
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, description);
        preparedStatement.setDouble(3, price);

//        InputStream inputStream = uploadedFile.getInputstream();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[] buffer = new byte[10240];
//
//        for(int i = 0; (i = inputStream.read(buffer)) < 0;) {
//            byteArrayOutputStream.write(buffer, 0, i);
//        }
//
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//
//        preparedStatement.setBlob(4, inputStream);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
    }



    public void validateItem(String title, String descripton, double price) throws Exception {

        PreparedStatement preparedStatement =  DbConnection.getInstance().con.prepareStatement("SELECT * FROM ITEMS WHERE TITLE = ?");

        preparedStatement.setString(1, title);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next() == false) {
            createNewItem(title, descripton, price);
        }else{
            throw new Exception("");
        }
    }

    public void showTheItems(String title, String description, double price, List<String> items) throws SQLException {

        items = new ArrayList <String>();

        Statement statement = DbConnection.getInstance().con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM ITEMS" );

        while ( resultSet.next()) {
            title = resultSet.getString(1);
            description = resultSet.getString(2);
            price = resultSet.getDouble(3);
            items.add(title);
        }

        resultSet.close();
        statement.close();
    }


}


