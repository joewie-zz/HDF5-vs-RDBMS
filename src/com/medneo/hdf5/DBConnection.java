package com.medneo.hdf5;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by Jonathan on 09 Sep, 2018
 */
public class DBConnection {

    // JDBC driver name and database URL
    //public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/loadDB?verifyServerCertificate=false&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    public static final String USER = "root";
    public static final String PASS = "joewie007";

    //connect to database
    public static Connection getConnection(){

        try{
            return DriverManager.getConnection(URL, USER, PASS);

        }
        catch (SQLException se){
            throw new RuntimeException("Error connecting to database!", se);

        }
    }

    //test connection
    public static void main(String[] args){
        Connection connection = DBConnection.getConnection();
    }
}