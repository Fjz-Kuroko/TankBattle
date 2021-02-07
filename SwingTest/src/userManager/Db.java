package userManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Db {
	
	//定义连接池对象
	private static DataSource ds;
	static{
		Properties pro = new Properties();
		try {
			pro.load(Db.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			//获得一个连接池对象
			ds=BasicDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("初始化连接错误，请检查配置文件！");
			e.printStackTrace();
		}
	}
	/**
	 * 从连接池中获取一个连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = ds.getConnection();
		if(conn!=null){
			System.out.println("从连接池中获取连接成功");
		}
		return conn;
	}
	/**
	 * 关闭连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
				System.out.println("关闭连接成功");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
