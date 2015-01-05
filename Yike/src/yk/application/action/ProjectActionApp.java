package yk.application.action;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import yk.application.bean.ProjectPageApp;
import yk.application.service.ProjectServiceApp;
import yk.bean.ProjectPage;

import com.opensymphony.xwork2.ActionSupport;

public class ProjectActionApp extends ActionSupport {
	private ProjectServiceApp projectService = null;
	public String getProject(){
		ProjectPageApp page = null;
		projectService = new ProjectServiceApp();
		String project = null;
		project = ServletActionContext.getRequest().getParameter("project");
		try {
			project = new String(project.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String currentPage = null;		
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (ProjectPageApp) projectService.getAll(currentPage,project);
		System.out.println(project+"....."+currentPage);
		ServletActionContext.getRequest().setAttribute("projectname", project);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
}
