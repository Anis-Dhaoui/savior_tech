/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.mysql.cj.x.protobuf.Mysqlx;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.saviortech.models.Publications;
import com.saviortech.utils.DataSource;
import com.saviortech.utils.UUIDGenerator;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class ServicePublication implements IServicePublication<Publications> {

    private Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Publications o) {
        java.util.Date actuelle = new java.util.Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd" + "00:00:00");

        String date = dateFormat.format(actuelle);
        String dc = date;
        try {

            String req = "INSERT INTO publications (id,titre,description,image,statut,UserId)"
                    + " values (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, new UUIDGenerator().getUuid().toString());
            ps.setString(2, o.getTitre());
            ps.setString(3, o.getDescription());
            ps.setString(4, o.getImage());
            ps.setString(5, o.getStatut());

            ps.setString(6, "06093368-ae0a-477a-9738-4a6403026568");

            //    ps.setDate(7, (java.sql.Date) new Date());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Publication ajoutée !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Publications o) {

        try {
            String req = "UPDATE publications SET description=? where id=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, o.getDescription());
            ps.executeUpdate();
            System.out.println("Modifiée!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(String id) {
        try {
            String req = "UPDATE `publications` SET `statut`='Deactive' WHERE publications.id = ?";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(0, id);
            ps.executeUpdate();
            System.out.println("supprimée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List afficher() {
        List pub = new ArrayList<>();
        try {

            String req = "SELECT TITRE,DESCRIPTION,IMAGE,fullName\n"
                    + "FROM publications,users\n"
                    + "WHERE users.id = publications.UserId and publications.statut = 'active'  ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                pub.add(new Publications(res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
            }

            System.out.println("Puplication récupérées !");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pub;
    }

}
