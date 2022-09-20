/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class HomeController implements Initializable {


    @FXML
    private VBox pnl_scroll;
    
//$$$$$$$$$$$$$$$$$$$ START EVENTS NODES $$$$$$$$$$$$$$$$$$$
    @FXML
    private HBox showEventsId;
    @FXML
    private HBox addEventId;
//$$$$$$$$$$$$$$$$$$$ END EVENTS NODES $$$$$$$$$$$$$$$$$$$

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
    }
//$$$$$$$$$$$$$$$$$$$ END EVENTS METHODS $$$$$$$$$$$$$$$$$$$
}
