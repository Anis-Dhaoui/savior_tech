/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.models.Events;
import com.saviortech.services.EventPartService;
import com.saviortech.utils.CheckingErrors;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

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
    @FXML
    private Button addBtn;
    @FXML
    private AnchorPane addWindow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Stage stage = new Stage();
        stage.setResizable(false);
        System.out.println(stage.getClass());
    }

    @FXML
    private void AddEvent(ActionEvent event) {
        EventPartService es = new EventPartService();
        Window onAjouterClicked = addBtn.getScene().getWindow();

        if (title.getText().isEmpty() || image.getText().isEmpty() || category.getText().isEmpty() || description.getText().isEmpty()
            || start_dte.getValue() == null || end_dte.getValue() == null || status_evt.getText().isEmpty() || local.getText().isEmpty()
            || price_event.getText().isEmpty() || organiser_evet.getText().isEmpty() || nbr_max.getText().isEmpty()) {
            
            CheckingErrors.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "All fields are required!");
            
        } else {
            Instant instant_s = Instant.from(start_dte.getValue().atStartOfDay(ZoneId.systemDefault()));
            Date s_date = Date.from(instant_s);

            Instant instant_e = Instant.from(end_dte.getValue().atStartOfDay(ZoneId.systemDefault()));
            Date e_date = Date.from(instant_e);

            java.sql.Date startDate = new java.sql.Date(s_date.getTime());
            java.sql.Date endDate = new java.sql.Date(e_date.getTime());

            es.ISEvents().ajouter(new Events(
                title.getText(), image.getText(), category.getText(),
                description.getText(), startDate, endDate,
                status_evt.getText(), local.getText(), Integer.parseInt(price_event.getText()),
                organiser_evet.getText(), Integer.parseInt(nbr_max.getText()))
            );

            CheckingErrors.infoBox("Event Added Successfully!", null, "Success");

            title.clear();
            image.clear();
            category.clear();
            description.clear();
            start_dte.setValue(null);
            end_dte.setValue(null);
            status_evt.clear();
            local.clear();
            price_event.clear();
            organiser_evet.clear();
            nbr_max.clear();
        }
    }

}
