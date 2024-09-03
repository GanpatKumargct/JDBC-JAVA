package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class resultsetInsenstive {
    public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/gans";
    public static String USER_NAME = "root";
    public static String PASSWORD = "6208gct";

    public static void main(String[] args) {

        try {
            //Load Driver
            Class.forName(LOAD_DRIVER);

            //Making Connection
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            //Create Statement
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE
            );

            //create Query
            String query = "select * from student";
            ResultSet resultSet =statement.executeQuery(query);

            //to fetching last rows
            resultSet.last();
            System.out.println("Fetching last row data.");
            System.out.println("ID : "+resultSet.getInt("id"));
            System.out.println("name : "+resultSet.getString("name"));


            //to fetching first row
            resultSet.first();
            System.out.println("Fetching first row data.");
            System.out.println("ID : "+resultSet.getInt("id"));
            System.out.println("name : "+resultSet.getString("name"));


          /*  //to change the name in last row
            resultSet.last();
            resultSet.updateString("name", "Aakash");
            resultSet.updateRow();*/


            //insert rows -date
            resultSet.moveToInsertRow();        //create empty row.
            resultSet.updateInt("id",7);
            resultSet.updateString("name", "anshu");
            resultSet.updateString("course", "DSA");
            resultSet.insertRow();

            resultSet.last();
            System.out.println("Fetching last row data.");
            System.out.println("ID : "+resultSet.getInt("id"));
            System.out.println("name : "+resultSet.getString("name"));




            connection.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } ;

    }

}
