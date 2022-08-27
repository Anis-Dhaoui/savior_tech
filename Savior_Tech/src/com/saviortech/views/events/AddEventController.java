/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.views.events;

import com.saviortech.models.Events;
import com.saviortech.services.EventService;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class AddEventController implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private TextField image;
    @FXML
    private TextField category;
    @FXML
    private TextField price_event;
    @FXML
    private TextField status_evt;
    @FXML
    private TextField local;
    @FXML
    private TextField organiser_evet;
    @FXML
    private TextField nbr_max;
    @FXML
    private DatePicker start_dte;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker end_dte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddEvent(ActionEvent event) {
        EventService es = new EventService();
        Instant instant_s = Instant.from(start_dte.getValue().atStartOfDay(ZoneId.systemDefault()));
        Date s_date = Date.from(instant_s);

        Instant instant_e = Instant.from(end_dte.getValue().atStartOfDay(ZoneId.systemDefault()));
        Date e_date = Date.from(instant_e);
        java.sql.Date startDate = new java.sql.Date(s_date.getTime());
        java.sql.Date endDate = new java.sql.Date(e_date.getTime());
        System.out.println(start_dte + "\n" + instant_s + "\n" + s_date);
        es.ISEvents().ajouter(new Events(
            title.getText(), image.getText(), category.getText(),
            description.getText(), startDate, endDate,
            status_evt.getText(), local.getText(), Integer.parseInt(price_event.getText()),
            organiser_evet.getText(), Integer.parseInt(nbr_max.getText()))
        );
        
        JOptionPane.showMessageDialog(null, "Nouveau evennement ajouté");
    }

}
