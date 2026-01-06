package org.example.formulario.dao;

import javafx.fxml.Initializable;
import org.example.formulario.database.DBConection;
import org.example.formulario.database.SchemeDB;
import org.example.formulario.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO{

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;


    public UsuarioDAOImp(){
        connection = DBConection.getConnection();
    }

    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException {
        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?)",
                SchemeDB.TAB_NAME,
                SchemeDB.COL_NAME,
                SchemeDB.COL_MAIL,
                SchemeDB.COL_LOCATE,
                SchemeDB.COL_GEN,
                SchemeDB.COL_AG);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getCorreo());
            preparedStatement.setString(3, usuario.getLocalizacion());
            preparedStatement.setString(4, usuario.getGenero());
            preparedStatement.setInt(5, usuario.getEdad());
            preparedStatement.execute();

    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM "+ SchemeDB.TAB_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String nombre = resultSet.getString(SchemeDB.COL_NAME);
                String mail = resultSet.getString(SchemeDB.COL_MAIL);
                String localizacion = resultSet.getString(SchemeDB.COL_LOCATE);
                String genero = resultSet.getString(SchemeDB.COL_GEN);
                int edad = resultSet.getInt(SchemeDB.COL_AG);
                Usuario usuario = new Usuario(nombre,mail,localizacion,genero,edad,true);
                lista.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("error en la query");
        }

        return lista;
    }

    @Override
    public int borrarUsuarios(String nombre) {
        String query = String.format("DELETE FROM %s WHERE %s = ?;",SchemeDB.TAB_NAME,SchemeDB.COL_NAME);
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,nombre);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println("Error en la eliminacion");
            System.out.println(e.getMessage());
        }


        return 0;
    }
}
