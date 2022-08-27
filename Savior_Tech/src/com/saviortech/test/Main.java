/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.test;

import com.saviortech.models.Events;
import com.saviortech.models.Participant;
import com.saviortech.services.EventService;
import java.sql.Date;

/**
 *
 * @author freec
 */
public class Main {

    public static void main(String[] args) {

        EventService eveSer = new EventService();

//       eveSer.ISEvents().ajouter(new Events("xxxxxxxxxxxx", "https://www.trickyenough.com/wp-content/uploads/2020/08/development-scaled.jpg", "Web Developement", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(2022,8,8), new Date(2022,9,8), "active", "Elife Siliana, ISET Street", 5, "ELIFE Center", 0, 50));
//        System.out.println(eveSer.ISEvents().afficher());
//        System.out.println(eveSer.ISParticipant().afficher());
//        eveSer.ISParticipant().ajouter(new Participant(3, 5));
//          System.out.println(eveSer.ISParticipant().participantNumber());
    }
}
