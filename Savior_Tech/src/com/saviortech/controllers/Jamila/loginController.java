/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;
import com.saviortech.utils.PasswordHash;
import static com.saviortech.utils.PasswordHash.getMd5;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class loginController implements Initializable {

    @FXML
    private TextField tfusername;
    @FXML
    private PasswordField tfpassword;
    @FXML
    private Button submitButton;
    @FXML
    private AnchorPane loginpane;
    @FXML
    private Button submitclosing;
    @FXML
    private Button shp;
    @FXML
    private TextField pass_text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pass_text.setVisible(false);
        System.out.println(shp.getText());
        // TODO
    }

    /*
        String hashedPass = new PasswordHash().getMd5(tfpassword.getText());
        ServiceUtilisateur su = new ServiceUtilisateur();
        su.auth(new Utilisateur(tfusername.getText(), hashedPass));
     */
    @FXML
    private void Login(ActionEvent event) throws SQLException {

        Window owner = submitButton.getScene().getWindow();

        System.out.println(tfusername.getText());
        System.out.println(tfpassword.getText());

        if (tfusername.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your username");
            return;
        }
        if (tfpassword.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String username = tfusername.getText();
        String password = getMd5(tfpassword.getText());

        ServiceUtilisateur auth = new ServiceUtilisateur();
        boolean flag = auth.validate(username, password);

        if (!flag) {
            infoBox("Please enter correct usename and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Failed");
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    @FXML
    private void closing(ActionEvent event) {
    }

    @FXML
    private void ShowHidePassword(ActionEvent event) {
        if ("Show".equals(shp.getText())) {
            pass_text.setText(tfpassword.getText());
            pass_text.setVisible(true);
            tfpassword.setVisible(false);
            shp.setText("Hide");
        } else {
            tfpassword.setText(pass_text.getText());
            tfpassword.setVisible(true);
            pass_text.setVisible(false);
            shp.setText("Show");
        }
    }
}
