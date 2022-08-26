/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.models.Participant;
import com.saviortech.services.EventService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class EventDetailsController implements Initializable {

    @FXML
    private ImageView phImage;
    @FXML
    private Text phTitle;
    @FXML
    private Text phDescription;
    @FXML
    private Text phStartDate;
    @FXML
    private Text phEndDate;
    @FXML
    private Text phStatus;
    @FXML
    private Text phLocation;
    @FXML
    private Text phCategory;
    @FXML
    private Text phPrice;
    @FXML
    private Text phOrgonizer;
    @FXML
    private Text phNbPart;
    @FXML
    private Text phMaxPart;
    @FXML
    private HBox eventId;

    private int ev_id;
    EventService eveSer = new EventService();

    private EventCardController bufferImg = new EventCardController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void participate(ActionEvent event) {
        System.out.println("user participated");
        eveSer.ISParticipant().ajouter(new Participant(3, ev_id));
        System.out.println(ev_id);
    }

    void setLabel(int id, String title, String image, String category, String description, Date sd, Date ed, String status, String location, int price, String orgoniser, int nbPart, int maxPart) throws IOException {

        //purpose of getting event id is just to use it in participate method
        ev_id = id;

        phTitle.setText(title);
        phImage.setImage(bufferImg.implementImage(image));
        phCategory.setText(category);
        phDescription.setText(description);
        phStartDate.setText(String.valueOf(sd));
        phEndDate.setText(String.valueOf(ed));
        phStatus.setText(status);
        phLocation.setText(location);
        phPrice.setText(String.valueOf(price));
        phOrgonizer.setText(orgoniser);
        phNbPart.setText(String.valueOf(nbPart));
        phMaxPart.setText(String.valueOf(maxPart));
    }
}
