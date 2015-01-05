package yk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.lang3.StringUtils;

import yk.bean.Join;
import yk.utils.DBUtils;

public class JoinDao extends BaseDao{

	public void add(String jobname, String jobtext, String time) {
		String sql = null;
		Object[] params = null;
		try{
		 sql = sqls.get("insertjob");
		 params = new Object[]{jobname,jobtext,time};
		 update(sql,params);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}

	public Object getPageData(int index, int size) {
		List<Join> list = null;
		String sql = null;
		ResultSetHandler handler = null;
		try{
			sql = sqls.get("selectjob");
			//设置参数
			list =(List<Join>)query(sql,new CustomJobHandler(),null);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return list;
	}
	
	class CustomJobHandler implements ResultSetHandler{
		// 该方法将您要处理的结果集传递进来，那么开发者只是需要封装即可
				public Object handle(ResultSet set) throws SQLException {
					Join join = null;
					List<Join> list = new LinkedList<Join>();
					// 遍历结果集
					while (set.next()) {
						// 获取列数据
						int id = set.getInt(1);
						String jobname = set.getString(2);
						String jobtext = set.getString(3);
						String jobtime = set.getString(4);
						join = new Join(id, jobname, jobtext, jobtime);

						// 加入集合
						list.add(join);
					}
					return list;
				}
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getOne(int id) {
		List<Join> list = null;
		String sql = null;
		Object[] params = null;
		try{
			sql = sqls.get("selectonejob");
			params = new Object[]{id};
			list = (List<Join>) query(sql,new CustomJobHandler(),params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return list.size() > 0?list.get(0):null;
	}

	public void save(Join join) {
		Join job = join;
		String sql = null;
		Object[] params = null;
		try{
			if(job.getId() != 0){
				sql = sqls.get("updatejob");
				params = new Object[]{job.getJobname(),job.getJobtext(),job.getJobtime(),job.getId()};
				update(sql,params);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}

	public void delete(int id) {
		String sql = null;
		Object [] params = null;
		try{
			sql = sqls.get("deleteonejob");
			params = new Object[]{id};
			update(sql,params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}

}
