package jdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import myobj.MySeverConnection;

public class A03_JdbcTransaction {
	public static void main(String[] args) {
		MySeverConnection msc = new MySeverConnection();
		String sql = "UPDATE fruits SET fcolor='GREEN' WHERE fname = 'iwi'";
		Connection conn = msc.connection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = msc.preparedStatement(sql);
			
			int rows = pstmt.executeUpdate();
			
			System.out.println(rows + "행이 업데이트 되었습니다");
			conn.commit();
			conn.rollback();
			System.out.println("취소되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
