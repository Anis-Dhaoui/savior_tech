/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.QR;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.saviortech.models.AimeQuestion;
import com.saviortech.models.Question;
import com.saviortech.services.AimeService;
import com.saviortech.services.QuestionService;
import com.saviortech.utils.Static;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class UpdateController implements Initializable {

    @FXML
    private JFXTextField tittre;
    @FXML
    private TextArea description;
    @FXML
    private Text id;
    @FXML
    private JFXButton btn;
    @FXML
    private ImageView imgs;
    @FXML
    private Text idimg;
File file;
int i;
    @FXML
    private Text idimg1;
    @FXML
    private VBox contenu;
    @FXML
    private VBox vbox;
    public void setTittre(String tittre) {
        this.tittre.setText(tittre);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setId(String id) {
        this.id.setText(id);
    }


    public void setImgs(Image imgs) {
        this.imgs.setImage(imgs);
    }

    public void setIdimg(String idimg) {
        this.idimg.setText(idimg);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void annuler(ActionEvent event) {
         Node  source = (Node)  event.getSource(); 
  Stage stage  = (Stage) source.getScene().getWindow();
  stage.close();
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
                        idimg1.setText(path);
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
    private void update(ActionEvent event) {
       
            QuestionService qs=new QuestionService();
            if(idimg.getText().equals(idimg1.getText())||idimg1.getText().isEmpty()){
                qs.modifier(new Question(description.getText(), tittre.getText(),Integer.parseInt(id.getText())));
                
            }
            else{
                try {
                    Path fromFile = Paths.get(file.getAbsolutePath());
                    Path toFile = Paths.get("C:/xampp/htdocs/img/", String.valueOf(i));
                    Files.copy(fromFile, toFile);
                } catch (IOException ex) {
                    Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
                }
                qs.modifier(new Question(description.getText(), tittre.getText(), idimg1.getText(),Integer.parseInt(id.getText())));
            }
            Notifications notification=Notifications.create()
                    .title("Information")
                    .text("Votre Question a été changer ")
                    .graphic(null)
                    .hideAfter(Duration.seconds(2))
                    .position(Pos.TOP_RIGHT);
            notification.darkStyle();
            notification.show();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../views/QR/Statut.fxml"));
             try {
            Parent root = (Parent) loader.load();
            id.getScene().setRoot(root);
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
                 List<AimeQuestion> aq=new AimeService().afficher(Integer.parseInt(id.toString()),Static.getIduser());     
                System.out.println(aq);
            }   } catch (IOException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @FXML
    private void pub(MouseEvent event) {
    }

    @FXML
    private void QR(MouseEvent event) {
    }
    
}
