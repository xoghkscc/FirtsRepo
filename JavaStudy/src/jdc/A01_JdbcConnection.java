package jdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A01_JdbcConnection {
	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("OracleDriver가 존재함");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@3.35.52.40:1521:XE", "hr", "1234");
		System.out.println("연결 생성됨");
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
		System.out.println("테이블 불러오기");
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("first_name") + "/" + rs.getString("salary"));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
		
	}
	
	
}
