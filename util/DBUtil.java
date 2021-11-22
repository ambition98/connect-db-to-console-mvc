package mall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@DESKTOP-FOXCOM:1521:xe";
		String dbUser = "javauser";
		String dbPass = "javauser123";
		
		return getConnection(url, dbUser, dbPass);
	}
	
	public static Connection getConnection(String dbUser, String dbPass) throws SQLException {
		String url = "jdbc:oracle:thin:@DESKTOP-FOXCOM:1521:xe";
		
		return getConnection(url, dbUser, dbPass);
	}
	
	public static Connection getConnection(String url, String dbUser, String dbPass) throws SQLException {
		Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
		
		return conn;
	}
	
	public static void dbClose(PreparedStatement stmt, ResultSet rs, Connection conn) throws SQLException{
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
		if(conn != null) conn.close();
	}
	
	public static void dbClose(PreparedStatement stmt, Connection conn) throws SQLException{
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
}
