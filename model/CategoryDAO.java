package mall.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet res = null;
	
	public static ArrayList<CategoryDTO> selectAllElement() {
		ArrayList<CategoryDTO> dtoList = new ArrayList<CategoryDTO>();

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from category";
			pstmt = conn.prepareStatement(sql);

			res = pstmt.executeQuery();

			while (res.next()) {
				dtoList.add(new CategoryDTO(
								res.getInt("no"), res.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (res != null) res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}
}
