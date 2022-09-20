/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers;

import com.saviortech.controllers.events.AddEventController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class HomeController implements Initializable {


//$$$$$$$$$$$$$$$$$$$ START EVENTS NODES $$$$$$$$$$$$$$$$$$$
    @FXML
    private HBox showEventsId;
    @FXML
    private HBox addEventId;
//$$$$$$$$$$$$$$$$$$$ END EVENTS NODES $$$$$$$$$$$$$$$$$$$
    @FXML
    private Button addPub;
    @FXML
    private VBox vBox;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//$$$$$$$$$$$$$$$$$$$ START EVENTS METHODS $$$$$$$$$$$$$$$$$$$
    @FXML
    private void ShowEventsMethod(MouseEvent event) {
    }

    @FXML
    private void AddEventMethod(MouseEvent event) {
        FXMLLoader addEventLoader = new FXMLLoader();
        addEventLoader.setLocation(HomeController.this.getClass().getResource("../views/events/AddEvent.fxml"));
        try {
            addEventLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = addEventLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("ADD NEW EVENT");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
    }
//$$$$$$$$$$$$$$$$$$$ END EVENTS METHODS $$$$$$$$$$$$$$$$$$$

    @FXML
    private void onActionAjouter(ActionEvent event) {
    }
}
