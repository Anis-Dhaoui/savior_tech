/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers.Jamila;

import com.saviortech.models.Utilisateur;
import com.saviortech.services.ServiceUtilisateur;
import com.saviortech.utils.UUIDGenerator;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.swing.JOptionPane;

public class ShowUsersController implements Initializable {

    @FXML
    private TableView<Utilisateur> userTable;
    
    @FXML
    private TableColumn<Utilisateur, String> colFullname;
    @FXML
    private TableColumn<Utilisateur, String> colUsername;
    @FXML
    private TableColumn<Utilisateur, String> colEmail;
    @FXML
    private TableColumn<Utilisateur, String> colPassword;
    @FXML
    private TableColumn<Utilisateur, String> colRole;
    @FXML
    private TableColumn<Utilisateur, String> colDomain;
    @FXML
    private TableColumn<Utilisateur, String> colInterest;
    @FXML
    private TableColumn<Utilisateur, String> colSpeciality;
    @FXML
    private TableColumn<Utilisateur, String> colEdit;

    Utilisateur user = null;

    @FXML
    private TextField filtredfield;

    ObservableList<Utilisateur> dataList = new ServiceUtilisateur().afficher();
    FilteredList<Utilisateur> filteredData = new FilteredList<>(FXCollections.observableList(dataList));

    private boolean searchFindsUser(Utilisateur user, String searchText) {
        return (user.getUsername().toLowerCase().contains(searchText.toLowerCase()));
    }

    private Predicate<Utilisateur> createPredicate(String searchText) {
        return (user)-> {
            if (searchText == null || searchText.isEmpty()) {
                return true;
            }
            return searchFindsUser(user, searchText);
        };
    }

    public void initialize(URL url, ResourceBundle rb) {
        filtredfield.textProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println(filtredfield.getText());
            filteredData.setPredicate(createPredicate(newValue));
        });
        getData();
    }

    private void getData() {

        userTable.setItems(filteredData);

        colFullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colDomain.setCellValueFactory(new PropertyValueFactory<>("domain"));
        colInterest.setCellValueFactory(new PropertyValueFactory<>("interest"));
        colSpeciality.setCellValueFactory(new PropertyValueFactory<>("speciality"));

        //adding Delete and Edit buttons to colEdit cell
        Callback<TableColumn<Utilisateur, String>, TableCell<Utilisateur, String>> cellFoctory = (TableColumn<Utilisateur, String> param) -> {
            // make cell containing buttons
            final TableCell<Utilisateur, String> cell = new TableCell<Utilisateur, String>() {
                @Override
                public void updateItem(String item, boolean empty) {

                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        //Styling delete and edit buttons
                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );

                        //Delete user method
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            user = userTable.getSelectionModel().getSelectedItem();
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog(null, "Confirmer la suppression", "Confirm", dialogButton);
                            if (dialogResult == 0) {
                                new ServiceUtilisateur().supprimer(user);
                                refrechUserList();
                                System.out.println("Delete Confirmed");
                            } else {
                                System.out.println("Delete Canceled");
                            }
                        });

                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            user = userTable.getSelectionModel().getSelectedItem();
                            System.out.println(user);
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../../views/jamila/EditUser.fxml"));
                            try {
                                loader.load();

                            } catch (IOException ex) {
                                Logger.getLogger(ShowUsersController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            refrechUserList();

                            EditUserController editUser = loader.getController();
                            editUser.setTextField(user.getFullname(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole(), user.getInterest(), user.getDomain(), user.getSpeciality());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            System.out.println(user.getId());
                        });

                        //adding buttons inside an Hbox and styling them
                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new javafx.geometry.Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new javafx.geometry.Insets(2, 3, 0, 2));
                        setGraphic(managebtn);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        colEdit.setCellFactory(cellFoctory);
    }

    @FXML

    public void refrechUserList() {
        getData();
    }
    /* dateOfBirthColumn.setOnEditCommit(event - > {
            final Date value = event.getNewValue() != null ? event.getNewValue() :
                event.getOldValue();
            ((PersonTableData) event.getTableView().getItems()
                .get(event.getTablePosition().getRow()))
            .setDateOfBirth(value);
            table.refresh();
        });
    }*/

}
