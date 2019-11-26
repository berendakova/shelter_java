package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static volatile Connection connection = null;

    private static final String url = "jdbc:postgresql://localhost/shelter";
    private static final String user = "tanya";
    private static final String password = "password";


    public static Connection connect() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null){
                synchronized (ConnectionDB.class){
                    if(connection == null){
                        String host = "localhost";
                        int port = 3306;
                        String name = "shelter";
                        String url = "jdbc:mysql://" + host + ":" + port + "/" + name + "?serverTimezone=UTC";
                        connection = DriverManager.getConnection(url,"root","password");
                    }
                }


            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}