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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
import javafx.util.Duration;
import javax.management.Notification;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class StatutController implements Initializable {

    @FXML
    private Text date;
    @FXML
    public Text id;
    @FXML
     ImageView image;
    @FXML
    private Text titre;
    @FXML
    private Label description;
    
    private Question question;
    
    @FXML
    private VBox contenu;
    @FXML
    private VBox vbox;
    @FXML
    private GridPane grid;
    @FXML
    private VBox vbox1;
    @FXML
    private ScrollPane scrol;
    @FXML
    private HBox hbox;
    @FXML
    private TextField commentaire;
    @FXML
    private HBox box;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton jaim;
    public void setDate(String date) {
        this.date.setText(date);
    }

    public void setId(String id) {
        this.id.setText(id);
   }

    public void setImage(Image imge) {
       this.image.setImage(imge);
      
    }

    public void setTitre(String titre) {
        this.titre.setText(titre);
    }


    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setJaim(String jaim) {
        this.jaim.setText(jaim);
    }
    
    /**
     * Initializes the controller class.
     */
    
    List<Reponse> liste = new ReponseService().afficher(Static.getId());
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        int column = 1;
        int row = 1;
        for (int i = 0; i < liste.size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../../views/QR/Comment.fxml"));
                Pane anchorPane= fxmlLoader.load();
                CommentController commentController = fxmlLoader.getController();
                commentController.Data(liste.get(i));
                grid.add(anchorPane, column, row++); //(child,column,row)
                GridPane.setMargin(anchorPane, new Insets(10));
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void jaime(ActionEvent event) {
         if(jaim.getText().equals("J'aime")){
        AimeService as=new AimeService();
        as.ajouter(new AimeQuestion(Static.getIduser(),Integer.parseInt(id.getText())));
        jaim.setText("J'aime Pas");
        }
        else if(jaim.getText().equals("J'aime Pas")){
                   AimeService as=new AimeService();
        as.supprimer(new AimeQuestion(Static.getIduser(),Integer.parseInt(id.getText())));    
        jaim.setText("J'aime");
        }
    }
    
    @FXML
    private void zoom(MouseEvent event) throws FileNotFoundException {
         Stage secondStage = new Stage();
        Label name = new Label(Static.getImg());
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
                Reponse R=new Reponse(commentaire.getText(),Static.getId(), String.valueOf(Static.getIduser()));
                rs.ajouter(R);
                 Notifications notification=Notifications.create()
                .title("Information")  
                .text("Votre Commentaire a été Ajouté ")
                .graphic(null)
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT);
        notification.darkStyle();
        notification.show();
                try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Statut.fxml"));
                Parent root = (Parent) loader.load();
                grid.getScene().setRoot(root);
                StatutController dpc = loader.getController();
                dpc.id.setText(id.getText());
                dpc.setDescription(description.getText());
                dpc.setTitre(titre.getText());
                dpc.setDate(date.getText());
                if(Static.getImg()!=null){
                    dpc.image.setFitHeight(100);
                    dpc.image.setFitWidth(300);
                    Image img = new Image(new FileInputStream(Static.getImg()));
                    dpc.setImage(img);
                    
                    
                }       } catch (IOException ex) {
                Logger.getLogger(StatutController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Update.fxml"));
            Parent root = (Parent) loader.load();
            box.getScene().setRoot(root);
            UpdateController update=loader.getController();
            update.setId(id.getText());
            update.setDescription(description.getText());
            update.setTittre(titre.getText());
            update.setImgs(image.getImage());
        } catch (IOException ex) {
            Logger.getLogger(StatutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
             QuestionService qs=new QuestionService();
            Question question= new Question(Integer.parseInt(id.getText()));
                Alert  alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Alert");
		alert.setHeaderText("Question Supprimé:");
		alert.setContentText("Vous voulez supprimer votre Question  !");
		alert.showAndWait();     
            qs.supprimer(question);
                Notifications notification=Notifications.create()
                .title("Information")  
                .text("Votre Question a été Supprimé ")
                .graphic(null)
                .hideAfter(Duration.seconds(2))
                .position(Pos.TOP_RIGHT);
        notification.darkStyle();
        notification.show();
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
    private void action(ActionEvent event) {
          box.setVisible(true);
    }

    @FXML
    private void QR(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
        try {
           Parent root = (Parent) loader.load();
            vbox.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouterPub(MouseEvent event) {
    }

    @FXML
    private void comment(ActionEvent event) {
        Notifications notification=Notifications.create()
                .title("merci")  
                .text("text")
                .graphic(null)
                .hideAfter(Duration.seconds(2))
                .position(Pos.BASELINE_CENTER);
        notification.darkStyle();
        notification.show();
                }
}
