package org.example.examen2.dao;

import org.example.examen2.database.DBConection;
import org.example.examen2.database.SchemaDB;
import org.example.examen2.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO {

    PreparedStatement preparedStatement;
    Connection connection;
    ResultSet resultSet;


    public UsuarioDAOImp() {
        connection = DBConection.getConnection();
    }


    @Override
    public boolean obtenerUsuario(String pass, String correo) {

        String query = String.format(
                "SELECT * FROM %s WHERE %s = ? AND %s = ?",
                SchemaDB.TAB_USUARIOS, SchemaDB.COL_CORREO, SchemaDB.COL_PASS
        );

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException e) {
            System.out.println("Error en obtenerUsuario(): " + e.getMessage());
        }

        return false;
    }


    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException {

        String query = String.format(
                "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
                SchemaDB.TAB_USUARIOS,
                SchemaDB.COL_NOMBRE_USUARIO,
                SchemaDB.COL_CORREO,
                SchemaDB.COL_PASS
        );

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getCorreo());
        preparedStatement.setString(3, usuario.getPass());
        preparedStatement.execute();
    }


    @Override
    public List<Usuario> obtenerUsuarios() throws SQLException {

        List<Usuario> listaUsuarios = new ArrayList<>();

        String query = "SELECT * FROM " + SchemaDB.TAB_USUARIOS;

        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Usuario user = new Usuario(
                    resultSet.getInt(SchemaDB.COL_ID_USUARIO),
                    resultSet.getString(SchemaDB.COL_NOMBRE_USUARIO),
                    resultSet.getString(SchemaDB.COL_CORREO),
                    resultSet.getString(SchemaDB.COL_PASS)
            );
            listaUsuarios.add(user);
        }

        return listaUsuarios;
    }
}
