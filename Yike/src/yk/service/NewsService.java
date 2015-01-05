package yk.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import yk.bean.News;
import yk.bean.NewsPage;
import yk.bean.Page;
import yk.dao.NewsDao;

public class NewsService {
	NewsDao newsDao = new NewsDao();
	//增加新闻
	public void add(String head, String newsfrom, String time,
			String guideread, String content, String category,String datetime) {
			News news = new News(UUID.randomUUID().toString(),head,newsfrom,time,guideread,content,category,datetime);
			newsDao.add(news);
	}
	public Object getAll(String currentPage) {
		NewsPage page = null;
		int count = 0;
		NewsDao dao = null;
		List<News> list = null;
		dao = new NewsDao();
		count = dao.getCount();
		if(StringUtils.isBlank(currentPage)){
			page = new NewsPage(1,count);
		}else{
			page = new NewsPage(Integer.parseInt(currentPage),count);
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
		obj = newsDao.getOne(id);
		return obj;
	}
	public void saveOneNews(String head, String newsfrom, String time,
			String guideread, String content, String category, String id) {
		News news = new News(id,head,newsfrom,time,guideread,content,category);
		newsDao.saveOneNews(news);
	}
	public void delOne(String id) {
		newsDao.delOne(id);
	}
	
}
