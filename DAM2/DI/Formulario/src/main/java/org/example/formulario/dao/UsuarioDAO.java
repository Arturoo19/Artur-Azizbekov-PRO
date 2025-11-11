package org.example.formulario.dao;

import org.example.formulario.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void insertarUsuario(Usuario usuario) throws SQLException;
    List<Usuario> obtenerUsuarios();
    int borrarUsuarios(String nombre);
    //int borrarUsuariosCorreo(String correo);


}
