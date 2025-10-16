package org.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public Label labelSaludo;
    @FXML
    public TextField textFieldNombre;

    @FXML
    private Button bottonPulsar, bottonVaciar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Ejecuacion de la parte logica");
        acciones();
    }
    private void acciones(){
        /*bottonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText("");
                textFieldNombre.clear();
            }
        });
        bottonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Boton pulsado correctamente");
                String nombre = textFieldNombre.getText();
                if (nombre.isEmpty()){
                    System.out.println("por favor rellena el nombre");
                } else {
                    labelSaludo.setText(String.format("Enhorabuena %s has completado el ejercicio",nombre));
                }
            }
        });*/
        bottonVaciar.setOnAction(new ManejoAccion());
        bottonPulsar.setOnAction(new ManejoAccion());
    }
    
    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");
            if (actionEvent.getSource()==bottonPulsar){
                
            } else if (actionEvent.getSource()==bottonVaciar) {
                
            }
        }
    }
}
