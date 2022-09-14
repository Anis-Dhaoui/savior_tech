/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.models.Events;
import com.saviortech.services.EventPartService;
import com.saviortech.utils.PopupMessage;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private ComboBox<String> status_evt;
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
    public Button addBtn;
    @FXML
    private AnchorPane addWindow;
    @FXML
    public Button updateBtn;

    private int evId;

    //CONVER FROM DatePicker TO DATE
    public Date convertToDate(DatePicker dateToConvert) {
        Instant instant = Instant.from(dateToConvert.getValue().atStartOfDay(ZoneId.systemDefault()));
        java.util.Date date = Date.from(instant);
        Date sqlDate = new Date(date.getTime());
        return sqlDate;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateBtn.setVisible(false);
        description.setWrapText(true);

        Stage stage = new Stage();
        stage.setResizable(false);
        System.out.println(stage.getClass());

        status_evt.getItems().addAll("Activé", "Désactivé");
        status_evt.getSelectionModel().selectFirst();
    }

    private void AddEditEvent(String addEdit) {
        EventPartService es = new EventPartService();
        Window onAjouterClicked = addBtn.getScene().getWindow();

        if (title.getText().isEmpty() || image.getText().isEmpty() || category.getText().isEmpty() || description.getText().isEmpty()
            || start_dte.getValue() == null || end_dte.getValue() == null || status_evt.getItems().isEmpty() || local.getText().isEmpty()
            || price_event.getText().isEmpty() || organiser_evet.getText().isEmpty() || nbr_max.getText().isEmpty()) {

            PopupMessage.showAlert(Alert.AlertType.ERROR, onAjouterClicked, "Required Fields", "All fields are required!");

        } else {
            if (addEdit.equals("addBtn")) {
                es.ISEvents().ajouter(new Events(
                    title.getText(), image.getText(), category.getText(),
                    description.getText(), convertToDate(start_dte), convertToDate(end_dte),
                    status_evt.getValue(), local.getText(), Integer.parseInt(price_event.getText()),
                    organiser_evet.getText(), Integer.parseInt(nbr_max.getText()))
                );
                PopupMessage.infoBox("Event Added Successfully!", null, "Success");
            } else {
                es.ISEvents().modifier(new Events(evId,
                    title.getText(), image.getText(), category.getText(),
                    description.getText(), convertToDate(start_dte), convertToDate(end_dte),
                    status_evt.getValue(), local.getText(), Integer.parseInt(price_event.getText()),
                    organiser_evet.getText(), Integer.parseInt(nbr_max.getText()))
                );
                PopupMessage.infoBox("Event has been updated Successfully!", null, "Success");
                
                //Close Edit windows after infoBox OK button clicked
                Stage stage = (Stage) addBtn.getScene().getWindow();
                stage.close();
                
                //Re-render cards after update
                new ShowEventsController().updateList();
            }
            title.clear();
            image.clear();
            category.clear();
            description.clear();
            start_dte.setValue(null);
            end_dte.setValue(null);
            status_evt.valueProperty().set(null);
            local.clear();
            price_event.clear();
            organiser_evet.clear();
            nbr_max.clear();
        }
    }

    void getEventValues(int eventId, String tfTitle, String tfImg, String tfCategory, int tfPrice, String cbStatus, String tfLocal, String tfOrgoniser, int tfNbr_max, LocalDate dpStartDate, String taDescription, LocalDate dpEndDate) {
        evId = eventId;
        title.setText(tfTitle);
        image.setText(tfImg);
        category.setText(tfCategory);
        price_event.setText(String.valueOf(tfPrice));
        status_evt.setValue(cbStatus);
        local.setText(tfLocal);
        organiser_evet.setText(tfOrgoniser);
        nbr_max.setText(String.valueOf(tfNbr_max));
        start_dte.setValue(dpStartDate);
        description.setText(taDescription);
        end_dte.setValue(dpEndDate);
    }

    @FXML
    private void AddOrUpdateEvent(ActionEvent event) {
        final Node source = (Node) event.getSource();
        String btn_id = source.getId();
        AddEditEvent(btn_id);
    }
}
