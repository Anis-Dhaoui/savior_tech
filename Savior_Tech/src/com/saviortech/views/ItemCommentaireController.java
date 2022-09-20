/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.views;

import com.saviortech.views.HomeControllerPublication;
import com.saviortech.models.Commentaire;
import com.saviortech.services.ServiceCommentaire;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Marwen
 */
public class ItemCommentaireController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label des;
    @FXML
    private Button suppCom;
ServiceCommentaire sc = new ServiceCommentaire();
    public void setData(Commentaire com ) {

        nom.setText(com.getNom());
        des.setText(com.getDescription());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
              suppCom.setVisible(true);
      
        


        // TODO
    }

    @FXML
    private void onClickSupprimer(ActionEvent event) {
        
        JOptionPane.showMessageDialog(null,"idUt"+HomeControllerPublication.idUtilisateur);
    }

}
