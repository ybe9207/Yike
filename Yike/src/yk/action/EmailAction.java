package yk.action;

import org.apache.struts2.ServletActionContext;

import yk.bean.EmailPage;
import yk.service.EmailService;
import yk.service.NewsService;

import com.opensymphony.xwork2.ActionSupport;

public class EmailAction extends ActionSupport{
	EmailService emailservice = null;
	public String getAll(){
		EmailPage page = null;
		String currentPage = null;
		emailservice = new EmailService();
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (EmailPage) emailservice.getAll(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
}
