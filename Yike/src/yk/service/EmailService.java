package yk.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import yk.bean.Email;
import yk.bean.EmailPage;
import yk.dao.EmailDao;

public class EmailService {

	public Object getAll(String currentPage) {
		EmailPage page = null;
		int count = 0;
		EmailDao dao = null;
		List<Email> list = null;
		dao = new EmailDao();
		count = dao.getCount();
		if(StringUtils.isBlank(currentPage)){
			page = new EmailPage(1,count);
		}else{
			page = new EmailPage(Integer.parseInt(currentPage),count);
		}
		list = (List<Email>) dao.getPageData(page.getIndex(),page.getSize());
		page.setList(list);
		return page;
	}

}
