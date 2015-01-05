package yk.application.action;

import yk.application.service.EmailServiceApp;

public class EmailApp {
	private String emailname;
	private String text;
	private String name;
	private String phone;
	public String getEmailname() {
		return emailname;
	}
	public void setEmailname(String emailname) {
		this.emailname = emailname;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String send(){
		String txt = "客户名字："+name+"，"+"客户电话："+phone+"，"+"客户留言："+text;
		EmailServiceApp emailservice = new EmailServiceApp();
		emailservice.send(emailname,txt);
		return "success";
	}
}
