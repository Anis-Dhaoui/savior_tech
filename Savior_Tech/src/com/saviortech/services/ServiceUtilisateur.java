/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Utilisateur;
import com.saviortech.utils.DataSource;
import com.saviortech.utils.PasswordHash;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LENOVO
 */
public class ServiceUtilisateur implements IService<Utilisateur> {

    private final Connection cnx = DataSource.getIstance().getCnx();

    @Override
    public void ajouter(Utilisateur o) {
        try {
            String req = "INSERT INTO utilisateur(fullname, username, email, password, role, domain, interest, speciality) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, o.getFullname());
            pst.setString(2, o.getUsername());
            pst.setString(3, o.getEmail());
            pst.setString(4, o.getPassword());
            pst.setString(5, o.getRole());
            pst.setString(6, o.getDomain());
            pst.setString(7, o.getInterest());
            pst.setString(8, o.getSpeciality());
            pst.executeUpdate();
            System.out.println("Utilisateur ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Utilisateur o) {
        try {
            String req = "UPDATE utilisateur SET fullname=?, username=?, email=?, password=?, role=?, domain=?, interest=?, speciality=? where id=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, o.getFullname());
            pst.setString(2, o.getUsername());
            pst.setString(3, o.getEmail());
            pst.setString(4, o.getPassword());
            pst.setString(5, o.getRole());
            pst.setString(6, o.getDomain());
            pst.setString(7, o.getInterest());
            pst.setString(8, o.getSpeciality());
            pst.setInt(9, o.getId());
            pst.executeUpdate();
            System.out.println("Personne modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Utilisateur o) {
        try {
            String req = "DELETE FROM utilisateur where id=" + o.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Utilisateur> afficher() {
        ObservableList<Utilisateur> userList = FXCollections.observableArrayList();

        try {
            String req = "SELECT * FROM utilisateur";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                userList.add(new Utilisateur(res.getInt("id"), res.getString("fullname"), res.getString("username"), res.getString("email"), res.getString("password"), res.getString("role"), res.getString("domain"), res.getString(8), res.getString("speciality")));
            }
            System.out.println("Personnes récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userList;
    }



    /*
    public void auth(Utilisateur o) {
        boolean isAuthenticated = false;

        try {
            String req = "SELECT id from utilisisateur where username = ? AND password = ?";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setString(1, o.getUsername());
            pst.setString(2, o.getPassword());

            ResultSet res = pst.executeQuery();

            System.out.println(res);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("*************TESTING****************");
    }
     */
    public List<Utilisateur> validate(String username, String password) throws SQLException {
        List<Utilisateur> userData = new ArrayList<>();
        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.

        try {
            String req = "SELECT id, fullname, username, email, role, domain, interest, speciality from utilisateur where username = ? AND password = ?";
            PreparedStatement pst = cnx.prepareStatement(req);
            // Step 2:Create a statement using connection object

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet res = pst.executeQuery();

            while(res.next()) {
                userData.add(new Utilisateur(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8)));
            }

        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
        return userData;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
   public ObservableList<Utilisateur> searchUser() {
        ObservableList<Utilisateur> searchlist = FXCollections.observableArrayList();
 try {
            String req = "SELECT * FROM utilisateur where username=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                searchlist.add(new Utilisateur(res.getInt("id"), res.getString("fullname"), res.getString("username"), res.getString("email"), res.getString("password"), res.getString("role"), res.getString("domain"), res.getString(8), res.getString("speciality")));
            }
            System.out.println("Personnes récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return searchlist;        
   }}