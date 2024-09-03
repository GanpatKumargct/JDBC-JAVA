package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class resultsetSenstive {
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
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
            );

            //create Query
            String query = "select * from student";
            ResultSet resultSet =statement.executeQuery(query);

           while(resultSet.next()){
               System.in.read();
               resultSet.refreshRow();
               System.out.println(resultSet.getInt(1)+"   "
                       +resultSet.getString(2)+"  "
                       +resultSet.getString(3));
           }


            connection.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } ;

    }

}
