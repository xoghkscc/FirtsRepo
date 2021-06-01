package jdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import myobj.JdbcConnection;
import myobj.MySeverConnection;

public class A05_PrepareStatement {
	public static void main(String[] args) {
		MySeverConnection mc = new MySeverConnection();
		String fname = "Kiwi";
		String fcolor = "Purple";
		//보안에 취약함
//		String sql = "INSERT INTO fruits VALUES(fruits_seq.nextval, "+fname+"," + fcolor + ")";
		
		String sql = "INSERT INTO fruits VALUES (fruits_seq.nextval, ?, ?)";
		try{
			Connection conn = mc.connection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//다음과 같이 ?를 채울 수 있음
			pstmt.setString(1,  fname);
			pstmt.setString(2,  fcolor);
			
			//실행
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
