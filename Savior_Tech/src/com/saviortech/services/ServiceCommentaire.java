/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Commentaires;
import com.saviortech.utils.DataSource;
import com.saviortech.utils.UUIDGenerator;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marwen
 */
public class ServiceCommentaire implements IServicePublication<Commentaires> {

    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Commentaires o) {
        java.util.Date actuelle = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(actuelle);
        String dc = date;

        try {
            String req = "INSERT INTO commentaires (id , DESCRIPTION, createdAt ,PublucationId, UserId)"
                    + " VALUES (?, ?, ?, ?)";
            // String rep = "INSERT INTO commentaire (idPublication,idUtilisateur,description,date) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, new UUIDGenerator().getUuid().toString());
            ps.setString(2, o.getDescription());
            ps.setString(3, null);
            ps.setString(4, "07fda04f-fd03-4fa8-9934-db0900ac68ac");
            ps.setString(5, "9360d336-fc93-4829-94ba-42361754f27a");
            ps.executeUpdate();
            System.out.println("ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Commentaires o) {

        String rep = "UPDATE Commentaires SET description = ? where id=?";
    }

    @Override
    public void supprimer(String id) {
        try {
            String req = "DELETE FROM commentaires where id=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Commentaires> afficher(String id) {
        List<Commentaires> com = new ArrayList<>();
        try {

            String req = "SELECT commentaires.id,commentaires.description,users.fullName\n"
                    + "                           FROM users,commentaires \n"
                    + "                           WHERE users.id = commentaires.UserId AND commentaires.PublicationId = ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
          //     com.add(new Commentaires(res.getString(1), res.getString(2), res.getString(3)));
             com.add(new Commentaires(res.getString(1),res.getString(2),res.getString(3)));
                System.out.println(com);
            }

            System.out.println("Commentaire récupérées !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return com;
    }
}
