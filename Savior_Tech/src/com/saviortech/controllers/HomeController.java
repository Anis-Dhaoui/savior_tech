/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers;

import com.jfoenix.controls.JFXButton;
import com.saviortech.controllers.events.AddEventController;
import com.saviortech.models.CurrentUser;
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

    @FXML
    private Button addPub;
    @FXML
    private VBox vBox;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;
//$$$$$$$$$$$$$$$$$$$ START EVENTS NODES $$$$$$$$$$$$$$$$$$$
    @FXML
    private HBox showEventsId;
    @FXML
    private HBox addEventId;
//$$$$$$$$$$$$$$$$$$$ END EVENTS NODES $$$$$$$$$$$$$$$$$$$

//$$$$$$$$$$$$$$$$$$$ START USERS NODES $$$$$$$$$$$$$$$$$$$ 
    @FXML
    private HBox showUsersId;
    @FXML
    private HBox authenticatedUserBox;
    @FXML
    private HBox signinSignupBtnsBox;
//$$$$$$$$$$$$$$$$$$$ END USERS NODES $$$$$$$$$$$$$$$$$$$ 

    CurrentUser cu = new CurrentUser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkIfUserAuthenticated();
    }

    public void checkIfUserAuthenticated() {
        System.out.println(cu.getUserInfo().isEmpty());
        if (cu.getUserInfo().isEmpty()) {
            authenticatedUserBox.setVisible(false);
            signinSignupBtnsBox.setVisible(true);
        } else {
            authenticatedUserBox.setVisible(true);
            signinSignupBtnsBox.setVisible(false);
        }
    }

//$$$$$$$$$$$$$$$$$$$ START EVENTS METHODS $$$$$$$$$$$$$$$$$$$
    @FXML
    private void ShowEventsMethod(MouseEvent event) {
        FXMLLoader showEventLoader = new FXMLLoader();
        showEventLoader.setLocation(HomeController.this.getClass().getResource("../views/events/ShowEvents.fxml"));
        try {
            showEventLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = showEventLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("ALL EVENTS");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
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
//$$$$$$$$$$$$$$$$$$$ END EVENTS METHODS $$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$   
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$   
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    
//$$$$$$$$$$$$$$$$$$$ START USERS METHODS $$$$$$$$$$$$$$$$$$$

    @FXML
    private void SignUpMethod(ActionEvent event) {
        FXMLLoader signupLoader = new FXMLLoader();
        signupLoader.setLocation(HomeController.this.getClass().getResource("../views/jamila/InscriptionUtilisateur.fxml"));
        try {
            signupLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = signupLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("SIGN UP");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void SignInMethod(ActionEvent event) {
        FXMLLoader signinLoader = new FXMLLoader();
        signinLoader.setLocation(HomeController.this.getClass().getResource("../views/jamila/login.fxml"));
        try {
            signinLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = signinLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("SIGN IN");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void ShowUsersMethod(MouseEvent event) {
        FXMLLoader showUsersLoader = new FXMLLoader();
        showUsersLoader.setLocation(HomeController.this.getClass().getResource("../views/jamila/ShowUsers.fxml"));
        try {
            showUsersLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = showUsersLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("ALL USERS");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
    }
    //$$$$$$$$$$$$$$$$$$$ END USERS METHODS $$$$$$$$$$$$$$$$$$$
}
