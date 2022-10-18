/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.saviortech.controllers;

import com.saviortech.controllers.events.AddEventController;
import com.saviortech.models.Commentaire;
import com.saviortech.models.CurrentUser;
import com.saviortech.models.Publication;
import com.saviortech.models.Reaction;
import com.saviortech.services.MyListener;
import com.saviortech.services.ServiceCommentaire;
import com.saviortech.services.ServicePublication;
import com.saviortech.services.ServiceReaction;
import com.saviortech.views.ItemPublicationController;
import com.saviortech.views.ViewPublicationController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author SOMRANI
 */
public class HomeController implements Initializable {

    @FXML
    private Button addPub;
    @FXML
    private VBox vBox;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private Text username;
//$$$$$$$$$$$$$$$$$$$ START EVENTS NODES $$$$$$$$$$$$$$$$$$$
    @FXML
    private HBox showEventsId;
    @FXML
    private HBox addEventId;
//$$$$$$$$$$$$$$$$$$$ END EVENTS NODES $$$$$$$$$$$$$$$$$$$

//$$$$$$$$$$$$$$$$$$$ START USERS NODES $$$$$$$$$$$$$$$$$$$ 
    @FXML
    private HBox showUsersId;
    @FXML
    private HBox authenticatedUserBox;
    @FXML
    private HBox signinSignupBtnsBox;
    public static HBox customAuthBox = new HBox();
    public static HBox customSignBox = new HBox();
    public static Text customUsername = new Text();
    public static HBox customAddEvent = new HBox();
    public static HBox customShowUsers = new HBox();
//$$$$$$$$$$$$$$$$$$$ END USERS NODES $$$$$$$$$$$$$$$$$$$ 

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ START PUBLICATIONS NODES  $$$$$$$$$$$$$$$$$$$$$$$$$$
    ServicePublication sp = new ServicePublication();
    ServiceCommentaire sc = new ServiceCommentaire();
    ServiceReaction sr = new ServiceReaction();
    private List<Publication> pubs = sp.afficher();

    private Preferences prefs;

    public static int idPub;
    public static int nbrCom = 0;
    public static int nbrJ = 0;
    public static int nbrJp = 0;
    public static int idUtilisateur = 3;

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ END PUBLICATIONS NODES  $$$$$$$$$$$$$$$$$$$$$$$$$$
    static CurrentUser cu = new CurrentUser();
    @FXML
    private FontAwesomeIconView lougoutId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ START PUBLICATIONS METHODS  $$$$$$$$$$$$$$$$$$$$$$$$$$
        MyListener myListener = new MyListener() {
            @Override
            public void onClickListener(Publication pub) {
                try {

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/viewPublication.fxml"));
                    Parent root2 = (Parent) fxmlLoader.load();

                    Stage stage = new Stage();
                    stage.setTitle("View publication");
                    stage.setScene(new Scene(root2));
                    stage.show();
                    ViewPublicationController vp = fxmlLoader.getController();
                    vp.setShowPublication(pub);
                    idPub = pub.getIdPublication();

                } catch (IOException ex) {
                    ex.getMessage();
                }

            }

        };
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < pubs.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/itemPublication.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                List<Commentaire> coms = sc.afficher(pubs.get(i).getIdPublication());
                nbrCom = coms.size();
                List<Reaction> recs = sr.afficher(pubs.get(i).getIdPublication());

                nbrJ = recs.size();

                nbrJp = recs.size();
                ItemPublicationController itemController = fxmlLoader.getController();
                itemController.setData(pubs.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row); //(child,column,row)

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ END PUBLICATIONS METHODS  $$$$$$$$$$$$$$$$$$$$$$$$$$
        customAuthBox = authenticatedUserBox;
        customSignBox = signinSignupBtnsBox;
        customUsername = username;
        customAddEvent = addEventId;
        customShowUsers = showUsersId;

//        authenticatedUserBox.managedProperty().bind(authenticatedUserBox.visibleProperty());
        checkIfUserAuthenticated();
    }

    public static void checkIfUserAuthenticated() {
        if (cu.getUserInfo().isEmpty()) {
            customAuthBox.managedProperty().bind(customAuthBox.visibleProperty());
            customAuthBox.setVisible(false);
            customSignBox.setVisible(true);

            customAddEvent.managedProperty().bind(customAddEvent.visibleProperty());
            customAddEvent.setVisible(false);

            customShowUsers.managedProperty().bind(customShowUsers.visibleProperty());
            customShowUsers.setVisible(false);
        } else {
            //Show and hide boxes
            customAuthBox.managedProperty().bind(customAuthBox.visibleProperty());
            customAuthBox.setVisible(true);
            customSignBox.managedProperty().bind(customSignBox.visibleProperty());
            customSignBox.setVisible(false);

            //Set username of authenticated user
            customUsername.setText(cu.getUserInfo().get(0).getUsername());

            if (cu.getUserInfo().get(0).isAdmin() == 1) {
                customAddEvent.managedProperty().bind(customAddEvent.visibleProperty());
                customAddEvent.setVisible(true);

                customShowUsers.managedProperty().bind(customShowUsers.visibleProperty());
                customShowUsers.setVisible(true);
            }
        }
    }

