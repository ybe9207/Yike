package yk.application.email;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Sender {
	private String receiver = "284920603@qq.com";
	private String subject;
	private String mailContent;
	//private String cc = "murongyuhong@163.com";//抄送人
	private Session session;
	private Message msg;
	
	public void sendNow(String emailname, String text){
		subject = emailname+"发来邮件！";
		mailContent = text;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.163.com");
		session = Session.getDefaultInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication(){
				//发送邮件的账号密码
				return new PasswordAuthentication("ybe9207", "iaiwozijihxl1314");
			}
		});
		session.setDebug(true);
		
		try{
			msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("ybe9207@163.com"));//发送人
			InternetAddress toAddress = new InternetAddress(receiver);// 收件人
			msg.addRecipient(Message.RecipientType.TO, toAddress);// 加收件人
			//InternetAddress ccAddress = new InternetAddress(cc);// 抄送收件人
			//msg.addRecipient(Message.RecipientType.CC, ccAddress);// 加收件人
			msg.setSubject(subject);
			msg.setText(mailContent);
			Transport.send(msg);
		}catch(javax.mail.MessagingException ex){
			while((ex = (MessagingException) ex.getNextException()) != null)
				ex.printStackTrace();
		}
	}
}
