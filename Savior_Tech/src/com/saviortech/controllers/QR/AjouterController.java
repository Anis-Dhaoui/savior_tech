/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.QR;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.saviortech.models.Question;
import com.saviortech.services.QuestionService;
import com.saviortech.utils.DataSource;
import com.saviortech.utils.Static;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class AjouterController implements Initializable {

    @FXML
    public static VBox vbox;
List<Question> es = new QuestionService().afficher();

    @FXML
    private VBox contenu;
    @FXML
    private JFXTextField tittre;
    @FXML
    private TextArea description;
    @FXML
    private TextField id;
    @FXML
    private JFXButton btn;
    @FXML
    private ImageView imgs;
    @FXML
    private Text idimg;
    File file;
    int i;
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
            
    }




    @FXML
    private void upload(ActionEvent event) throws IOException {
        final FileChooser fileChooser = new FileChooser();

        btn.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    setExtFilters(fileChooser);
                    file = fileChooser.showOpenDialog(null);
                    
                    
                    if (file != null) {
                        i=file.hashCode();
                        String path = "C:/xampp/htdocs/img/"+String.valueOf(i);
                        idimg.setText(path);
                        imgs.setFitHeight(200);
                        imgs.setFitWidth(600);
                        Image img = new Image(file.toURI().toString());
                        imgs.setImage(img);
                    }
                }
            });
    }
     private void setExtFilters(FileChooser chooser){
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
         
    }

    @FXML
    private void Ajouter(ActionEvent event) {
         QuestionService qs = new QuestionService();
         if(tittre.getText().isEmpty()||description.getText().isEmpty()){
             
    Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Alert");
		alert.setHeaderText("Champs vide:");
		alert.setContentText("Completer les champs de formulaire s'il vous plait  !");
		alert.showAndWait();
           
         }
          if(!idimg.getText().isEmpty()){
              
             try {
                 Path fromFile = Paths.get(file.getAbsolutePath());
                 Path toFile = Paths.get("C:/xampp/htdocs/img/", String.valueOf(i));  
                 Files.copy(fromFile, toFile);
                 qs.ajouter(new Question(id.getText(), description.getText(), tittre.getText(), idimg.getText().toString()));
             } catch (IOException ex) {
                 Logger.getLogger(AjouterController.class.getName()).log(Level.SEVERE, null, ex);
             }
}
          else{
            qs.ajouter(new Question(id.getText(), description.getText(), tittre.getText()));  
          }
           Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Question ajoutée:");
		alert.setContentText("Votre Question a été ajoutée  !");
		alert.showAndWait();
  FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
        try {
           Parent root = (Parent) loader.load();
            id.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @FXML
    private void annuler(ActionEvent event) {

   FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
        try {
           Parent root = (Parent) loader.load();
            tittre.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void QR(MouseEvent event) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Question.fxml"));
        try {
           Parent root = (Parent) loader.load();
            tittre.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }




}
