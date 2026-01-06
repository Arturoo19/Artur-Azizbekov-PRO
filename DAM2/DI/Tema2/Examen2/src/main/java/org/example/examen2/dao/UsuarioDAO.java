package org.example.examen2.dao;

import org.example.examen2.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    boolean obtenerUsuario(String pass,String correo);
    void insertarUsuario(Usuario usuario) throws SQLException;
    List<Usuario> obtenerUsuarios() throws SQLException;

}
