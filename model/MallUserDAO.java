package mall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mall.util.DBUtil;

public class MallUserDAO {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet res = null;
	
	public static int inputNewUser(MallUserDTO dto) {
		System.out.println(dto.toString());
		int count = 0; // CountUpdateQueryResult
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into malluser(no, userid, userpw, ph, address)"
						+ " values(malluser_seq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPw());
			pstmt.setString(3, dto.getPh());
			pstmt.setString(4, dto.getAddress());
			
			count = pstmt.executeUpdate();
			
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
	public static MallUserDTO selectByUserId(String userId) {
		MallUserDTO dto = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from malluser where userid = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			res = pstmt.executeQuery();
			
			while(res.next()) {
				dto = new MallUserDTO.Builder(userId)
						.ph(res.getString("ph"))
						.address(res.getString("address"))
						.isManager(res.getString("is_manager"))
						.suspensionDate(res.getTimestamp("suspension_date"))
						.build();
				System.out.println(dto.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(res != null) res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public static MallUserDTO selectforSignin(String userId, String userPw) {
		MallUserDTO dto = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from malluser "
						+ "where userid = ? and userpw = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			
			res = pstmt.executeQuery();
			
			while(res.next()) {
				System.out.println("Enter while");
				dto = new MallUserDTO.Builder(userId)
						.no(res.getInt("no"))
						.userPw(res.getString("userpw"))
						.ph(res.getString("ph"))
						.address(res.getString("address"))
						.isManager(res.getString("is_manager"))
						.suspensionDate(res.getTimestamp("suspension_date"))
						.build();
				System.out.println(dto.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(res != null) res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}
