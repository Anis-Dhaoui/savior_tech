/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class InscriptionUtilisateurController implements Initializable {

    @FXML
    private TextField labelUsername;
    @FXML
    private TextField labelFullname;
    @FXML
    private TextField labelEmail;
    @FXML
    private TextField labelPassword;
    @FXML
    private TextField labelRole;
    @FXML
    private TextField labelDomain;
    @FXML
    private TextField labelInterest;
    @FXML
    private TextField labelSpeciality;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignupUser(ActionEvent event){
        ServiceUtilisateur su = new ServiceUtilisateur();
        su.ajouter(new Utilisateur(labelFullname.getText(), labelUsername.getText(), labelEmail.getText(), labelPassword.getText(), labelRole.getText(), labelDomain.getText(), labelInterest.getText(), labelSpeciality.getText()));
        JOptionPane.showMessageDialog(null, "Merci pour votre inscription!");
    }
    
}
