/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.controllers.Jamila.EditUserController;
import com.saviortech.controllers.Jamila.ShowUsersController;
import com.saviortech.models.Participant;
import com.saviortech.services.EventService;
import com.saviortech.services.InterfaceService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    @FXML
    private Text phShowPart;

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

    void setLabel(int id, String title, String image, String category, String description, Date sd, Date ed, String status, String location, int price, String orgoniser, int maxPart) throws IOException {

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
        phMaxPart.setText(String.valueOf(maxPart));

        InterfaceService nbPart = new EventService().ISParticipant();
        phNbPart.setText(String.valueOf(nbPart.participantNumber(ev_id)));
    }

    @FXML
    private void showParticipants(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../views/events/ShowParticipants.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(ShowUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }
}
