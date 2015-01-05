package yk.bean;

public class Email {
	private int id;
	private String emailname;
	private String emailtext;
	private String emailtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailname() {
		return emailname;
	}
	public void setEmailname(String emailname) {
		this.emailname = emailname;
	}
	public String getEmailtext() {
		return emailtext;
	}
	public void setEmailtext(String emailtext) {
		this.emailtext = emailtext;
	}
	
	public String getEmailtime() {
		return emailtime;
	}
	public void setEmailtime(String emailtime) {
		this.emailtime = emailtime;
	}
	public Email(int id, String emailname, String emailtext, String emailtime) {
		super();
		this.id = id;
		this.emailname = emailname;
		this.emailtext = emailtext;
		this.emailtime = emailtime;
	}
	public Email() {
		super();
	}
	
}
