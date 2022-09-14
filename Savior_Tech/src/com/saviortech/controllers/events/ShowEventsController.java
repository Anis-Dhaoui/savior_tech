/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.events;

import com.saviortech.models.Events;
import com.saviortech.services.EventPartService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class ShowEventsController implements Initializable {

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scrol;

    static GridPane customGridPane = new GridPane();

    private static List<Events> es = new EventPartService().ISEvents().afficher();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customGridPane = grid;
        renderCards();
    }

    public void removeFromList(int id) throws IOException {
        //Remove from list and rerender renderCards method
        es.removeIf(item -> item.getEvent_id() == id);
        customGridPane.getChildren().clear();
        renderCards();

        //remove node of gridpane
        //customGridPane.getChildren().remove(id - 1);
    }
    
    public void updateList(){
        es = new EventPartService().ISEvents().afficher();
        customGridPane.getChildren().clear();
        renderCards();
    }

    public void renderCards() {
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < es.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../../views/events/EventCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventCardController itemController = fxmlLoader.getController();
                itemController.setData(es.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                customGridPane.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                customGridPane.setMinWidth(Region.USE_COMPUTED_SIZE);
                customGridPane.setPrefWidth(Region.USE_COMPUTED_SIZE);
                customGridPane.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                customGridPane.setMinHeight(Region.USE_COMPUTED_SIZE);
                customGridPane.setPrefHeight(Region.USE_COMPUTED_SIZE);
                customGridPane.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
