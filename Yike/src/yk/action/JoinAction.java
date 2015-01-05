package yk.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import yk.bean.Join;
import yk.bean.JoinPage;
import yk.service.JoinService;
import yk.service.NewsService;


import com.opensymphony.xwork2.ActionSupport;

public class JoinAction extends ActionSupport {
	private String jobname;
	private String jobtext;
	JoinService joinService;
	public String getAll(){
		joinService = new JoinService();
		String currentPage = null;
		JoinPage page = null;
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (JoinPage) joinService.getAll(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
	public String addOne(){
		joinService = new JoinService();
		String time = null;
		try{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time =sd.format(new Date());
		joinService.add(jobname,jobtext,time);
		ServletActionContext.getRequest().setAttribute("message", "添加成功!");
		return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}
	
	public String edit(){
		int id = 0;
		Join join = null;
		joinService = new JoinService();
		try{
			id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
			System.out.println(id);
			join = (Join) joinService.getOne(id);
			ServletActionContext.getRequest().setAttribute("join", join);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	public String save(){
		int id = 0;
		joinService = new JoinService();
		String time = null;
		try{
		id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time =sd.format(new Date());
		joinService.save(jobname,jobtext,time,id);
		ServletActionContext.getRequest().setAttribute("message", "修改成功!");
		return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}
	
	public String delete(){
		int id = 0;
		joinService = new JoinService();
		try{
		id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		System.out.println("action:"+id);
		joinService.delete(id);
		ServletActionContext.getRequest().setAttribute("message", "删除成功!");
		return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}
	
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public String getJobtext() {
		return jobtext;
	}
	public void setJobtext(String jobtext) {
		this.jobtext = jobtext;
	}
	
	
}
