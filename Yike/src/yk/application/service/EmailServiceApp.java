package yk.application.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import yk.application.dao.EmailDaoApp;
import yk.application.email.Sender;

public class EmailServiceApp {
	
	public void send(String emailname, String text) {
		EmailDaoApp emailDao = new EmailDaoApp();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String emailtime =sdf.format(new Date());
		Sender sender = new Sender();
		sender.sendNow(emailname, text);
		emailDao.save(emailname,text,emailtime);
	}
	
}
