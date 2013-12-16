package th.co.aoe.imake.pst.backoffice.mail;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringEscapeUtils;

import com.sun.mail.smtp.SMTPTransport;

public class MailRunnable implements Runnable {
	String subject = null;
	String messagebody = null;
	String sessionId= null;
	String protocal=null;
	String  host=null;
	String email =null;
	String  password=null;
	String  useAuthen=null;
	@SuppressWarnings("rawtypes")
	List recipients=null;
	@SuppressWarnings("rawtypes")
	List recipients_cc=null;
	@SuppressWarnings("rawtypes")
	List recipients_bcc=null;
	byte[] fileSize=null;
	String personal_name=null;
	String port=null;
	String tls=null;
	@SuppressWarnings("rawtypes")
	public MailRunnable(String protocal_,String  host_,String email_ ,String  password_,String  useAuthen_,
			List recipients
			,String subject,String messagebody,String sessionId,String personal_name,String port,
			List recipients_cc,List recipients_bcc,byte[] fileSize,String tls) {
		this.subject = subject;
		this.messagebody = messagebody;
		this.sessionId = sessionId;
		this.protocal=protocal_;
		this. host=host_;
		this.email =email_;
		this. password=password_;
		this. useAuthen=useAuthen_;
		this.recipients=recipients;
		this.personal_name=personal_name;
		this.port=port;
		this.recipients_cc=recipients_cc;
		this.recipients_bcc=recipients_bcc;
		this.fileSize=fileSize;
		this.tls=tls;
	}
	public void run() { 
		File temp  = null;
		Properties props = new Properties();
	    boolean isAuthen = false;
	    props.put("protocol", protocal);//"smtp");
			if(tls!=null && tls.toLowerCase().equals("1"))
				props.put("mail.smtp.starttls.enable","true");
			props.put("mail.smtp.host", host);//"smtp.gmail.com");
			props.put("mail.smtp.port",port);
			
			if(useAuthen!=null && useAuthen.equals("1")){
				isAuthen = true;
			}
			if(isAuthen)
			  props.put("mail.smtp.auth", "true");
		    
			 	int size = recipients.size();
			 	for (int i = 0; i < size; i++) {
					
					 Session session = Session.getDefaultInstance(props, null);
					    session.setDebug(true);
			MimeMessage msgArray[] = null;// new MimeMessage(session); 
			try {
				msgArray = new MimeMessage[1];//recipients.length];  
		    	InternetAddress[] addressTo = new InternetAddress[1];//recipients.length];
		    	Date date = new Date();
		    	StringBuffer sb = new StringBuffer();
				sb.append("<HTML>\n");
				sb.append("<HEAD>\n");
				sb.append("<TITLE>\n");
				sb.append(" MissConsult " + "\n");
				sb.append("</TITLE>\n");
				sb.append("</HEAD>\n");
				sb.append("<BODY>\n");
				sb.append(messagebody);
				sb.append("\n");
				sb.append("</BODY>\n");
				sb.append("</HTML>\n");
				MimeBodyPart mbp1 = new MimeBodyPart(); 
				String message = StringEscapeUtils.unescapeHtml3(sb.toString());
				mbp1.setContent(message, "text/html; charset=UTF-8");		
				
				Multipart mp = new MimeMultipart();
				mp.addBodyPart(mbp1);				 
				if(fileSize!=null && fileSize.length>0){
					FileOutputStream fos = null;
					
					try {
						 MimeBodyPart mbp2 = new MimeBodyPart();
						 temp = File.createTempFile(genToken(),".howto"); 
						 temp.deleteOnExit();
						 fos = new FileOutputStream(temp.getAbsolutePath());
						
						 fos.write(fileSize); 
						 
						 	mbp2.attachFile(temp);
							mbp2.setFileName("Report.pdf");
							mp.addBodyPart(mbp2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						if(fos!=null)
							try {
								fos.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
						 
					} 
				}
				
				InternetAddress addressFrom=null;
				try {
					if(personal_name!=null && personal_name.length()>0)
						addressFrom = new InternetAddress(email,personal_name);
					else
						addressFrom = new InternetAddress(email);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					addressTo[0] = new InternetAddress(((String)recipients.get(i)).trim(),false);
				
					msgArray[0] = new MimeMessage(session);
					msgArray[0].setFrom(addressFrom); 
					msgArray[0].setRecipient(Message.RecipientType.TO,addressTo[0]);
					
					//set CC
					if(recipients_cc!=null && recipients_cc.size()>0){
						InternetAddress[] addressCC = new InternetAddress[recipients_cc.size()];
						for (int j = 0; j < recipients_cc.size(); j++) {
							InternetAddress	address = new InternetAddress(((String)recipients_cc.get(j)).trim(),false);
							addressCC[j]=address; 
						}
						msgArray[0].setRecipients(Message.RecipientType.CC,addressCC);
					}
					//set BCC
					if(recipients_bcc!=null && recipients_bcc.size()>0){
						InternetAddress[] addressBCC = new InternetAddress[recipients_bcc.size()];
						for (int j = 0; j < recipients_bcc.size(); j++) {
							InternetAddress	address= new InternetAddress(((String)recipients_bcc.get(j)).trim(),false);
							addressBCC[j]=address;							
						}
						msgArray[0].setRecipients(Message.RecipientType.BCC,addressBCC);
					}
					
					msgArray[0].setSentDate(date);
					 try {
						 msgArray[0].setSubject(subject,"UTF-8");
						 msgArray[0].setHeader("Content-Transfert-Encoding","8Bit");
						 msgArray[0].setContent(mp);
					 } catch (MessagingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
					 }
			} catch (AddressException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
					if(isAuthen)
						t.connect(host, email, password);
					else
						t.connect();
							t.sendMessage(msgArray[0], msgArray[0].getAllRecipients());
						
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
					if(temp!=null){
						if(temp.exists() && temp.isFile())
							temp.delete();
					}
			    } 
			}
	}
	 private String genToken(){
	  		StringBuffer sb = new StringBuffer();
	  	    for (int i = 36; i > 0; i -= 12) {
	  	      int n = Math.min(12, Math.abs(i));
	  	      sb.append(org.apache.commons.lang3.StringUtils.leftPad(Long.toString(Math.round(Math.random() * Math.pow(36, n)), 36), n, '0'));
	  	    }
	  	    return sb.toString();
	   }
}
