package method;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class Mail {
	
	public void Send() {
		//final String SMTP_SERVER = "smtp.gmail.com";
		final String SMTP_SERVER = "outlook.office365.com";
        
        //final String EMAIL_FROM = "shareclient999@gmail.com";
		final String EMAIL_FROM = "from adress";        
        final String EMAIL_TO = "to adress";
        final String EMAIL_SUBJECT = "Automated Test Results";
        final String EMAIL_TEXT = "Hi from Amar";
        final String username = "name";
        final String password = "";
        Properties prop = System.getProperties();
           prop.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
           prop.put("mail.smtp.auth", "true");
           prop.put("mail.smtp.port", "587"); // default port 25
           prop.put("mail.smtp.starttls.enable", "true"); //TLS
           
           
           Session session = Session.getInstance(prop,
                   new javax.mail.Authenticator() {
                       protected PasswordAuthentication getPasswordAuthentication() {
                           return new PasswordAuthentication(username, password);
                       }
                   });
           
           try
           {
           
          // Session session = Session.getInstance(prop, null);
           Message msg = new MimeMessage(session);
      
               
               // from
               msg.setFrom(new InternetAddress(EMAIL_FROM));



               // to 
               msg.setRecipients(Message.RecipientType.TO,
                       InternetAddress.parse(EMAIL_TO, false));



               // cc
//               msg.setRecipients(Message.RecipientType.CC,
//                       InternetAddress.parse(EMAIL_TO_CC, false));



               // subject
               msg.setSubject(EMAIL_SUBJECT);
               
               // content 
               msg.setText(EMAIL_TEXT);
               
               msg.setSentDate(new Date());



               // Get SMTPTransport
               SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
               
               // connect
               t.connect(SMTP_SERVER,username , password);
               
               // send
               t.sendMessage(msg, msg.getAllRecipients());



               System.out.println("Response: " + t.getLastServerResponse());



               t.close();



           }
           
           catch (MessagingException e) 
           {
               e.printStackTrace();
           }
	}
}
