/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.QR;

import com.saviortech.models.AimeQuestion;
import com.saviortech.models.Question;
import com.saviortech.services.AimeService;
import com.saviortech.services.QuestionService;
import com.saviortech.utils.Static;
import java.io.IOException;
import java.sql.Date;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class QuestionController implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private GridPane grid;

    @FXML
    private VBox contenu;
    @FXML
    private HBox hbox;
    @FXML
    private ScrollPane scrol;
    @FXML
    private TextField recherch;
    List<Question> es  ;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 if(Static.getRecherche()==null){
         es  = new QuestionService().afficher();
 }
 else{
      es  = new QuestionService().recherche(Static.getRecherche());
 }
 if(es.size()==0){
     JOptionPane.showMessageDialog(null, "Aucun resultat !");
      es  = new QuestionService().afficher();
 }
        int column = 0;
        int row = 1;
         for (int i = 0; i < es.size(); i++) {
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../../views/QR/Item.fxml"));
                Pane anchorPane= fxmlLoader.load();
                ItemController ItemController = fxmlLoader.getController();
                ItemController.setData(es.get(i));
                List<AimeQuestion> aq=new AimeService().afficher(es.get(i).getId(),Static.getIduser());
                for(int j =0;j<aq.size();j++){
           if(aq.get(j).getIdQuestion()==es.get(i).getId()){
              ItemController.setJaim("J'aime Pas");
               
           }
       }
                if (column == 3) {
                column = 0;
                row++;
                }
                grid.add(anchorPane, column, row++); //(child,column,row)
                GridPane.setMargin(anchorPane, new Insets(10));
                } catch (IOException ex) {
                System.out.println(ex);
                } 
       }
            
    }



    @FXML
    private void AjouterPub(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Ajouter.fxml"));
        try {
           Parent root = (Parent) loader.load();
            vbox.getScene().setRoot(root);
            /*Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Poser votre Question");
            stage.setScene(new Scene(root1));  
            stage.show();*/ 
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void Chercher(MouseEvent event) {
       Static.setRecherche(recherch.getText());
       
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
        try {
           Parent root = (Parent) loader.load();
            vbox.getScene().setRoot(root);
            es  = new QuestionService().recherche(Static.getRecherche());
             System.out.println(es);
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void QR(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
        try {
           Parent root = (Parent) loader.load();
            vbox.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
