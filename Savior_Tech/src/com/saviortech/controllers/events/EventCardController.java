/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.models.Events;
import com.saviortech.models.Participant;
import com.saviortech.services.EventService;
import com.saviortech.services.InterfaceService;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

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
    @FXML
    private AnchorPane cardId;

    private Events events;

    //Image is a generic concept and BufferedImage is the concrete implementation of the generic concept
    public WritableImage implementImage(String imgUrl) throws MalformedURLException, IOException {
        BufferedImage deck = ImageIO.read(new URL(imgUrl));
        BufferedImage tempCard = deck.getSubimage(0, 0, deck.getWidth(), deck.getHeight());
        WritableImage card = SwingFXUtils.toFXImage(tempCard, null);
        return card;
    }

    public EventCardController() {
    }

    public void setData(Events events) throws IOException {
        this.events = events;

        //Setting up data to card
        image.setImage(implementImage(events.getEvent_image()));
        titre.setText(events.getEvent_title());
        categorie.setText(events.getEvent_category());
        
        InterfaceService nbPart = new EventService().ISParticipant();
        nb_part.setText(String.valueOf(nbPart.participantNumber(events.getEvent_id())));
        
        date.setText(String.valueOf(events.getEvent_start_date()));

        //Show Event details when click on the card
        image.setOnMouseClicked((MouseEvent event) -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../../views/events/EventDetails.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(EventDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                EventDetailsController ev = loader.getController();

                ev.setLabel(events.getEvent_id(), events.getEvent_title(), events.getEvent_image(), events.getEvent_category(), events.getEvent_description(), events.getEvent_start_date(), events.getEvent_end_date(), events.getEvent_status(), events.getEvent_location(), events.getEvent_price(), events.getEvent_orgoniser(), events.getEvent_max_participant());
            } catch (IOException ex) {
                Logger.getLogger(EventCardController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent parent = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle(events.getEvent_title());
            stage.setResizable(false);
            stage.show();
            System.out.println(events.getEvent_id());
        });
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
