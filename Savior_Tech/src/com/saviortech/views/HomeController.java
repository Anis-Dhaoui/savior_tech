/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.views;

import com.saviortech.models.Publication;
import com.saviortech.models.Commentaire;
import com.saviortech.models.Reaction;

import com.saviortech.services.MyListener;
import com.saviortech.services.ServiceCommentaire;

import com.saviortech.services.ServicePublication;
import com.saviortech.services.ServiceReaction;
import com.saviortech.views.ItemPublicationController;
import com.saviortech.views.ItemPublicationController;
import com.saviortech.views.ViewPublicationController;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.prefs.Preferences;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class HomeController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;

    ServicePublication sp = new ServicePublication();
    ServiceCommentaire sc = new ServiceCommentaire();
    ServiceReaction sr = new ServiceReaction();
    private List<Publication> pubs = sp.afficher();

    @FXML
    private Button addPub;
    private Preferences prefs;

    public static int idPub;
    public static int nbrCom = 0;
    public static int nbrJ = 0;
    public static int nbrJp =0;
    public static int idUtilisateur = 3  ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        MyListener myListener = new MyListener() {
            @Override
            public void onClickListener(Publication pub) {
                try {

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("viewPublication.fxml"));
                    Parent root2 = (Parent) fxmlLoader.load();

                    Stage stage = new Stage();
                    stage.setTitle("View publication");
                    stage.setScene(new Scene(root2));
                    stage.show();
                    ViewPublicationController vp = fxmlLoader.getController();
                    vp.setShowPublication(pub);
                    idPub = pub.getIdPublication();
                 

                } catch (IOException ex) {
                    ex.getMessage();
                }

            }

        };
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < pubs.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("itemPublication.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                List<Commentaire> coms = sc.afficher(pubs.get(i).getIdPublication());
                nbrCom = coms.size();
                List<Reaction> recs = sr.afficher(pubs.get(i).getIdPublication());
             
                nbrJ = recs.size();
            
                nbrJp = recs.size();
                ItemPublicationController itemController = fxmlLoader.getController();
                itemController.setData(pubs.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row); //(child,column,row)

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO
    }

    @FXML
    private void onActionAjouter(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AddPublication.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setTitle("Ajouter Publication");
        stage.setScene(new Scene(root1));
        stage.show();

    }

}
