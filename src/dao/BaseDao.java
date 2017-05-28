package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	public static final String URL = "jdbc:mysql://localhost:3306/apehire?"
			+ "useUnicode=true&characterEncoding=UTF-8";
	//  
	public static final String CLASSNAME = "com.mysql.jdbc.Driver";
	// û   
	public static final String UNAME = "root";
	//    
	public static final String UPWD = "root";
	
	//  ȡ    
	public Connection getConnections(){
		    Connection conn = null;
		
		
		try {
			//      
			Class.forName(CLASSNAME);
			//  ȡ    
			conn = DriverManager.getConnection(URL, UNAME, UPWD);
			//     Ϣ
			System.out.println("连接成功");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		BaseDao baseDao = new BaseDao();
		baseDao.getConnections();
	}
}
