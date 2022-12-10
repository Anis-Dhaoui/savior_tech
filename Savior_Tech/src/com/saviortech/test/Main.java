/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.test;

import com.saviortech.models.Events;
import com.saviortech.models.Participant;
import com.saviortech.models.Utilisateur;
import com.saviortech.services.EventPartService;
import com.saviortech.services.ServiceUtilisateur;
import com.saviortech.utils.EmailSender;
import com.saviortech.utils.PasswordGenerator;
import com.saviortech.utils.UUIDGenerator;
import java.sql.SQLException;
import javax.mail.MessagingException;

/**
 *
 * @author freec
 */
public class Main {

    public static void main(String[] args) throws SQLException, MessagingException {
        String name = "Anis Dhaoui";
        EventPartService eveSer = new EventPartService();
        ServiceUtilisateur su = new ServiceUtilisateur();

        String generatedPassword = PasswordGenerator.getRandomPassword();

        String newPassword = "<h1> Your new password is " + generatedPassword + " </h1>";
        
        System.out.println(generatedPassword);
//                EmailSender sendEmailTest = new EmailSender();
//        sendEmailTest.sendEmail("jamila.nouri@esprit.tn", "Reset Password", newPassword);




//        String emailContent = "    <div>\n"
//            + "        <div>Dear<b>" + name + "</b></div>\n"
//            + "        <div>\n"
//            + "            <p>\n"
//            + "                It has been an honor to have you present in our event. Your participation ensured the success of our\n"
//            + "                event.\n"
//            + "                As mentioned in the invitation letter, a certificate of appreciation will be\n"
//            + "                granted to all participants. Winners will be awarded shields. Chief\n"
//            + "                guests will also be honored with an honorary certificate.\n"
//            + "            </p>\n"
//            + "            <p>\n"
//            + "                We hope to invite you again soon. Please keep visiting us for further events and their details.\n"
//            + "            </p>\n"
//            + "            <br>\n"
//            + "            <p>Thank you.</p>\n"
//            + "        </div>\n"
//            + "    </div>";
//        System.out.println(su.validate("DjamilaKH1", "9ae48df22b0715e18485142038a890cf"));


//        su.ajouter(new Utilisateur(new UUIDGenerator().getUuid().toString(), "aaaa", "bbb", "ccccccc", "dddddd", "eeeee", "ffffffff", "jjjjjjjjj", "hhhhhhhhhh"));
        //System.out.println(su.afficher());
//       eveSer.ISEvents().ajouter(new Events("xxxxxxxxxxxx", "https://www.trickyenough.com/wp-content/uploads/2020/08/development-scaled.jpg", "Web Developement", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(2022,8,8), new Date(2022,9,8), "active", "Elife Siliana, ISET Street", 5, "ELIFE Center", 0, 50));
//        System.out.println(eveSer.ISEvents().afficher());
        // eveSer.ISEvents().ajouter(new Events("xxxxxxxxxxxx",1,"Web Developement", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", new Date(2022,8,8), new Date(2022,9,8), "active", "Elife Siliana, ISET Street", 5, "ELIFE Center", 0, 50));
        //System.out.println(eveSer.ISEvents().afficher());
//        System.out.println(eveSer.ISParticipant().getParticipants(1));
//        eveSer.ISParticipant().ajouter(new Participant(3, 5));
//          System.out.println(eveSer.ISParticipant().participantNumber());
    }
}
