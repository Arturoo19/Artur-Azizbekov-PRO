package org.example.nazariijavafx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tienda_examen",
                        "root",
                        "1234"
                );
                System.out.println("Conexión correcta");
            } catch (SQLException e) {
                throw new RuntimeException("Error conexión BD: " + e.getMessage());
            }
        }
        return connection;
    }
}