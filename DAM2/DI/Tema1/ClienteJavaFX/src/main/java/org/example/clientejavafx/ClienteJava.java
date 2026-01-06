package org.example.clientejavafx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteJava {

    @FXML
    private Label lblResultado;

    public void recibirDatos() {

        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 6000);

                BufferedReader leer = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                PrintWriter escribir = new PrintWriter(socket.getOutputStream(), true);

                escribir.println("READY");

                String mensaje = leer.readLine();

                Platform.runLater(() -> {
                    lblResultado.setText("Servidor dice: " + mensaje);
                });

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
