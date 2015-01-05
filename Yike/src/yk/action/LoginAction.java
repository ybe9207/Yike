package yk.action;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import yk.bean.User;
import yk.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	UserService userService = new UserService();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		User user = null;
		user = (User) userService.getOne(getUsername(),getPassword());
		System.out.println("action层user："+user);
		if(user == null){
			//登陆不成功
			return "error";
		}
		else{
			//登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user.getUsername());
			return "success";
		}
		
	}
	
	public String logout(){
		String path = null;	
			ServletActionContext.getRequest().getSession().removeAttribute("user");
			ServletActionContext.getRequest().getSession().invalidate();
		return "success";
	}
}
