package com.example.calculadora.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {

    @FXML private Button btnCos;
    @FXML private Button btnDividir;
    @FXML private Button btnIgual;
    @FXML private Button btnSumar;
    @FXML private Button btnRestar;
    @FXML private Button btn0;
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
    @FXML private Button btn9;
    @FXML private Button btnMultiplicar;
    @FXML private Button btnRaiz;
    @FXML private Button btnReset;
    @FXML private Button btnSin;
    @FXML private Button btnTan;

    @FXML private Label lblOperacion;
    @FXML private Label lblResultado;

    @FXML private GridPane panelCientifico;
    @FXML private BorderPane panelPrincipal;

    @FXML private RadioButton radioBasica;
    @FXML private RadioButton radioCientifica;

    private ToggleGroup grupoOpciones;

    private double numeroActual = 0;
    private String operador = null;
    private boolean esperandoNuevo = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializarInstancias();
        inicializarGUI();
        configurarAcciones();
    }

    private void inicializarInstancias() {
        grupoOpciones = new ToggleGroup();
        grupoOpciones.getToggles().addAll(radioBasica, radioCientifica);
    }

    private void inicializarGUI() {
        lblOperacion.setText("");
        lblResultado.setText("");
        if (radioCientifica.isSelected()) {
            panelPrincipal.setRight(panelCientifico);
        } else {
            panelPrincipal.setRight(null);
        }
    }

    private void configurarAcciones() {
        EventHandler<ActionEvent> gestor = new GestorEventos();

        btn0.setOnAction(gestor);
        btn1.setOnAction(gestor);
        btn2.setOnAction(gestor);
        btn3.setOnAction(gestor);
        btn4.setOnAction(gestor);
        btn5.setOnAction(gestor);
        btn6.setOnAction(gestor);
        btn7.setOnAction(gestor);
        btn8.setOnAction(gestor);
        btn9.setOnAction(gestor);

        btnSumar.setOnAction(gestor);
        btnRestar.setOnAction(gestor);
        btnMultiplicar.setOnAction(gestor);
        btnDividir.setOnAction(gestor);

        btnIgual.setOnAction(gestor);
        btnReset.setOnAction(gestor);

        btnRaiz.setOnAction(gestor);
        btnSin.setOnAction(gestor);
        btnCos.setOnAction(gestor);
        btnTan.setOnAction(gestor);

        radioCientifica.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean oldVal, Boolean newVal) {
                if (newVal) {
                    panelPrincipal.setRight(panelCientifico);
                } else {
                    panelPrincipal.setRight(null);
                }
            }
        });
    }

    class GestorEventos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Object fuente = event.getSource();
            String textoActual = lblResultado.getText();
            if (textoActual == null) textoActual = "";

            // Números
            if (fuente == btn0 || fuente == btn1 || fuente == btn2 ||
                    fuente == btn3 || fuente == btn4 || fuente == btn5 ||
                    fuente == btn6 || fuente == btn7 || fuente == btn8 ||
                    fuente == btn9) {

                Button b = (Button) fuente;
                String digito = b.getText();

                if (esperandoNuevo || esOperador(textoActual) || textoActual.equals("=")) {
                    lblResultado.setText(digito);
                    esperandoNuevo = false;
                } else {
                    lblResultado.setText(textoActual + digito);
                }

                if (operador != null && !lblResultado.getText().isEmpty()) {
                    lblOperacion.setText(numeroActual + " " + operador + " " + lblResultado.getText());
                }
                return;
            }

            // Operadores
            if (fuente == btnSumar || fuente == btnRestar || fuente == btnMultiplicar || fuente == btnDividir) {
                String op = "";
                if (fuente == btnSumar) op = "+";
                else if (fuente == btnRestar) op = "-";
                else if (fuente == btnMultiplicar) op = "*";
                else if (fuente == btnDividir) op = "/";

                if (!textoActual.isEmpty() && !esOperador(textoActual) && !textoActual.equals("=")) {
                    try { numeroActual = Double.parseDouble(textoActual); } catch (Exception ignored) {}
                }

                operador = op;
                lblOperacion.setText(numeroActual + " " + operador);
                lblResultado.setText(op);
                esperandoNuevo = true;
                return;
            }

            // Igual
            if (fuente == btnIgual) {
                if (operador != null && !textoActual.isEmpty() && !esOperador(textoActual) && !textoActual.equals("=")) {
                    double segundo = 0;
                    try { segundo = Double.parseDouble(textoActual); } catch (Exception e) {}
                    double res =  switch (operador) {
                        case "+" -> numeroActual + segundo;
                        case "-" -> numeroActual - segundo;
                        case "*" -> numeroActual * segundo;
                        case "/" -> segundo != 0 ? numeroActual / segundo : 0;
                        default -> 0;
                    };
                    lblOperacion.setText(numeroActual + " " + operador + " " + segundo + " =");
                    lblResultado.setText(String.valueOf(res));
                    numeroActual = res;
                    operador = null;
                    esperandoNuevo = true;
                }
                return;
            }

            // Funciones científicas
            if (fuente == btnRaiz || fuente == btnSin || fuente == btnCos || fuente == btnTan) {
                if (textoActual.isEmpty() || esOperador(textoActual) || textoActual.equals("=")) return;

                double valor;
                try { valor = Double.parseDouble(textoActual); } catch (Exception e) { return; }

                double resultado = valor;
                String textoProceso = "";

                if (fuente == btnRaiz) { resultado = Math.sqrt(valor); textoProceso = "√(" + textoActual + ")"; }
                else if (fuente == btnSin) { resultado = Math.sin(Math.toRadians(valor)); textoProceso = "sin(" + textoActual + ")"; }
                else if (fuente == btnCos) { resultado = Math.cos(Math.toRadians(valor)); textoProceso = "cos(" + textoActual + ")"; }
                else if (fuente == btnTan) { resultado = Math.tan(Math.toRadians(valor)); textoProceso = "tan(" + textoActual + ")"; }

                lblOperacion.setText(textoProceso);
                lblResultado.setText(String.valueOf(resultado));
                numeroActual = resultado;
                operador = null;
                esperandoNuevo = true;
                return;
            }

            // Reset
            if (fuente == btnReset) {
                lblResultado.setText("");
                lblOperacion.setText("");
                numeroActual = 0;
                operador = null;
                esperandoNuevo = false;
            }
        }
    }

    private boolean esOperador(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
