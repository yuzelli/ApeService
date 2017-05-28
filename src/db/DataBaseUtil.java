package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import oracle.jdbc.driver.OracleDriver;

public class DataBaseUtil {
	public static Connection conn;
	public static PreparedStatement pstmt;
	public static ResultSet rs;

	//锟斤拷锟矫撅拷态锟斤拷锟斤拷
	static{
		try {
			//1.锟斤拷锟斤拷锟斤拷锟�
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//锟斤拷态锟斤拷锟斤拷锟接伙拷取锟斤拷锟斤拷
	public static Connection getConnection() throws Exception {
		
		if(conn==null||conn.isClosed()){
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apehire?"
					+ "useUnicode=true&characterEncoding=UTF-8","root","root");
		}
		return conn;
	}
	//锟斤拷态锟斤拷执锟斤拷DQL锟斤拷锟侥凤拷锟斤拷(select)
		public static ResultSet executeQuery(String sqlStr,Object[] objs) throws Exception{
			conn =getConnection();  //锟斤拷锟矫撅拷态锟斤拷锟斤拷锟斤拷取一锟斤拷锟斤拷锟接讹拷锟斤拷
			pstmt = conn.prepareStatement(sqlStr);
			if(objs!=null){
				for(int i =0;i<objs.length;i++){
					pstmt.setObject(i+1, objs[i]);
				}
			}
			rs = pstmt.executeQuery();
			return rs;
		}	
	//锟斤拷态锟斤拷执锟斤拷DML锟斤拷锟侥凤拷锟斤拷(insert update delete)
	public static int executeUpdate(String sqlStr,Object[] objs) throws Exception{
		int num = 0;
		conn=getConnection();
		pstmt=conn.prepareStatement(sqlStr);
		if(objs!=null){
			for(int i=0; i<objs.length;i++){
				pstmt.setObject(i+1, objs[i]);
			}
		}
		num = pstmt.executeUpdate();
		return num;
	}
	//锟斤拷态锟侥关闭凤拷锟斤拷
	public static void closeConn() throws Exception{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(conn!=null)
			conn.close();
	}


}
