package yk.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import yk.bean.Join;
import yk.bean.JoinPage;
import yk.bean.News;
import yk.bean.NewsPage;
import yk.dao.JoinDao;

public class JoinService {

	public void add(String jobname, String jobtext, String time) {
		JoinDao dao = new JoinDao();
		dao.add(jobname,jobtext,time);
	}

	public Object getAll(String currentPage) {
		JoinPage page = null;
		JoinDao dao = new JoinDao();
		int count = 0;
		List<Join> list = null;
		count = dao.getCount();
		if(StringUtils.isBlank(currentPage)){
			page = new JoinPage(1,count);
		}else{
			page = new JoinPage(Integer.parseInt(currentPage),count);
		}
		list = (List<Join>) dao.getPageData(page.getIndex(),page.getSize());
		page.setList(list);
		return page;
	}

	public Object getOne(int id) {
		Object obj = null;
		JoinDao dao = new JoinDao();
		obj = dao.getOne(id);
		return obj;
	}

	public void save(String jobname, String jobtext, String time, int id) {
		JoinDao dao = new JoinDao();
		Join join = new Join(id,jobname,jobtext,time);
		dao.save(join);
		
	}

	public void delete(int id) {
		JoinDao dao = new JoinDao();
		dao.delete(id);
	}

}
