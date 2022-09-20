/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;
import com.saviortech.utils.PasswordHash;
import com.saviortech.utils.PopupMessage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import com.saviortech.utils.ControlSaisie;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * LENOVO
 */
public class InscriptionUtilisateurController implements Initializable {

    @FXML
    private TextField labelUsername;
    @FXML
    private TextField labelFullname;
    @FXML
    private TextField labelEmail;
    @FXML
    private ComboBox<String> labelDomain;
    @FXML
    private ComboBox<String> labelInterest;
    @FXML
    private ComboBox<String> labelSpeciality;
    @FXML
    private Button inscription;
    @FXML
    private ComboBox<String> LabelRole;
    @FXML
    private Button SignIn;
    @FXML
    private Button shps;
    @FXML
    private TextField pass_text;
    @FXML
    private PasswordField pass_field;

    /**
     * Initializes the controller class.
     */
    @Override

    // TODO
    public void initialize(URL url, ResourceBundle rb) {
        pass_text.setVisible(false);
        System.out.println(shps.getText());
        LabelRole.getItems().add("Engineer");
        LabelRole.getItems().add("Technician");
        LabelRole.getItems().add("Coach");
        LabelRole.getItems().add("Designer");
        LabelRole.getItems().add("Devlopper Front-end");
        LabelRole.getItems().add("Devlopper Back-end");
        LabelRole.getItems().add("Devlopper FullStack");
        labelDomain.getItems().addAll("Data Science", "Artificiel Intellegent", "Cloud Computing", "Cyber Sectrity", "Degital", "Web Developpement");
        labelInterest.getItems().addAll("Data Science", "Artificiel Intellegent", "Cloud Computing", "Cyber Sectrity", "Degital", "Web Developpement");
        labelSpeciality.getItems().addAll("Data Science", "Artificiel Intellegent", "Cloud Computing", "Cyber Sectrity", "Degital", "Web Developpement");

    }

    @FXML
    private void SignupUser(ActionEvent event) {

        ServiceUtilisateur su = new ServiceUtilisateur();
        ControlSaisie cs = new ControlSaisie();
        String hashedPass = new PasswordHash().getMd5(pass_field.getText());
        Window onAjouterClicked = inscription.getScene().getWindow();
        if (labelUsername.getText().isEmpty() || labelFullname.getText().isEmpty() || labelEmail.getText().isEmpty() || pass_field.getText().isEmpty()
                || LabelRole.getItems().isEmpty() || labelDomain.getItems().isEmpty() || labelInterest.getItems().isEmpty() || labelSpeciality.getItems().isEmpty()) {

            PopupMessage.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "All fields are required!");
        } else if (!cs.controlEmail(labelEmail.getText())) {
            PopupMessage.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "please type a valid email address");
        } else if (!cs.controlPassword(pass_field.getText())) {
            PopupMessage.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "please type a valid passwords");

        } else {
            su.ajouter(new Utilisateur(labelFullname.getText(), labelUsername.getText(), labelEmail.getText(), hashedPass, LabelRole.getValue(), labelDomain.getValue(), labelInterest.getValue(), labelSpeciality.getValue()));

            JOptionPane.showMessageDialog(null, "Merci pour votre inscription!");
        }
    }

    @FXML
    private void sHidePassword(ActionEvent event) {

        if ("Show".equals(shps.getText())) {
            pass_text.setText(pass_field.getText());
            pass_text.setVisible(true);
            pass_field.setVisible(false);
            shps.setText("Hide");
        } else {
            pass_field.setText(pass_text.getText());
            pass_field.setVisible(true);
            pass_text.setVisible(false);
            shps.setText("Show");
        }
    }

    @FXML
    private void SignInUser(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../views/jamila/login.fxml"));
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
}
