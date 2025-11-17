package org.example.pizzeria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {

    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null){
            createConnection();
        }

        return connection;
    }

    private static void createConnection() {
        String user = "root";
        String pass = "Artur190905";
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s",
                    SchemaDB.URL,SchemaDB.PORT,SchemaDB.DB_NAME),user,pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error al conectar database");
        }
    }
}
