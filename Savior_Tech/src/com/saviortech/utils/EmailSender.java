/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviortech.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author freec
 */
public class EmailSender {

    public void sendEmail(String reciever, String subject, String contentMsg ) throws MessagingException {
        
        // Sender's email ID needs to be mentioned
        String sender = "anis.dh1109@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(sender, "zoujzciejmirxzdv");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);
        // Set From: header field of the header.
        message.setFrom(new InternetAddress(sender));
        // Set To: header field of the header.
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
        // Set Subject: header field
        message.setSubject(subject);
        // Now set the actual message
//        message.setText("This TEST email was sent from SAVIOR TECH Desktop App");

        // Send the actual HTML message, as big as you like
        message.setContent(contentMsg, "text/html");

        System.out.println("sending...");
        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");

    }

}
