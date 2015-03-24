package co.edu.usbcali.correo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailController {

    private String from;
    private String host;

    private Properties properties;

    private MimeMessage message;
    private BodyPart messageBodyPart;
    private Multipart multipart;

    private Authenticator authenticator;

    public EmailController () {
        from = "lukitas1977.br@gmail.com";
        //subject = "Bienvenido al sistema VAOI";
        //messageBody = "<html><body><h1>Registro Exitoso" +
         //           " CALM :-) I AM WITH YOU, OKAY :-)</h1></body></html>";
        host = "smtp.gmail.com";

        authenticator = new SMTPAuthenticator ();
        properties = System.getProperties ();
        properties.put("mail.transport.protocol", "smtp");
        properties.put ( "mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put ( "mail.smtp.host", host);
        properties.put ( "mail.smtp.port", "587");
        properties.put ( "mail.smtp.auth", "true");
    }

    private void sendMail (String to,
                    String subject, String messageBody, String fileName ) throws Exception{
        try {
            Session session = Session.getDefaultInstance ( properties, authenticator );
            message = new MimeMessage ( session );
            message.setFrom ( new InternetAddress ( from ) );
            message.addRecipient ( Message.RecipientType.TO,
                                new InternetAddress ( to ) );
            message.setSubject ( subject );

            multipart = new MimeMultipart ();
            messageBodyPart = new MimeBodyPart ();
            messageBodyPart.setContent ( messageBody, "text/html" );
            multipart.addBodyPart ( messageBodyPart );

            message.setContent ( multipart );

            Transport.send ( message );
            System.out.println ( "Mensaje Enviado...." );
        } catch ( Exception me ) {
            throw me;
        }
    } 

    public void performTask (String to, String subject, String messageBody, String fileName ) throws Exception{
        sendMail (to, subject, messageBody, fileName);
    }
}

/**
  * SimpleAuthenticator is used to do simple authentication
  * when the SMTP server requires it.
  */

class SMTPAuthenticator extends Authenticator {

    private static final String SMTP_AUTH_USER = "lukitas1977.br@gmail.com";
    private static final String SMTP_AUTH_PASSWORD = "lcbrf1977";

    public PasswordAuthentication getPasswordAuthentication () {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PASSWORD;

        return new PasswordAuthentication( username,  password );
    }
}
