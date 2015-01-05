package yk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import yk.bean.Email;
import yk.utils.DBUtils;

public class EmailDao extends BaseDao{

	public int getCount() {
		String sql = null;
		int count = 0;
		Long longCount = null;
		Object obj = null;
		ResultSetHandler handler = null;
		try{
			sql = sqls.get("getemailcount");
			handler = new ScalarHandler(1);
			obj = query(sql,handler,null);
			if(obj instanceof Long){
				longCount = (Long) obj;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return (int)Long.parseLong(longCount+"");
	}

	public List<Email> getPageData(int index, int size) {
		List<Email> list = null;
		String sql = null;
		Object [] params = null;
		ResultSetHandler handler = null;
		try{
			sql = sqls.get("selectpageemail");
			//设置参数
			params = new Object[]{index,size};
			list =(List<Email>)query(sql,new CustomEmailHandler(),params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return list;
	}
	class CustomEmailHandler implements ResultSetHandler{
		// 该方法将您要处理的结果集传递进来，那么开发者只是需要封装即可
				public Object handle(ResultSet set) throws SQLException {
					Email email = null;
					List<Email> list = new LinkedList<Email>();
					// 遍历结果集
					while (set.next()) {
						// 获取列数据
						int id = set.getInt(1);
						String emailname = set.getString(2);
						String emailtext = set.getString(3);
						String emailtime = set.getString(4);
						email = new Email(id, emailname, emailtext, emailtime);

						// 加入集合
						list.add(email);
					}
					return list;
				}
	}
}
