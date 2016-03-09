package de.hsowl.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    //create a db connection
    public static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
    public Connection con;

    private static DbConnection instance;

    private DbConnection() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:file:C:/dev/hsqldb/JsfShop", "SA", "");

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static DbConnection getInstance () {

        if (DbConnection.instance == null) {
            DbConnection.instance = new DbConnection();
        }
        return DbConnection.instance;
    }
}
