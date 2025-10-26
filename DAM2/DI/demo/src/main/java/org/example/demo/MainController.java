package org.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public Label labelSaludo;
    @FXML
    public TextField textFieldNombre;

    @FXML
    private Button bottonPulsar, bottonVaciar,bottonLimpiar;

    private DropShadow sombra;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //System.out.println("Ejecuacion de la parte logica");
        instancia();
        initGUI();

        acciones();
    }

    private void initGUI() {
        // personalizara las partes de la UI

    }

    private void instancia() {
        sombra = new DropShadow();
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
        /*bottonPulsar.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                bottonPulsar.setCursor(Cursor.OPEN_HAND);
            }
        });
        bottonPulsar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                bottonPulsar.setCursor(Cursor.CLOSED_HAND);
            }
        });
        */
        bottonPulsar.setOnMouseExited(new ManejoRaton());
        bottonVaciar.setOnMouseExited(new ManejoRaton());
        bottonPulsar.setOnMousePressed(new ManejoRaton());
        bottonPulsar.setOnMouseEntered(new ManejoRaton());
        bottonVaciar.setOnMouseEntered(new ManejoRaton());
        bottonPulsar.setOnMouseReleased(new ManejoRaton());
        bottonLimpiar.addEventFilter(ActionEvent.ACTION,new ManejoAccion());

    }

    class ManejoRaton implements  EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            Button boton = (Button) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                boton.setEffect(sombra);
            }else if(mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                boton.setEffect(null);

            }
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED && mouseEvent.getSource() == bottonPulsar) {
                boton.setCursor(Cursor.OPEN_HAND);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED && mouseEvent.getSource() == bottonPulsar) {
                boton.setCursor(Cursor.CLOSED_HAND);
            }else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED && mouseEvent.getSource() == bottonPulsar){
                boton.setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED && mouseEvent.getSource() == bottonPulsar)  {
                boton.setCursor(Cursor.OPEN_HAND);
            }
        }
    }

    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");
            if (actionEvent.getSource()==bottonPulsar){
                String nombre = textFieldNombre.getText();
                if (nombre.isBlank()){
                    System.out.println("por favor rellena el nombre");
                } else {
                    labelSaludo.setText(String.format("Enhorabuena %s has completado el ejercicio",nombre));
                }
            } else if (actionEvent.getSource()==bottonVaciar) {
                labelSaludo.setText("");
                textFieldNombre.clear();
            } else if (actionEvent.getSource() == bottonLimpiar) {
                textFieldNombre.clear();
            }
        }
    }
}
