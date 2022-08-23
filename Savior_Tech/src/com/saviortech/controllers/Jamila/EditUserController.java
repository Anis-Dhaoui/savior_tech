/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;


import com.saviortech.controllers.Jamila.ShowUsersController;
import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class EditUserController implements Initializable {

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
    int userId;
    private ShowUsersController suc = new ShowUsersController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        ServiceUtilisateur su = new ServiceUtilisateur();
        su.modifier(new Utilisateur(userId, labelFullname.getText(), labelUsername.getText(), labelEmail.getText(), labelPassword.getText(), labelRole.getText(), labelDomain.getText(), labelInterest.getText(), labelSpeciality.getText()));
        suc.refrechUserList();
        JOptionPane.showMessageDialog(null, "Personne modifié !");
    }

    //2 methods that will be used in ShowUsersController in order to edit user

    void setTextField(int id, String fullname, String username, String email, String password, String role, String interest, String domain, String speciality) {
        userId = id;
        labelFullname.setText(fullname);
        labelUsername.setText(username);
        labelEmail.setText(email);
        labelPassword.setText(password);
        labelRole.setText(role);
        labelDomain.setText(domain);
        labelSpeciality.setText(speciality);
        labelInterest.setText(interest);
    }
}
