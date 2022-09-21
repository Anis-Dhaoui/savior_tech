/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.controllers.HomeController;
import com.saviortech.models.CurrentUser;
import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;

import static com.saviortech.utils.PasswordHash.getMd5;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private Button shp;
    @FXML
    private TextField pass_text;
    @FXML
    private Button submitButton1;

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
    private void Login(ActionEvent event) throws SQLException, IOException {

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
        List<Utilisateur> list = auth.validate(username, password);

        if (list.size() == 0) {
            System.out.println(list);
            infoBox("Please enter correct usename and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "SUCCESS");
            System.out.println(list);

            CurrentUser cu = new CurrentUser();
            cu.setUserInfo(list);
            System.out.println(list);
            
            //Call this method in order to hide sign in and sign up buttons and show profile image and username
            HomeController.checkIfUserAuthenticated();

            Stage loginStage = (Stage) tfusername.getScene().getWindow();
            loginStage.close();

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

    @FXML
    private void inscription(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../views/jamila/InscriptionUtilisateur.fxml"));
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

    @FXML
    private void resetPassword(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../views/jamila/ResetPassword.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ShowUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();

        Stage loginStage = (Stage) tfusername.getScene().getWindow();
        loginStage.close();
    }
}
