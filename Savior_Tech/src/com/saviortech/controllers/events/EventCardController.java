/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.models.Events;
import com.saviortech.services.EventPartService;
import com.saviortech.services.InterfaceService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
    ShowEventsController sec = new ShowEventsController();
    private String evId;

    //Image is a generic concept and BufferedImage is the concrete implementation of the generic concept
    //if there is an exception with imageIO.read so it will use an image from saved in the localhost
    public WritableImage implementImage(String imgUrl) throws MalformedURLException, IOException {
        BufferedImage deck;
        try {
            //deck = ImageIO.read(new URL(imgUrl));
            deck = ImageIO.read(getClass().getResourceAsStream("../../images/inscription.jpg"));
        } catch (Exception e) {
            deck = ImageIO.read(getClass().getResourceAsStream("../../images/inscription.jpg"));
        }
        BufferedImage tempCard = deck.getSubimage(0, 0, deck.getWidth(), deck.getHeight());
        WritableImage card = SwingFXUtils.toFXImage(tempCard, null);

        return card;
    }

    // Convert sql date to local date
    public LocalDate convertDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public EventCardController() {
    }
    static int counter = 0;

    public void setData(Events events) throws IOException {

        counter++;
        cardId.setId(String.valueOf(counter));
        this.events = events;
        evId = events.getEvent_id();

        //Setting up data to card
        image.setImage(implementImage(events.getEvent_image()));
        titre.setText(events.getEvent_title());
        categorie.setText(events.getEvent_category());

        InterfaceService nbPart = new EventPartService().ISParticipant();
        nb_part.setText(String.valueOf(nbPart.participantNumber(events.getEvent_id())));

        date.setText(String.valueOf(events.getEvent_start_date()));

        //Show Event details when click on the card
        image.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("Event ID: " + events.getEvent_id());
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
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (true) {
            FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
            FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

            //Styling delete and edit buttons
            deleteIcon.setStyle(
                " -fx-cursor: hand;"
                + "-glyph-size:28px;"
                + "-fx-fill:#ff1744;"
            );
            editIcon.setStyle(
                " -fx-cursor: hand;"
                + "-glyph-size:28px;"
                + "-fx-fill:#00E676;"
            );

            //adding buttons inside an Hbox and styling them
            HBox delEditBtn = new HBox(editIcon, deleteIcon);
            delEditBtn.setStyle("-fx-alignment:center");
            HBox.setMargin(deleteIcon, new javafx.geometry.Insets(2, 2, 0, 3));
            HBox.setMargin(editIcon, new javafx.geometry.Insets(2, 3, 0, 2));
            cardId.getChildren().add(delEditBtn);
            delEditBtn.setLayoutX(295);
            delEditBtn.setLayoutY(265);

            //Delete Event
            deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                System.out.println("Delete Event ID: " + events.getEvent_id());
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Etes vous sure?", "Confirm", dialogButton);
                if (dialogResult == 0) {
                    //Remove event from database
                    new EventPartService().ISEvents().supprimer(events.getEvent_id());

                    try {
                        //METHOD 1:   Send the card id of grid to remove
                        //sec.removeFromList(Integer.parseInt(cardId.getId()));

                        //METHOD 2:  Send the event id to remove
                        sec.removeFromList(events.getEvent_id());
                    } catch (IOException ex) {
                        Logger.getLogger(EventCardController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    System.out.println("Delete Canceled");
                }
            });

            //Edit Event
            editIcon.setOnMouseClicked((MouseEvent event) -> {
                System.out.println("Edit Event ID: " + events.getEvent_id());
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(EventCardController.this.getClass().getResource("../../views/events/AddEvent.fxml"));
                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
                }

                AddEventController aec = loader.getController();
                aec.addBtn.setVisible(false);
                aec.updateBtn.setVisible(true);

                aec.getEventValues(events.getEvent_id(), events.getEvent_title(), events.getEvent_image(),
                    events.getEvent_category(), events.getEvent_price(), events.getEvent_status(),
                    events.getEvent_location(), events.getEvent_orgoniser(), events.getEvent_max_participant(),
                    convertDate(events.getEvent_start_date()), events.getEvent_description(),
                    convertDate(events.getEvent_end_date())
                );
                Parent parent = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(parent));
                stage.setTitle("Modifier:  " + events.getEvent_title());
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            });
        }
    }
}
