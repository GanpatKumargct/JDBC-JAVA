package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstProject {

    public static void main(String[] args) {
        String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/gans";
        String USER_NAME = "root";
        String PASSWORD = "6208gct";
        try {
            //Load Driver
            Class.forName(LOAD_DRIVER);

            //Making Connection
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            //Create Statement
            Statement statement = connection.createStatement();

            //create Query
            String query = "select * from student";

            ResultSet resultSet =statement.executeQuery(query);

            //iterator
            System.out.println("id "+"Name"+"   "+"Course");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String course = resultSet.getString("course");


                System.out.println(id+"  "+name+"  "+course);
            }

            connection.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } ;

    }

}
