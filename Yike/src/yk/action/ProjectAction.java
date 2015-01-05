package yk.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import yk.bean.Project;
import yk.bean.ProjectPage;
import yk.service.NewsService;
import yk.service.ProductService;
import yk.service.ProjectService;

import com.opensymphony.xwork2.ActionSupport;

public class ProjectAction extends ActionSupport{
	private String projectname;
	private String category;
	private String description;
	private File file;
	private ProjectService projectService = null;
	
	public String add(){
		String dir =null;//保存路径
		File target = null;
		String img = null;//文件的名字
		String id = null;
		projectService = new ProjectService();
		try{
			dir = ServletActionContext.getServletContext().getRealPath("/upload");
			id = UUID.randomUUID().toString();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		    img =sdf.format(new Date());
			target = new File(dir,img+".jpg");
			FileUtils.copyFile(file, target);
			projectService.add(projectname,img,description,id,category);
			ServletActionContext.getRequest().setAttribute("message", "添加成功!");
			return "success";
			}catch (Exception e){
				e.printStackTrace();
			return "input";
			}
	}
	public String getAll(){
		ProjectPage page = null;
		String currentPage = null;
		projectService = new ProjectService();
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (ProjectPage) projectService.getAll(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
	public String edit(){
		String id = null;
		Project project = null;
		projectService = new ProjectService();
		try{	
		id = ServletActionContext.getRequest().getParameter("id");
		project = (Project) projectService.getOne(id);
		ServletActionContext.getRequest().setAttribute("project", project);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	public String saveOne(){
		String dir =null;//保存路径
		File target = null;
		String img = null;//文件的名字
		String id = null;
		projectService = new ProjectService();
		System.out.println("projectname:"+projectname+"file:"+file);
		if(file == null){
			id = ServletActionContext.getRequest().getParameter("id");
			projectService.saveOnenoimg(projectname,description,id,category);
			ServletActionContext.getRequest().setAttribute("message", "更新成功!");
			return "success";
		}else{
		try{
			dir = ServletActionContext.getServletContext().getRealPath("/upload");
			id = ServletActionContext.getRequest().getParameter("id");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		    img =sdf.format(new Date());
			target = new File(dir,img+".jpg");
			FileUtils.copyFile(file, target);
			projectService.saveOne(projectname,img,description,id,category);
			ServletActionContext.getRequest().setAttribute("message", "更新成功!");
			return "success";
			}catch (Exception e){
				e.printStackTrace();
			return "input";
			}
		}
	}

	public String delOne(){
		String id = null;
		projectService = new ProjectService();
		try{
		id = ServletActionContext.getRequest().getParameter("id");
		ServletActionContext.getRequest().setAttribute("message", "删除成功!");
		projectService.delOne(id);
		return "success";
		}catch(Exception e){
			e.printStackTrace();
		return null;
		}

	}
	
	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
}
