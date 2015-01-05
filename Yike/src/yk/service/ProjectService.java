package yk.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import yk.bean.Page;
import yk.bean.Project;
import yk.bean.ProjectPage;
import yk.dao.ProductDao;
import yk.dao.ProjectDao;

public class ProjectService {
	ProjectDao projectDao = new ProjectDao();
	public void add(String projectname, String img, String description,
			String id, String category) {
		Project project = new Project(id,projectname,img,description,category);
		projectDao.add(project);
	}
	public Object getAll(String currentPage) {
		ProjectPage page = null;
		int count = 0;
		ProjectDao dao = null;
		List<Project> list = null;
		
		dao = new ProjectDao();
		count = dao.getCount();
		if(StringUtils.isBlank(currentPage)){
			page = new ProjectPage(1,count);
		}else{
			page = new ProjectPage(Integer.parseInt(currentPage),count);
		}
		list = (List<Project>) dao.getPageData(page.getIndex(),page.getSize());
		page.setList(list);
		return page;
	}
	public Object getOne(String id) {
		Object obj = null;
		if(id == null){
			return null;
		}
		obj = projectDao.getOne(id);
		return obj;
	}
	public void saveOnenoimg(String projectname, String description, String id,
			String category) {
		projectDao.saveOnenoimg(projectname,description,id,category);
	}
	public void saveOne(String projectname, String img, String description,
			String id, String category) {
		Project project = new Project(id,projectname,img,description,category);
		projectDao.saveOne(project);
	}
	public void delOne(String id) {
		projectDao.delOne(id);
	}

}
