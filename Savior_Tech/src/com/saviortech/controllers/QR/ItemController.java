/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.QR;

import com.jfoenix.controls.JFXButton;
import com.saviortech.models.AimeQuestion;
import com.saviortech.models.Question;
import com.saviortech.models.Reponse;
import com.saviortech.services.AimeService;
import com.saviortech.services.QuestionService;
import com.saviortech.services.ReponseService;
import com.saviortech.utils.Static;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class ItemController implements Initializable {

    @FXML
    private Text date;
    @FXML
    private Text titre;
    @FXML
    private Label description;
    @FXML
    private ImageView image;
    private Question question;
    @FXML
     Text id;
    @FXML
    private HBox box;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton jaim;
    @FXML
    private HBox idComment;
    @FXML
    private TextField commentaire;

    public void setJaim(String jaim) {
        this.jaim.setText(jaim);
    }
        public WritableImage implementImage(String imgUrl) throws MalformedURLException, IOException {
        BufferedImage deck;
        try {
            deck = ImageIO.read(new URL(imgUrl));
//            deck = ImageIO.read(getClass().getResourceAsStream("../../images/inscription.jpg"));
        } catch (Exception e) {
            deck = ImageIO.read(getClass().getResourceAsStream("../../images/inscription.jpg"));
        }
        BufferedImage tempCard = deck.getSubimage(0, 0, deck.getWidth(), deck.getHeight());
        WritableImage card = SwingFXUtils.toFXImage(tempCard, null);

        return card;
    }
    public void setData(Question question) throws IOException {
        
        this.question = question;
         Date d = question.getCreatedAt();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                String strDate = dateFormat.format(d); 
                id.setText(String.valueOf(question.getId()));
        titre.setText(question.getTitre());
       description.setText(question.getDescription());
        date.setText(strDate);
        if(question.getImage()!=null){
            image.setFitHeight(150);
            image.setFitWidth(400);
        image.setImage(implementImage(question.getImage()));
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void Affiche(MouseEvent event) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Statut.fxml"));
      Static.setId(id.getText()); 
      Static.setImg(question.getImage());
        try {
            Parent root = loader.load();
            id.getScene().setRoot(root);
            StatutController dpc = loader.getController();           
           dpc.id.setText(id.getText());
           dpc.setDescription(description.getText());
           dpc.setTitre(titre.getText());
           dpc.setDate(date.getText());
           dpc.setJaim(jaim.getText());
           if(question.getImage()!=null){
            dpc.image.setFitHeight(100);
            dpc.image.setFitWidth(300);
        Image img = new Image(new FileInputStream(question.getImage()));
        dpc.setImage(img);
        }
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void jaime(ActionEvent event) {
        if(jaim.getText().equals("J'aime")){
        AimeService as=new AimeService();
        as.ajouter(new AimeQuestion(Static.getIduser(),id.getText()));
        jaim.setText("J'aime Pas");
        }
        else if(jaim.getText().equals("J'aime Pas")){
                   AimeService as=new AimeService();
        as.supprimer(new AimeQuestion(Static.getIduser(),id.getText()));    
        jaim.setText("J'aime");
        
        }
        /* try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
                Parent root = (Parent) loader.load();
                description.getScene().setRoot(root);

                } catch (IOException ex) {
                Logger.getLogger(StatutController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
    }

    @FXML
    private void zoom(MouseEvent event) throws FileNotFoundException {
         Static.setImg(question.getImage());
         Stage secondStage = new Stage();
        Label name = new Label(question.getImage());
        Image image = new Image(new FileInputStream(Static.getImg()));
        ImageView imageView = new ImageView();
        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0,0,0,0));
        vbox.getChildren().addAll(name, imageView);
       imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);
        imageView.setImage(image);
        imageView.setSmooth(true);
        imageView.setCache(true);
        
        Scene scene = new Scene(new VBox(), 700, 500);
         ((VBox)scene.getRoot()).getChildren().addAll(vbox);
        secondStage.setScene(scene);
        secondStage.show();
    }

    @FXML
    private void action(ActionEvent event) {

       box.setVisible(true);
       
        }

    @FXML
    private void modifier(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Update.fxml"));
        try {
           Parent root = (Parent) loader.load();
            description.getScene().setRoot(root);
            UpdateController update=loader.getController();
            update.setId(id.getText());
            update.setDescription(description.getText());
            update.setTittre(titre.getText());
            update.setIdimg(question.getImage());
            update.setImgs(image.getImage());
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
            QuestionService qs=new QuestionService();
            Question question= new Question(id.getText());
            qs.supprimer(question);
      Alert  alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Question Supprimé:");
		alert.setContentText("Votre Question a été Supprimé  !");
		alert.showAndWait();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
            try {
            Parent root = loader.load();
            description.getScene().setRoot(root);
            Static.setRecherche(null);
        } catch (IOException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }

    @FXML
    private void comment(ActionEvent event) {
           idComment.setVisible(true);
    }

    @FXML
    private void AjouterPub(MouseEvent event) {
    }

    @FXML
    private void comenter(ActionEvent event) {
      Alert alert;
        if(commentaire.getText().isEmpty())
        {
              alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Alert");
		alert.setHeaderText("Champs vide:");
		alert.setContentText("Completer Votre Commentaire s'il vous plait  !");
		alert.showAndWait();
        }
        else{
                ReponseService rs = new ReponseService();
                Reponse R=new Reponse(commentaire.getText(),id.getText(),String.valueOf(Static.getIduser()));
                rs.ajouter(R);
                          alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Commentaire ajoutée:");
		alert.setContentText("Votre Commentaire a été ajoutée  !");
		alert.showAndWait();
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
                Parent root = (Parent) loader.load();
                description.getScene().setRoot(root);

                } catch (IOException ex) {
                Logger.getLogger(StatutController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    
    
    
}
