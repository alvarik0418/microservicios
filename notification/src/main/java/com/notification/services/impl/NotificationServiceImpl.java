package com.notification.services.impl;

import com.notification.dto.EmailDTO;
import com.notification.services.INotificacionService;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

@Service
public class NotificationServiceImpl implements INotificacionService {
    @Override
    public ResponseEntity<Boolean> sendNotificacion(EmailDTO email) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        try {
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("", "");
                    }
                });
        Message msg = new MimeMessage(session);


        msg.setFrom(new InternetAddress("alvarik0418@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
        msg.setSubject(email.getSubject());
        msg.setContent(email.getBody(), "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);

        } catch (RuntimeException | MessagingException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(true);
    }
}
