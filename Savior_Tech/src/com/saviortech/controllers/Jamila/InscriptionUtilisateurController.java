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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

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
    private ComboBox<String> labelDomain;
    @FXML
    private ComboBox<String> labelInterest;
    @FXML
    private ComboBox<String> labelSpeciality;
    @FXML
    private Button inscription;
    @FXML
    private ComboBox<String> LabelRole;

    /**
     * Initializes the controller class.
     */
    @Override

    // TODO
    public void initialize(URL url, ResourceBundle rb) {
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
        String hashedPass = new PasswordHash().getMd5(labelPassword.getText());
        Window onAjouterClicked = inscription.getScene().getWindow();
        if (labelUsername.getText().isEmpty() || labelFullname.getText().isEmpty() || labelEmail.getText().isEmpty() || labelPassword.getText().isEmpty()
                || LabelRole.getValue().isEmpty() || labelDomain.getValue().isEmpty() || labelInterest.getValue().isEmpty() || labelSpeciality.getValue().isEmpty()) {

            PopupMessage.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "All fields are required!");
        }
        if (!cs.controlEmail(labelEmail.getText())) {
            PopupMessage.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "please type a valid email address");
        }
        if (!cs.controlPassword(labelPassword.getText())) {
            PopupMessage.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "please type a valid passwords");

        } else {
            su.ajouter(new Utilisateur(labelFullname.getText(), labelUsername.getText(), labelEmail.getText(), hashedPass, LabelRole.getValue(), labelDomain.getValue(), labelInterest.getValue(), labelSpeciality.getValue()));

            JOptionPane.showMessageDialog(null, "Merci pour votre inscription!");
        }
    }

}
