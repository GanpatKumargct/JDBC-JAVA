package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
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

            /*//Create Statement
            String query = "delete from student where id = ?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,2);
            int rowaffeted = preparedStatement.executeUpdate();
            System.out.println(rowaffeted);*/


            //insert query
            String insertquery = "INSERT INTO student(id, name, course) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertquery);
            preparedStatement.setInt(1,7);
            preparedStatement.setString(2,"sita");
            preparedStatement.setString(3,"devops");

            int update = preparedStatement.executeUpdate();
            System.out.println("Row impacted : "+update);
            connection.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } ;

    }

}