//$$$$$$$$$$$$$$$$$$$ START EVENTS METHODS $$$$$$$$$$$$$$$$$$$
    @FXML
    private void ShowEventsMethod(MouseEvent event) {
        FXMLLoader showEventLoader = new FXMLLoader();
        showEventLoader.setLocation(HomeController.this.getClass().getResource("../views/events/ShowEvents.fxml"));
        try {
            showEventLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = showEventLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("ALL EVENTS");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    private void AddEventMethod(MouseEvent event) {
        FXMLLoader addEventLoader = new FXMLLoader();
        addEventLoader.setLocation(HomeController.this.getClass().getResource("../views/events/AddEvent.fxml"));
        try {
            addEventLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = addEventLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("ADD NEW EVENT");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
    }
//$$$$$$$$$$$$$$$$$$$ END EVENTS METHODS $$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$   
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$   
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//$$$$$$$$$$$$$$$$$$$ START USERS METHODS $$$$$$$$$$$$$$$$$$$

    @FXML
    private void SignUpMethod(ActionEvent event) {
        FXMLLoader signupLoader = new FXMLLoader();
        signupLoader.setLocation(HomeController.this.getClass().getResource("../views/jamila/InscriptionUtilisateur.fxml"));
        try {
            signupLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = signupLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("SIGN UP");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void SignInMethod(ActionEvent event) {
        FXMLLoader signinLoader = new FXMLLoader();
        signinLoader.setLocation(HomeController.this.getClass().getResource("../views/jamila/login.fxml"));
        try {
            signinLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = signinLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("SIGN IN");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void ShowUsersMethod(MouseEvent event) {
        FXMLLoader showUsersLoader = new FXMLLoader();
        showUsersLoader.setLocation(HomeController.this.getClass().getResource("../views/jamila/ShowUsers.fxml"));
        try {
            showUsersLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = showUsersLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("ALL USERS");
//        stage.setMaximized(true);
        stage.show();
    }
    //$$$$$$$$$$$$$$$$$$$ END USERS METHODS $$$$$$$$$$$$$$$$$$$

    @FXML
    private void showProfileInfo(MouseEvent event) {
        FXMLLoader showProfileLoader = new FXMLLoader();
        showProfileLoader.setLocation(HomeController.this.getClass().getResource("../views/jamila/User_Home.fxml"));
        try {
            showProfileLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(AddEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Parent parent = showProfileLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("PROFILE INFORMATION");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void Logout(MouseEvent event) {
        System.out.println("SIGN OUT");
        cu.getUserInfo().clear();
        checkIfUserAuthenticated();
    }

    //$$$$$$$$$$$$$$$$$$$ START PUBLICATION METHODS $$$$$$$$$$$$$$$$$$$
    @FXML
    private void onActionAjouterP(ActionEvent event) throws IOException {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../views/AddPublication.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();

        stage.setTitle("Ajouter Publication");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void ShowPubMethod(MouseEvent event) {
         MyListener myListener = new MyListener() {
            @Override
            public void onClickListener(Publication pub) {
                try {

                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../views/viewPublication.fxml"));
                    Parent root2 = (Parent) fxmlLoader.load();

                    Stage stage = new Stage();
                    stage.setTitle("View publication");
                    stage.setScene(new Scene(root2));
                    stage.show();
                    ViewPublicationController vp = fxmlLoader.getController();
                    vp.setShowPublication(pub);
                    idPub = pub.getIdPublication();
                 

                } catch (IOException ex) {
                    ex.getMessage();
                }

            }

        };
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < pubs.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("../views/itemPublication.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                List<Commentaire> coms = sc.afficher(pubs.get(i).getIdPublication());
                nbrCom = coms.size();
                List<Reaction> recs = sr.afficher(pubs.get(i).getIdPublication());
             
                nbrJ = recs.size();
            
                nbrJp = recs.size();
                ItemPublicationController itemController = fxmlLoader.getController();
                itemController.setData(pubs.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row); //(child,column,row)

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
    }
}
