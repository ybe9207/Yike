package yk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import yk.bean.News;
import yk.bean.Product;
import yk.dao.ProductDao.CustomProductHandler;
import yk.utils.DBUtils;

public class NewsDao extends BaseDao {

	public void add(News news) {
		String sql = null;
		Object[] params = null;
		try{
		 sql = sqls.get("insertnews");
		 params = new Object[]{news.getId(),news.getHead(),news.getNewsfrom(),news.getTime(),
				 news.getGuideread(),news.getContent(),news.getCategory(),news.getDatetime()};
		 update(sql,params);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}
	//统计新闻总数
	public int getCount() {
		String sql = null;
		int count = 0;
		Long longCount = null;
		Object obj = null;
		ResultSetHandler handler = null;
		try{
			sql = sqls.get("getnewscount");
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
	//获单页新闻数据
	public Object getPageData(int index, int size) {
		List<News> list = null;
		String sql = null;
		Object [] params = null;
		ResultSetHandler handler = null;
		try{
			sql = sqls.get("selectpagenews");
			//设置参数
			params = new Object[]{index,size};
			list =(List<News>)query(sql,new CustomNewsHandler(),params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return list;
	}
	class CustomNewsHandler implements ResultSetHandler{
		// 该方法将您要处理的结果集传递进来，那么开发者只是需要封装即可
				public Object handle(ResultSet set) throws SQLException {
					News news = null;
					List<News> list = new LinkedList<News>();
					// 遍历结果集
					while (set.next()) {
						// 获取列数据
						String id = set.getString(1);
						String head = set.getString(2);
						String newsfrom = set.getString(3);
						String time = set.getString(4);
						String guideread = set.getString(5);
						String content = set.getString(6);
						String category = set.getString(7);
						news = new News(id, head, newsfrom, time,guideread,content,category);

						// 加入集合
						list.add(news);
					}
					return list;
				}
	}
	public Object getOne(String id) {
		List<News> list = null;
		String sql = null;
		Object[] params = null;
		try{
			sql = sqls.get("selectonenews");
			params = new Object[]{id};
			list = (List<News>) query(sql,new CustomNewsHandler(),params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return list.size() > 0?list.get(0):null;
	}
	public void saveOneNews(Object obj) {
		String sql = null;
		News news = null;
		Object[] params = null;
		if(obj instanceof News){
			news = (News) obj;
		}
		try{
			if(StringUtils.isNotBlank(news.getId())){
				sql = sqls.get("updateonenews");
				params = new Object[]{news.getHead(),news.getNewsfrom(),news.getTime(),news.getGuideread(),news.getContent(),news.getCategory(),news.getId()};
				update(sql,params);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}
	public void delOne(String id) {
		String sql = null;
		Object [] params = null;
		try{
			sql = sqls.get("deleteonenews");
			params = new Object[]{id};
			update(sql,params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}
}
