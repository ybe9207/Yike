package yk.dao;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import yk.bean.User;
import yk.utils.*;
public class UserDao extends BaseDao {

	public Object getOne(String username, String password) {
		User user = null;
		String sql = null;
		Object[] params = null;
		try{
		ResultSetHandler handler = null;
		handler = new BeanHandler(User.class);
		sql = sqls.get("selectuser");
		params = new Object[]{username,password};
		user = (User)query(sql,handler,params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return user;
	}

}
