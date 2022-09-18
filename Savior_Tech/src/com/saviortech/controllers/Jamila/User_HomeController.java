/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.models.CurrentUser;
import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class User_HomeController implements Initializable {

    @FXML
    private ImageView imgprofile;
    @FXML
    private Label fuul;
    @FXML
    private Label fuul1;
    @FXML
    private HBox setting111;
    @FXML
    private HBox setting;
    @FXML
    private HBox notification;
    @FXML
    private HBox setting1;
    @FXML
    private HBox setting11;
    @FXML
    private Button editprofile;
    @FXML
    private TextField fullname;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField role;
    @FXML
    private TextField domain;
    @FXML
    private TextField interest;
    @FXML
    private TextField speciality;

    CurrentUser cu = new CurrentUser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cu.setUserInfo(new ServiceUtilisateur().validate("jamila", "9ae48df22b0715e18485142038a890cf"));

        } catch (SQLException ex) {
            Logger.getLogger(User_HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(cu.getUserInfo());
        fullname.setText(cu.getUserInfo().get(0).getFullname());
        username.setText(cu.getUserInfo().get(0).getUsername());
        email.setText(cu.getUserInfo().get(0).getEmail());
        role.setText(cu.getUserInfo().get(0).getRole());
        domain.setText(cu.getUserInfo().get(0).getDomain());
        interest.setText(cu.getUserInfo().get(0).getInterest());
        speciality.setText(cu.getUserInfo().get(0).getSpeciality());

    }

    @FXML
    private void saveChange(ActionEvent event) {

        /* ServiceUtilisateur su = new ServiceUtilisateur();
        su.modifier(new Utilisateur( fullname.getText(), username.getText(), email.getText(), role.getText(), domain.getText(), interest.getText(), speciality.getText()));
     //   suc.refrechUserList();
        JOptionPane.showMessageDialog(null, "User Changed !");*/
    }

}