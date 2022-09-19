/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.services.ServiceUtilisateur;
import com.saviortech.utils.EmailSender;
import com.saviortech.utils.PasswordGenerator;
import com.saviortech.utils.PasswordHash;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class ResetPasswordController implements Initializable {

    @FXML
    private AnchorPane anchorpass;
    @FXML
    private TextField idemail;
    @FXML
    private Button buttonpass;

    String generatedPassword = PasswordGenerator.getRandomPassword();
     private String newPassword = "<h1> Your new password is " + generatedPassword + "</h1>";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void resetMyPassword(ActionEvent event) throws MessagingException {
        EmailSender eSender = new EmailSender();
        ServiceUtilisateur su = new ServiceUtilisateur();
        su.updateUserPass(new PasswordHash().getMd5(generatedPassword), idemail.getText());
        eSender.sendEmail(idemail.getText(), "Reset Password", newPassword);
        
        JOptionPane.showMessageDialog(null, "A new password has been sent to: " + idemail.getText());
        Stage loginStage = (Stage) idemail.getScene().getWindow();
        loginStage.close();
    }
    
}
