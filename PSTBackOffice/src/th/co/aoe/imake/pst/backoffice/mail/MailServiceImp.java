package th.co.aoe.imake.pst.backoffice.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;
 

public class MailServiceImp  {

	public static void main(String[]args) throws MessagingException{
	}

	public boolean HtmlSendMail(Properties prop,MailModel mail) {

	 
		boolean chkMail = false;
		Session session = Session.getDefaultInstance(prop, null);
		session.setDebug(true);
//		 create a message
		MimeMessage msg = new MimeMessage(session);
		 
		try {			
			msg.setHeader("Content-Transfert-Encoding","8Bit");		
			 
		} catch (MessagingException e) {			
			e.printStackTrace();
		}

		InternetAddress addressFrom = null;
		
		try {			
			addressFrom = new InternetAddress(mail.getMailFrom());
			 
		} catch (AddressException e) {
			e.printStackTrace();
		}
		try {
			addressFrom.setPersonal(mail.getMailFrom(), "UTF-8");
			 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			msg.setFrom(addressFrom);
		} catch (MessagingException e) {
		}
		
		String[] to = mail.getMailTo();
		InternetAddress[] addressTo = new InternetAddress[to.length];
		try {
			for(int i=0;i<to.length;i++){
			addressTo[i] = new InternetAddress(to[i]);
			}
		} catch (AddressException e) {
			 e.printStackTrace();
		}
		if(null != mail.getMailCc() && mail.getMailCc().length > 0){
			String[] cc = mail.getMailCc();
			InternetAddress[] addressCc = new InternetAddress[cc.length];
			try {
				for(int i=0;i<cc.length;i++){
					addressCc[i] = new InternetAddress(cc[i]);
				}
			} catch (AddressException e) {
				e.printStackTrace();
			}
			try {
				msg.setRecipients(Message.RecipientType.CC, addressCc);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
		if(null != mail.getMailBcc() && mail.getMailBcc().length > 0){
			 
			String[] bcc = mail.getMailBcc();
			InternetAddress[] addressBcc = new InternetAddress[bcc.length];
			try {
				for(int i=0;i<bcc.length;i++){
					addressBcc[i] = new InternetAddress(bcc[i]);
				}
			} catch (AddressException e) {
				e.printStackTrace();
			}
			
			try {
				msg.setRecipients(Message.RecipientType.BCC, addressBcc);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			msg.setContent(mail.getMailContent(), "text/html; charset=UTF-8");
			msg.setSubject(mail.getMailSubject(), "UTF-8");
			msg.setHeader("X-Priority","1");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    SMTPTransport t =null;
		try {
			t = (SMTPTransport)session.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
			try {
						t.sendMessage(msg, msg.getAllRecipients());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  finally {			 
		    	try {
					t.close();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		    }
		return chkMail;
	}

	 

}
