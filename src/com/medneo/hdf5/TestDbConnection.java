package com.medneo.hdf5;

import java.sql.*;

public class TestDbConnection {

    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/testDB?verifyServerCertificate=false&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    public static final String USER = "root";
    public static final String PASS = "joewie007";

   public static void main(String[] args){

       //initialize connection as null
       Connection connection = null;
       //initialize sql statement to be null
       Statement statement = null;

       try {
           //Open a connection
           System.out.println("Connecting to database...");
           connection = DriverManager.getConnection(URL, USER, PASS);

           //execute query
           System.out.println("Creating statements...");
           statement = connection.createStatement();
           String sql = "SELECT id, age, first, last FROM Employees";
           ResultSet resultSet = statement.executeQuery(sql);

           //extract data from resultSet
           while(resultSet.next()){
               //retrieve by column name
               int id = resultSet.getInt("id");
               int age = resultSet.getInt("age");
               String first = resultSet.getString("first");
               String last = resultSet.getString("last");

               //display values while the loop holds true.... next()

               System.out.print("ID: " + id);
               System.out.print(", Age: " + age);
               System.out.print(", First: " + first);
               System.out.println(", Last: " + last);
           }

           //clean up environment
           resultSet.close();
           statement.close();
           connection.close();

       }
       catch (SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
       }
       finally {
           //finally block used to close resources
           try {
               if(statement != null){
                   statement.close();
               }
           }
           catch (SQLException se){
               se.printStackTrace();
           }

           try {
               if(connection != null){
                   connection.close();
               }
           }
           catch (SQLException se){
               se.printStackTrace();
           }

       }
       System.out.println("Goodbye !");




   }

}