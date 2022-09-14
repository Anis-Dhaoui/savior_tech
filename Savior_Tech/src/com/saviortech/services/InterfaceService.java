/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.saviortech.services;

import com.saviortech.models.Participant;
import com.saviortech.models.Utilisateur;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author freec
 */
public interface InterfaceService<T> {

    public void ajouter(T o);

    public void modifier(T o);

    public void supprimer(int id);

    public List<T> afficher(String category);

    public int participantNumber(int x);

    public ObservableList<Utilisateur> getParticipants(int id);

    public boolean checkIfParticipated(int userId, int eventId);
}
