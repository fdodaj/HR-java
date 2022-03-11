package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            if (connection != null){
                System.out.println("Connected to the database");
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
