/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers;

import com.saviortech.models.Publications;
import com.saviortech.services.ServicePublication;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import static javax.management.Query.value;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Marwen
 */
public class AddPublicationController implements Initializable {

    @FXML
    private TextField titreText;
    @FXML
    private TextField descriptionText;
    @FXML
    private Button imageButton;
    @FXML
    private Button ajouterPublication;
    @FXML
    private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML

    private void OnClickAjouterImage(ActionEvent event) throws FileNotFoundException, IOException {
      
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(null);
        
       
        
        if (file != null) {
            System.out.println("You chose to open this file: "
                    + file.getAbsolutePath());

            image.setImage(new Image(file.toURI().toString()));

        }
    }

    @FXML
    private void onClickAjouterPublication(ActionEvent event) {
        ServicePublication sp = new ServicePublication();
        if((titreText.getText().isEmpty())||(descriptionText.getText().isEmpty())){
           JOptionPane.showMessageDialog(null, "il y a un champ est vide!");  
        }else{
            
        
        sp.ajouter(new Publications(titreText.getText(), descriptionText.getText(), null, "active"));
       
       
    }}

}
