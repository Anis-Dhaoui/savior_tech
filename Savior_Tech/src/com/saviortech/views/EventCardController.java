/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.views;

import com.saviortech.models.Events;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class EventCardController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Label titre;
    @FXML
    private Label categorie;
    @FXML
    private Label nb_part;
    @FXML
    private Label date;

    private Events events;

    public void setData(Events events) throws IOException {
        this.events = events;

        BufferedImage deck = ImageIO.read(new URL(events.getEvent_image()));
        BufferedImage tempCard = deck.getSubimage(0, 0, deck.getWidth(), deck.getHeight());
        WritableImage card = SwingFXUtils.toFXImage(tempCard, null);
        image.setImage(card);

        titre.setText(events.getEvent_title());
        categorie.setText(events.getEvent_category());
        nb_part.setText(String.valueOf(events.getEvent_nb_participant()));
        date.setText(String.valueOf(events.getEvent_start_date()));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
