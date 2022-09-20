/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.views;

import com.saviortech.models.Publication;

import com.saviortech.services.MyListener;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Marwen
 */
public class ItemPublicationController implements Initializable {

    @FXML
    private Text datelabel;
    @FXML
    private ImageView img;
    @FXML
    private Text titreLabel;
    private Publication pub;
    private MyListener myListener;
    @FXML
    private Label nomUtilisateur;
    @FXML
    private Label nbrCom;
    @FXML
    private Label nbrJ;
    @FXML
    private Label nbrJp;
 
   
    public void setData(Publication pub, MyListener myListener ) throws MalformedURLException, IOException {
        this.pub = pub;
        this.myListener = myListener;
      
        if (pub.getImage() != null) {
            BufferedImage deck = ImageIO.read(new URL(pub.getImage()));
            BufferedImage tempCard = deck.getSubimage(0, 0, deck.getWidth(), deck.getHeight());
            WritableImage card = SwingFXUtils.toFXImage(tempCard, null);
            img.setImage(card);
        }

        titreLabel.setText(pub.getTitre());
        datelabel.setText(pub.getDate());
       nomUtilisateur.setText(pub.getNomPrenom());
       this.nbrCom.setText("("+HomeController.nbrCom+")");
       this.nbrJ.setText("("+HomeController.nbrJ+")");
       this.nbrJp.setText("("+HomeController.nbrJp+")");

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void click(MouseEvent event) {
        myListener.onClickListener(pub);
    }

   

}
