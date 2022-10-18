/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.QR;

import com.jfoenix.controls.JFXButton;
import com.saviortech.models.Question;
import com.saviortech.models.Reponse;
import com.saviortech.services.QuestionService;
import com.saviortech.services.ReponseService;
import com.saviortech.utils.Static;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class CommentController implements Initializable {

    @FXML
    private Text date;
    @FXML
    private Text id;
    @FXML
    private Text nom;
    @FXML
    private Label description;
    private Reponse reponse;
    @FXML
    private HBox box;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
    @FXML
    private TextField comment;
    @FXML
    private HBox hboxupdate;
    
 public void Data(Reponse reponse) throws IOException {
        
        this.reponse = reponse;
         Date d = reponse.getDate();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                String strDate = dateFormat.format(d); 
                id.setText(String.valueOf(reponse.getIdReponse()));
        nom.setText(reponse.getIdUser());
       description.setText(reponse.getMessage());
       comment.setText(reponse.getMessage());
       date.setText(strDate);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Affiche(MouseEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
           hboxupdate.setVisible(true);
    }

    @FXML
    private void supprimer(ActionEvent event) {
  
        try {
            ReponseService qs=new ReponseService();
            Reponse rp= new Reponse(reponse.getIdReponse());
            qs.supprimer(rp);
            JOptionPane.showMessageDialog(null, "Reponse Supprimée  !");
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Statut.fxml"));
            Parent root = (Parent) loader.load();
            date.getScene().setRoot(root);
            StatutController sc=loader.getController();
            List<Question> list = new QuestionService().afficher(Static.getId());
             sc.setId(String.valueOf(list.get(0).getIdQuestion()));
        sc.setDate(String.valueOf(list.get(0).getDate()));
        sc.setDescription(list.get(0).getDescription());
        sc.setTitre(list.get(0).getTitre());
        if(list.get(0).getImage()!=null){
            sc.image.setFitHeight(100);
            sc.image.setFitWidth(300);
         Image img = new Image(new FileInputStream(list.get(0).getImage()));
        sc.setImage(img);
        }

        } catch (IOException ex) {
            Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void action(ActionEvent event) {
          box.setVisible(true);
    }

    @FXML
    private void AjouterPub(MouseEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
         if(comment.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Votre Commentaire !");
        else{
        try {
        ReponseService rs = new ReponseService();
                Reponse R=new Reponse(comment.getText(),reponse.getIdReponse());
                rs.modifier(R);
                JOptionPane.showMessageDialog(null, "Mettre a jour Commentaire  !");
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Statut.fxml"));
            Parent root = (Parent) loader.load();
            date.getScene().setRoot(root);
            StatutController sc=loader.getController();
            List<Question> list = new QuestionService().afficher(Static.getId());
                    sc.setId(String.valueOf(list.get(0).getIdQuestion()));
        sc.setDate(String.valueOf(list.get(0).getDate()));
        sc.setDescription(list.get(0).getDescription());
        sc.setTitre(list.get(0).getTitre());
        if(list.get(0).getImage()!=null){
            sc.image.setFitHeight(100);
            sc.image.setFitWidth(300);
        Image img = new Image(getClass().getResourceAsStream(list.get(0).getImage()));
        sc.setImage(img);
        }

        } catch (IOException ex) {
            Logger.getLogger(CommentController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }
    
}
