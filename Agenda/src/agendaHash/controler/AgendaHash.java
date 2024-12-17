package agendaHash.controler;

import java.util.Hashtable;

public class AgendaHash {
    private Hashtable<String,Object[]> listaAgenda;

    public AgendaHash(){
        listaAgenda = new Hashtable<>();
    }

    public void agregarUsuarios(String nombre, String apellido, int telefono, String dni){
        Object[] usuario = new Object[]{nombre,apellido,telefono,dni};
    }
    public void mostrarUsuarios(){

    }
    public void buscarPersona(){

    }

}
