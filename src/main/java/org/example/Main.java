package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application {
    ObservableList<String> datos = FXCollections.observableArrayList();
    @Override
    public void start(Stage stage) {
        ListView<String> lista = new ListView<>(datos);

        TextField texto = new TextField();

        Button crear = new Button("Crear");
        Button leer = new Button("Leer");
        Button actualizar = new Button("Actualizar");
        Button eliminar = new Button("Eliminar");

        crear.setOnAction(e -> {
            datos.add(texto.getText());
            texto.clear();
        });
        leer.setOnAction(e -> {
            String selected = lista.getSelectionModel().getSelectedItem();
            if (selected != null) {
                texto.setText(selected);
                System.out.println("Elemento leido: " + selected);
            }
        });
        actualizar.setOnAction(e -> {
            int index = lista.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                datos.set(index, texto.getText());
                texto.clear();
            }
        });
        eliminar.setOnAction(e -> {
            int index = lista.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                datos.remove(index);
            }
        });

        VBox root = new VBox(10,lista,texto,crear,leer,actualizar,eliminar);

        Scene scene = new Scene(root,300,300);

        stage.setTitle("CRUD");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
