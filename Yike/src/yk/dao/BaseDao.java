package yk.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import yk.utils.DBUtils;

/**
 * 该类是所有的dao的实现类的基类
 * 
 * 1. 加载sqls文件数据提供需要指定的sql语句 2. 提供执行sql语句的对象QueryRunner 3. 提供执行SQL的方法
 */
public class BaseDao {
	private static QueryLoader loader = null;
	public static Map<String,String> sqls = null;
	private QueryRunner run = null;
	//初始化
	static{
		loader = QueryLoader.instance();
		try {
			sqls = loader.load("/sqls.properties/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//提供执行查询方法
	public Object query(String sql, ResultSetHandler handler, Object[] param){
		run = new QueryRunner(DBUtils.getDataSource());
		Object result = null;
		 try {
			result = run.query(sql, handler, param);
			System.out.println("查询成功！");
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
	//提供一个执行更新的方法
	public void update(String sql, Object[] param){
		run = new QueryRunner(DBUtils.getDataSource());
		try {
			run.update(sql,param);
			System.out.println("更新成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
