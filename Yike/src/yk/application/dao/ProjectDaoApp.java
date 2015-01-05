package yk.application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import yk.bean.Project;
import yk.dao.BaseDao;
import yk.application.dao.ProjectDaoApp.CustomProjectHandler;
import yk.utils.DBUtils;

public class ProjectDaoApp extends BaseDao{

	public int getCount(String project) {
		String sql = null;
		int count = 0;
		Long longCount = null;
		Object obj = null;
		ResultSetHandler handler = null;
		Object params[] = null;
		try {
			sql = sqls.get("projectcount");
			handler = new ScalarHandler(1);
			params = new Object[]{project};
			obj = query(sql, handler, params);
			if (obj instanceof Long) {
				longCount = (Long) obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, null, null);
		}
		return (int) Long.parseLong(longCount + "");
	}

	public List<Project> getPageData(int index, int size,String project) {
		List<Project> list = null;
		String sql = null;
		Object[] params = null;
		ResultSetHandler handler = null;
		try {
			sql = sqls.get("pageproject");
			// 设置参数
			params = new Object[] { project,index, size };
			list = (List<Project>) query(sql, new CustomProjectHandler(),
					params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, null, null);
		}
		return list;
	}
	
	class CustomProjectHandler implements ResultSetHandler {
		// 该方法将您要处理的结果集传递进来，那么开发者只是需要封装即可
		public Object handle(ResultSet set) throws SQLException {
			Project project = null;
			List<Project> list = new LinkedList<Project>();
			// 遍历结果集
			while (set.next()) {
				// 获取列数据
				String id = set.getString(1);
				String head = set.getString(2);
				String imageurl = set.getString(3);
				String text = set.getString(4);
				String category = set.getString(5);
				project = new Project(id, head, imageurl, text, category);

				// 加入集合
				list.add(project);
			}
			return list;
		}
	}

}
