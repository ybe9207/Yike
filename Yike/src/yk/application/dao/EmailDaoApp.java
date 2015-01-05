package yk.application.dao;

import yk.dao.BaseDao;
import yk.utils.DBUtils;

public class EmailDaoApp extends BaseDao{

	public void save(String emailname, String text, String emailtime) {
		String sql = null;
		Object[] params = null;
		try{
		 sql = sqls.get("insertemail");
		 params = new Object[]{emailname,text,emailtime};
		 update(sql,params);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}

}
