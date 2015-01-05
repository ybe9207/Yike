package yk.application.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import yk.application.bean.ProjectPageApp;
import yk.application.dao.ProjectDaoApp;
import yk.bean.Project;
import yk.bean.ProjectPage;

public class ProjectServiceApp {

	public Object getAll(String currentPage, String project) {
		ProjectPageApp page = null;
		int count = 0;
		ProjectDaoApp dao = null;
		List<Project> list = null;
		dao = new ProjectDaoApp();
		count = dao.getCount(project);
		if(StringUtils.isBlank(currentPage)){
			page = new ProjectPageApp(1,count);
		}else{
			page = new ProjectPageApp(Integer.parseInt(currentPage),count);
		}
		list = (List<Project>) dao.getPageData(page.getIndex(),page.getSize(),project);
		page.setList(list);
		return page;
	}

}
