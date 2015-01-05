package yk.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
	//定义连接池对象
	private static DataSource ds = null;
	//初始化
	static{
		ds = new ComboPooledDataSource();
	}
	//提供返回连接的方法
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//返回数据库连接池对象
	public static DataSource getDataSource(){
		return ds;
	}
	//释放资源
	public static void closeAll(ResultSet set,Statement state,Connection conn){
		DbUtils.closeQuietly(conn, state, set);
	}
}
