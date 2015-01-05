package yk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import yk.bean.Project;
import yk.dao.ProductDao.CustomProductHandler;
import yk.utils.DBUtils;

public class ProjectDao extends BaseDao {

	public void add(Object obj) {
		Project project = null;
		String sql = null;
		Object[] params = null;
		// 转型
		if (obj instanceof Project) {
			project = (Project) obj;
		}
		try {
			sql = sqls.get("insertproject");
			params = new Object[] { project.getId(), project.getHead(),
					project.getImageurl(), project.getText(),
					project.getCategory() };
			update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, null, null);
		}
	}

	public int getCount() {
		String sql = null;
		int count = 0;
		Long longCount = null;
		Object obj = null;
		ResultSetHandler handler = null;
		try {
			sql = sqls.get("getprojectcount");
			handler = new ScalarHandler(1);
			obj = query(sql, handler, null);
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

	public Object getPageData(int index, int size) {
		List<Project> list = null;
		String sql = null;
		Object[] params = null;
		ResultSetHandler handler = null;
		try {
			sql = sqls.get("selectpageproject");
			// 设置参数
			params = new Object[] { index, size };
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

	public Object getOne(String id) {
		List<Project> list = null;
		String sql = null;
		Object[] params = null;
		System.out.println(id);
		try {
			sql = sqls.get("selectoneproject");
			params = new Object[] { id };
			list = (List<Project>) query(sql, new CustomProjectHandler(),
					params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, null, null);
		}
		return list.size() > 0 ? list.get(0) : null;
	}

	public void saveOnenoimg(String projectname, String description, String id,
			String category) {
		String sql = null;
		Object[] params = null;
		try {
			sql = sqls.get("updateprojectnoimg");
			params = new Object[] { projectname, description, category, id };
			update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, null, null);
		}
	}

	public void saveOne(Object obj) {
		Project project = null;
		String sql = null;
		Object[] params = null;
		// 转型
		if (obj instanceof Project) {
			project = (Project) obj;
		}
		try {
			sql = sqls.get("updateproject");
			params = new Object[] { project.getHead(), project.getImageurl(),
					project.getText(), project.getCategory(), project.getId() };
			update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, null, null);
		}
	}

	public void delOne(String id) {
		String sql = null;
		Object[] params = null;
		try {
			sql = sqls.get("deleteoneproject");
			params = new Object[] { id };
			update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(null, null, null);
		}
	}

}
