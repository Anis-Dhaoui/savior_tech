/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Events;
import com.saviortech.models.Participant;
import com.saviortech.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author freec
 */
public class EventService {

    private Connection cnx = DataSource.getIstance().getCnx();

    //Events Service
    public InterfaceService<Events> ISEvents() {
        return new InterfaceService<Events>() {
            @Override
            public void ajouter(Events o) {
                try {
                    String req = "INSERT INTO events ("
                        + "event_title, event_image, event_category, event_description, event_start_date, event_end_date,"
                        + "event_status, event_location, event_price,event_orgoniser, event_nb_participant, event_max_participant) "
                        + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
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
                    pst.setInt(11, o.getEvent_nb_participant());
                    pst.setInt(12, o.getEvent_max_participant());

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
                        events.add(new Events(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getDate(6), res.getDate(7), res.getString(8), res.getString(9), res.getInt(10), res.getString(11), res.getInt(12), res.getInt(13)));
                    }
                    System.out.println("Events récupérées !");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                return events;
            }
        };
    }

    
    //Participant Service
    public InterfaceService<Participant> ISParticipant() {
        return new InterfaceService<Participant>() {
            @Override
            public void ajouter(Participant o) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public List<Participant> afficher() {
                {
                    List<Participant> participants = new ArrayList<>();

                    try {
                        String req = "SELECT us.* FROM user us INNER JOIN participant part ON part.user_id = us.user_id AND part.event_id = 1;";
                        PreparedStatement pst = cnx.prepareStatement(req);
                        ResultSet res = pst.executeQuery();
                        while (res.next()) {
                            //participants.add(new Participant(res.getInt(1), res.getString(2), res.getString(3), res.getString(4)));
                        }
                        System.out.println("Participants récupérées !");
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return participants;
                }
            }
        };
    }
}
