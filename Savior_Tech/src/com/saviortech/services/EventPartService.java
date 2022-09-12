/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Events;
import com.saviortech.models.Participant;
import com.saviortech.models.Utilisateur;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author freec
 */
public class EventPartService {

    private Connection cnx = DataSource.getIstance().getCnx();

    //Events Service
    public InterfaceService<Events> ISEvents() {
        return new InterfaceService<Events>() {
            @Override
            public void ajouter(Events o) {
                try {
                    String req = "INSERT INTO events ("
                        + "event_title, event_image, event_category, event_description, event_start_date, event_end_date,"
                        + "event_status, event_location, event_price,event_orgoniser, event_max_participant)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = cnx.prepareStatement(req);

                    pst.setString(1, o.getEvent_title());
                    pst.setString(2, o.getEvent_image());
                    pst.setString(3, o.getEvent_category());
                    pst.setString(4, o.getEvent_description());
                    pst.setDate(5, o.getEvent_start_date());
                    pst.setDate(6, o.getEvent_end_date());
                    pst.setString(7, o.getEvent_status());
                    pst.setString(8, o.getEvent_location());
                    pst.setInt(9, o.getEvent_price());
                    pst.setString(10, o.getEvent_orgoniser());
                    pst.setInt(11, o.getEvent_max_participant());

                    pst.executeUpdate();
                    System.out.println("Event ajoutée !");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            @Override
            public List<Events> afficher() {
                List<Events> events = new ArrayList<>();

                try {
                    String req = "SELECT * FROM events";
                    PreparedStatement pst = cnx.prepareStatement(req);
                    ResultSet res = pst.executeQuery();
                    while (res.next()) {
                        events.add(new Events(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDate(6), res.getDate(7), res.getString(8), res.getString(9), res.getInt(10), res.getString(11), res.getInt(12)));
                    }
                    System.out.println("Events récupérées !");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return events;
            }

            @Override
            public void supprimer(int evId) {
                try {
                    String req = "DELETE FROM events where event_id=" + evId;
                    PreparedStatement st = cnx.prepareStatement(req);
                    st.executeUpdate(req);
                    System.out.println("Event deleted successfully!");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            @Override
            public int participantNumber(int nb) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public ObservableList<Utilisateur> getParticipants(int id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean checkIfParticipated(int userId, int eventId) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
    }

    //Participant Service
    public InterfaceService<Participant> ISParticipant() {
        return new InterfaceService<Participant>() {
            @Override
            public void ajouter(Participant o) {
                try {
                    String req = "INSERT INTO participant (user_id, event_id) VALUES (?,?)";
                    PreparedStatement pst = cnx.prepareStatement(req);
                    pst.setInt(1, o.getUser_id());
                    pst.setInt(2, o.getEvent_id());
                    pst.executeUpdate();
                    System.out.println("User participated successfully!");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            @Override
            public int participantNumber(int nb) {
                {
                    int part_nb = 0;
                    try {
                        String req = "SELECT COUNT(*) FROM utilisateur us INNER JOIN participant part ON part.user_id = us.id AND part.event_id = ?";
                        PreparedStatement pst = cnx.prepareStatement(req);
                        pst.setInt(1, nb);
                        ResultSet res = pst.executeQuery();
                        while (res.next()) {
                            part_nb = res.getInt(1);
                        }

                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return part_nb;
                }
            }

            @Override
            public ObservableList<Utilisateur> getParticipants(int id) {
                ObservableList<Utilisateur> participantList = FXCollections.observableArrayList();

                try {
                    String req = "SELECT fullname, role, speciality FROM utilisateur us INNER JOIN participant part ON part.user_id = us.id AND part.event_id = ?";
                    PreparedStatement pst = cnx.prepareStatement(req);
                    pst.setInt(1, id);
                    ResultSet res = pst.executeQuery();
                    while (res.next()) {
                        participantList.add(new Utilisateur(res.getString(1), res.getString(2), res.getString(3)));
                    }
                    System.out.println("Participants récupérées !");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return participantList;
            }

            @Override
            public boolean checkIfParticipated(int userId, int eventId) {
                try {
                    String req = "SELECT * FROM participant WHERE user_id = ? and event_id = ?";
                    PreparedStatement pst = cnx.prepareStatement(req);
                    pst.setInt(1, userId);
                    pst.setInt(2, eventId);
                    ResultSet res = pst.executeQuery();

                    if (res.next()) {
                        return true;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                return false;
            }

            @Override
            public List<Participant> afficher() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void supprimer(int id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
    }
}