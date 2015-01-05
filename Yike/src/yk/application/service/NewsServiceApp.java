package yk.application.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import yk.application.bean.NewsPageApp;
import yk.application.dao.NewsDaoApp;
import yk.bean.News;
import yk.bean.NewsPage;

public class NewsServiceApp {
	NewsDaoApp dao = new NewsDaoApp(); 
	public Object getAll(String currentPage) {
		NewsPageApp page = null;
		int count = 0;
		List<News> list = null;
		count = dao.getCount();
		if(StringUtils.isBlank(currentPage)){
			page = new NewsPageApp(1,count);
		}else{
			page = new NewsPageApp(Integer.parseInt(currentPage),count);
		}
		list = (List<News>) dao.getPageData(page.getIndex(),page.getSize());
		page.setList(list);
		return page;
	}
	public Object getOne(String id) {
		Object obj = null;
		if(id == null){
			return null;
		}
		obj = dao.getOne(id);
		return obj;
	}
	public Object getAll(String currentPage, String category) {
		NewsPageApp page = null;
		int count = 0;
		List<News> list = null;
		count = dao.getCount(category);
		if(StringUtils.isBlank(currentPage)){
			page = new NewsPageApp(1,count);
		}else{
			page = new NewsPageApp(Integer.parseInt(currentPage),count);
		}
		list = (List<News>) dao.getPageData(page.getIndex(),page.getSize(),category);
		page.setList(list);
		return page;
	}

}
