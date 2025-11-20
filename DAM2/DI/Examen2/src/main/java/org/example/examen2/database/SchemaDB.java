package org.example.examen2.database;

public interface SchemaDB {
    String URL = "127.0.0.1";
    String PORT = "3306";
    String DB_NAME = "tienda";
    String TAB_PRODUCTOS = "productos";
    String TAB_USUARIOS = "usuarios";
    String COL_ID_USUARIO = "idUsuario";
    String COL_ID_PRODUCTO = "idProducto";
    String COL_NOMBRE_USUARIO = "nombreUsuario";
    String COL_CORREO = "correo";
    String  COL_PASS = "pass";

    String COL_NOMBRE_PRODUCTO = "nombreProducto";
    String COL_CATEGORIA = "categoria";
    String COL_PRECIO = "precio";
    String COL_DESCRIPCION = "descripcion";


}
