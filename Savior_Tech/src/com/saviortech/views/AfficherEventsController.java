/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.views;

import com.saviortech.models.Events;
import com.saviortech.services.EventService;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author freec
 */
public class AfficherEventsController implements Initializable {

    @FXML
    private ScrollPane scrol;
    @FXML
    private GridPane grid;
    /**
     * Initializes the controller class.
     */
    List<Events> es = new EventService().afficher();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//scrol.setPrefSize( 1500, 2000 );
//scrol.setPrefSize( Double.MAX_VALUE, Double.MAX_VALUE );
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < es.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EventCard.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                EventCardController itemController = fxmlLoader.getController();
                itemController.setData(es.get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
               

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(10));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}