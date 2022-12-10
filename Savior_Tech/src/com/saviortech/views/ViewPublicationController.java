/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.views;

import com.jfoenix.controls.JFXButton;
import com.saviortech.controllers.HomeController;
import com.saviortech.models.Publications;
import com.saviortech.models.Commentaires;
import com.saviortech.models.Reactions;
import com.saviortech.services.ServiceCommentaire;
import com.saviortech.services.ServicePublication;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Marwen
 */
public class ViewPublicationController implements Initializable {

    @FXML
    private Label showTitre;
    @FXML
    private Text showDescription;
    private GridPane gridPaneCom;

    ServiceCommentaire sc = new ServiceCommentaire();
    ServicePublication sp = new ServicePublication();
    // ServiceReaction sr = new ServiceReaction();

    @FXML
    private TextField desComAjouter;
    @FXML
    private Button AjouterDes;
    @FXML
    private JFXButton modifierPub;
    @FXML
    private JFXButton supprimerPub;
    @FXML
    private HBox hboxModifier;
    @FXML
    private TextField textModif;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setShowPublication(Publications pub) {

        showTitre.setText(pub.getTitre());
        showDescription.setText(pub.getDescription());

        List<Commentaires> coms = sc.afficher(pub.getId());
        System.err.println(coms.size());

        int column = 0;
        int row = 1;
        try {

            for (int i = 0; i < coms.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("itemCommentaire.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemCommentaireController itemComController = fxmlLoader.getController();
                itemComController.setData(coms.get(i));

                if (column == 0) {
                    column = 0;
                    row++;
                }
                gridPaneCom.add(anchorPane, column++, row); //(child,column,row)
                gridPaneCom.setMargin(anchorPane, new Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void onClickAjouter(ActionEvent event) {
        if (desComAjouter.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "le champ est vide!");
        } else {

            sc.ajouter(new Commentaires(null, desComAjouter.getText(), null));
            desComAjouter.clear();
            desComAjouter.setPromptText("Ecrivez un commentaire");
            JOptionPane.showMessageDialog(null, "Commentaire ajoutée !");

        }

    }

    @FXML
    private void onClickModifier(ActionEvent event) {
        hboxModifier.setVisible(true);
        textModif.setText(showDescription.getText());
    }

    @FXML
    private void onClickSupprimer(ActionEvent event) {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.out.println("No button clicked");
        } else if (response == JOptionPane.YES_OPTION) {
            System.err.println(HomeController.idPub);
            sp.supprimer(HomeController.idPub);
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("JOptionPane closed");
        }
    }

    @FXML
    private void onModifier(ActionEvent event) {

        //   sp.modifier(new Publications(HomeController.idPub,textModif.getText()));
        hboxModifier.setVisible(false);
        JOptionPane.showMessageDialog(null, "Modifieé");

    }

    @FXML
    private void onClickJaime(ActionEvent event) {
        //     sr.ajouter(new Reaction("jaime", HomeController.idUtilisateur,HomeController.idPub));
        JOptionPane.showMessageDialog(null, "J'aime");
    }

    @FXML
    private void onClickJaimePas(ActionEvent event) {
        //   sr.ajouter(new Reaction("jaimepas", HomeController.idUtilisateur,HomeController.idPub));
        JOptionPane.showMessageDialog(null, "J'aime pas");
    }

}
