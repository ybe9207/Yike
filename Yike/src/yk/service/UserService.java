package yk.service;

import org.apache.commons.lang3.StringUtils;

import yk.bean.User;
import yk.dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	public Object getOne(String username, String password) {
		User user = null;
		//判断是否空白
		if(StringUtils.isBlank(username)|| StringUtils.isBlank(password)){
		return null;
		}
		user = (User)userDao.getOne(username,password);
		return user;
	}

}
