package jdc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myobj.MyScanner;
import myobj.MySeverConnection;

public class A01_ConnectionPractice2 {
	//사용자로부터 부서번호를 입력받으면 해당 부서 사원들의 모든 정보를 조회하여 콘솔에 보기 좋케 출력
	
	public static void main(String[] args) {
		MySeverConnection sc = new MySeverConnection();
		String queryStatement = String.format("SELECT first_name, salary, department_name "
				+ "FROM employees INNER JOIN departments USING (department_id) "
				+ "WHERE department_id = %d", MyScanner.inputInt("부서번호 입력 : "));
		try (Connection conn = sc.connection();
			PreparedStatement pstmt = sc.preparedStatement(queryStatement);
			ResultSet rs = sc.resultSetQuery();){
//			sc.oracleConn(); 
			
			while(rs.next()) {
				System.out.println("이름 : " +rs.getString(1) + "/월급 :" + rs.getString(2) +
						"/부서 이름 : " + rs.getString(3));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
}
