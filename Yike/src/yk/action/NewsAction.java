package yk.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import yk.bean.News;
import yk.bean.NewsPage;
import yk.bean.Page;
import yk.service.NewsService;

public class NewsAction extends ActionSupport{
	private String head;
	private String newsfrom;
	private String guideread;
	private String content;
	private String category;
	NewsService newsService = null;
	//增加新闻
	public String addnews(){
		String datetime = null;
		newsService = new NewsService();
		String time = null;
		try{
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		time =sd.format(new Date());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
		datetime =sdf.format(new Date());
		newsService.add(head,newsfrom,time,guideread,content,category,datetime);
		ServletActionContext.getRequest().setAttribute("message", "添加成功!");
		return "success";
		}catch(Exception e){
			e.printStackTrace();
		return "input";	
		}
	}
	//查询所有新闻信息
	public String getAllNews(){
		NewsPage page = null;
		String currentPage = null;
		newsService = new NewsService();
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (NewsPage) newsService.getAll(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
	//编辑新闻信息
	public String edit(){
		String id = null;
		News news = null;
		newsService = new NewsService();
		try{
			id = ServletActionContext.getRequest().getParameter("id");
			news = (News) newsService.getOne(id);
			ServletActionContext.getRequest().setAttribute("news", news);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	//更新新闻信息
	public String saveOneNews(){
		String id = null;
		newsService = new NewsService();
		String time = null;
		try{
		id = ServletActionContext.getRequest().getParameter("id");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		time =sdf.format(new Date()); 
		newsService.saveOneNews(head,newsfrom,time,guideread,content,category,id);
		ServletActionContext.getRequest().setAttribute("message", "更新成功!");
		return "success";
		}catch(Exception e){
			e.printStackTrace();
		return "input";	
		}
	}
	//删除新闻
	public String delOne(){
		String id = null;
		newsService = new NewsService();
		try{
		id = ServletActionContext.getRequest().getParameter("id");
		ServletActionContext.getRequest().setAttribute("message", "删除成功!");
		newsService.delOne(id);
		return "success";
		}catch(Exception e){
			e.printStackTrace();
		return null;
		}

	}
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getNewsfrom() {
		return newsfrom;
	}
	public void setNewsfrom(String newsfrom) {
		this.newsfrom = newsfrom;
	}
	public String getGuideread() {
		return guideread;
	}
	public void setGuideread(String guideread) {
		this.guideread = guideread;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
