package yk.application.action;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import yk.application.bean.NewsPageApp;
import yk.application.service.NewsServiceApp;
import yk.bean.News;
import yk.bean.NewsPage;
import yk.service.NewsService;

import com.opensymphony.xwork2.ActionSupport;

public class NewsActionApp extends ActionSupport {
	NewsServiceApp newsService = null;
	//获取全部新闻信息
	public String getAll(){
		NewsPageApp page = null;
		String currentPage = null;
		newsService = new NewsServiceApp();
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (NewsPageApp) newsService.getAll(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
	//获取一个新闻详细信息
	public String getOne(){
		String id = null;
		News news = null;
		newsService = new NewsServiceApp();
		try{
			id = ServletActionContext.getRequest().getParameter("id");
			news = (News) newsService.getOne(id);
			ServletActionContext.getRequest().setAttribute("news", news);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	//获取一个类别的新闻
	public String getnews(){
		NewsPageApp page = null;
		String currentPage = null;
		String category = null;
		category = ServletActionContext.getRequest().getParameter("category");
		try {
			category = new String(category.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		newsService = new NewsServiceApp();
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (NewsPageApp) newsService.getAll(currentPage,category);
		ServletActionContext.getRequest().setAttribute("category", category);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
}
