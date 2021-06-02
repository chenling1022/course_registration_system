package Controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * represents a controller which sends notification to users
 * @author 
 *
 */
public class NotificationController {
	/**
	 * method to send sms to a recipient 
	 * @param recipientNum
	 *           the recipient's phone number
	 */
	public static void sendSMS(String recipientNum) {
		System.out.println("An SMS has been sent to " + recipientNum + "\n");
	}
    /**
     * method to send email to a recipient.
     * @param recEmail
     * @param CourseCode
     * @param IndexNo
     */
	public static void SendEmail(String recEmail, String CourseCode, String IndexNo ) {

		final String username = "java.oodp.stars@gmail.com"; // to be added
		final String password = "javatest"; // to be added

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("java.oodp.stars@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recEmail)); // to be added an email addr
			message.setSubject("Course Registered");
			message.setText("Dear Student,"
				+ "\n\n You have successfully been registered to Course "+ CourseCode + " in Index "+ IndexNo+". Please Log in to the Stars App to print your timetable");

			Transport.send(message);

			System.out.println("Email Successfully sent to "+ recEmail);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
// Testing
/*
	public static void main(String[] args) {
		SendEmail("kiranbodipati@gmail.com", "CZ2002", "11099");
		SendEmail("vaidyanathanabhishek@gmail.com", "CZ4041", "10021");
		sendSMS("82474652");
	}
*/
}