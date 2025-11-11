package org.example.formulario.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {

    private static Connection connection;

    public static Connection getConnection(){
        if (connection== null){
            createConection();
        }

        return connection;
    }
    private static void createConection(){
        String user = "root";
        String pass = "Artur190905";
        try {
            //connection = DriverManager.getConnection("jdbc:mysql:/127.0.0.1:3306",user,pass);
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s",
                    SchemeDB.URL,SchemeDB.PORT,SchemeDB.DB_NAME),user,pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
