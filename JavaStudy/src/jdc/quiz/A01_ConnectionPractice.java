package jdc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myobj.MyScanner;

public class A01_ConnectionPractice {
	//사용자로부터 부서번호를 입력받으면 해당 부서 사원들의 모든 정보를 조회하여 콘솔에 보기 좋케 출력
	
	public static void main(String[] args) {
		int department_id =  MyScanner.inputInt("부서번호 입력 : ");
		String queryStatement = String.format("SELECT first_name, salary, department_name  FROM employees INNER JOIN departments USING (department_id) WHERE department_id = %d", department_id);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@3.35.52.40:1521:xe", "hr", "1234");
			PreparedStatement pstmt = conn.prepareStatement(queryStatement);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("이름 : " +rs.getString("first_name") + "/월급 :" + rs.getString("salary") + "/부서 이름 : " + rs.getString("department_name"));
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
