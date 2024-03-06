package ru.vsuet.bank.database;
import java.sql.*;

public class DataBaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    public DataBaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb", "root", "root");
            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                    + connection.getSchema());
        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
}