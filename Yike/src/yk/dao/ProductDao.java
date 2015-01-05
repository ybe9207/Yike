package yk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import yk.bean.Product;
import yk.utils.DBUtils;

/**
 * 产品的增删改查
 * 
 * */
public class ProductDao extends BaseDao{
	//增加产品
	public void addOne(Object obj){
		Product product = null;
		String sql = null;
		Object[] params = null;
		//转型
		if(obj instanceof Product){
			product = (Product) obj;
		}
		try{
		sql = sqls.get("insertprodcut");
		params = new Object[]{product.getId(),product.getName(),product.getMessage(),product.getImgurl()};
		update(sql,params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}
	//统计产品总数
	public int getCount() {
		String sql = null;
		int count = 0;
		Long longCount = null;
		Object obj = null;
		ResultSetHandler handler = null;
		try{
			sql = sqls.get("getproductcount");
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
	//获取单页数据
	public Object getPageData(int index, int size) {
		List<Product> list = null;
		String sql = null;
        Object [] params = null;
        ResultSetHandler handler = null;
		try{
			sql = sqls.get("selectpageproduct");
			//设置参数
			params = new Object[]{index,size};
			list =(List<Product>)query(sql,new CustomProductHandler(),params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return list;
	}
	class CustomProductHandler implements ResultSetHandler{
		// 该方法将您要处理的结果集传递进来，那么开发者只是需要封装即可
				public Object handle(ResultSet set) throws SQLException {
					Product product = null;
					List<Product> list = new LinkedList<Product>();
					// 遍历结果集
					while (set.next()) {
						// 获取列数据
						String id = set.getString(1);
						String name = set.getString(2);
						String message = set.getString(3);
						String imageurl = set.getString(4);
						product = new Product(id, name, message, imageurl);

						// 加入集合
						list.add(product);
					}
					return list;
				}
	}
	public Object getOne(String id) {
		List<Product> list = null;
		String sql = null;
		Object[] params = null;
		System.out.println(id);
		try{
		sql = sqls.get("selectoneprodcut");
		params = new Object[]{id};
		list = (List<Product>) query(sql,new CustomProductHandler(),params);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
		return list.size() > 0?list.get(0):null;
	}
	//更新产品 
	public void saveOne(Object obj) {
		String sql = null;
		Product product = null;
		Object[] params = null;
		if(obj instanceof Product){
			product = (Product) obj;
		}
		try{
			if(StringUtils.isNotBlank(product.getId())){
				sql = sqls.get("updateoneproduct");
				params = new Object[]{product.getName(),product.getMessage(),product.getImgurl(),product.getId()};
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
		Object[] params = null;
		try{
			sql = sqls.get("deleteoneproduct");
			params = new Object[]{id};
			update(sql,params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}
	public void saveNoimg(String productname, String description, String id) {
		String sql = null;
		Object[] params = null;
		try{			
				sql = sqls.get("updateoneproductnoimg");
				params = new Object[]{productname,description,id};
				update(sql,params);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, null, null);
		}
	}
}
