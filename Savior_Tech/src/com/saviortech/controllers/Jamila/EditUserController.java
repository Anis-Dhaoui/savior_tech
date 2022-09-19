/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * Lenovo
 */
public class EditUserController implements Initializable {

    @FXML
    private TextField labelUsername;
    @FXML
    private TextField labelFullname;
    @FXML
    private TextField labelEmail;
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
    String userId;
    private ShowUsersController suc = new ShowUsersController();
    @FXML
    private Label tfull;
    @FXML
    private Label tuser;
    @FXML
    private Button buttonchange;
    @FXML
    private Button buttonchange1;
    @FXML
    private PasswordField pass_field;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveChanges(ActionEvent event) {
        ServiceUtilisateur su = new ServiceUtilisateur();
        su.modifier(new Utilisateur(userId, labelFullname.getText(), labelUsername.getText(), labelEmail.getText(), pass_field.getText(), labelRole.getText(), labelDomain.getText(), labelInterest.getText(), labelSpeciality.getText()));
        JOptionPane.showMessageDialog(null, "User Changed !");
        Stage stage = (Stage) labelUsername.getScene().getWindow();
        stage.close();

    }

    //2 methods that will be used in ShowUsersController in order to edit user
    void setTextField(String id, String fullname, String username, String email, String password, String role, String interest, String domain, String speciality) {
        userId = id;
        labelFullname.setText(fullname);
        labelUsername.setText(username);
        labelEmail.setText(email);
        pass_field.setText(password);
        labelRole.setText(role);
        labelDomain.setText(domain);
        labelSpeciality.setText(speciality);
        labelInterest.setText(interest);
    }

    @FXML
    private void showChanges(ActionEvent event) {

        Stage stageedit = (Stage) labelUsername.getScene().getWindow();
        stageedit.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../views/jamila/ShowUsers.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ShowUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }

    void setTextField(String fullname, String username, String email, String password, String role, String interest, String domain, String speciality) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
