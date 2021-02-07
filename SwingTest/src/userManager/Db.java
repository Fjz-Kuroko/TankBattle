package userManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Db {
	
	//�������ӳض���
	private static DataSource ds;
	static{
		Properties pro = new Properties();
		try {
			pro.load(Db.class.getClassLoader().getResourceAsStream("dbcp.properties"));
			//���һ�����ӳض���
			ds=BasicDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��ʼ�����Ӵ������������ļ���");
			e.printStackTrace();
		}
	}
	/**
	 * �����ӳ��л�ȡһ������
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = ds.getConnection();
		if(conn!=null){
			System.out.println("�����ӳ��л�ȡ���ӳɹ�");
		}
		return conn;
	}
	/**
	 * �ر�����
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
				System.out.println("�ر����ӳɹ�");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
