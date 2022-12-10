/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.models.Utilisateur;
import com.saviortech.services.EventPartService;
import com.saviortech.services.ServiceUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class ShowParticipantsController implements Initializable {

    @FXML
    private TableColumn<Utilisateur, String> colFullName;
    @FXML
    private TableColumn<Utilisateur, String> colRole;
    @FXML
    private TableColumn<Utilisateur, String> colSpeciality;
    @FXML
    private TableView<Utilisateur> partTable;

    Utilisateur partList = null;
    EventDetailsController evId = new EventDetailsController();

    public void initialize(URL url, ResourceBundle rb) {
        partTable.setItems(new EventPartService().ISParticipant().getParticipants(evId.ev_id));

        colFullName.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colSpeciality.setCellValueFactory(new PropertyValueFactory<>("speciality"));
    }

}
