package jdc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import myobj.MyScanner;
import myobj.MySeverConnection;

public class A05_SearchKeyword {
	//first_name에 사용자가 입련한 내용이 포함되어있는 모든 사원 조회
	//(단 검색어는 두 글자 이상 아니라면 예외 발생
	
	public static void main(String[] args) {
		MySeverConnection mc = new MySeverConnection();
		String sql = "SELECT * FROM employees WHERE first_name LIKE ?";
		try(
				Connection conn = mc.connection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			
			String searchName = MyScanner.input("검색할 단어 입력(두 글자 이상) >>");
			try {
				A05_SearchKeyword sk = new A05_SearchKeyword();
				sk.searchTest(searchName);
			} catch (NotTwoExcption e) {
				e.printStackTrace();
			}
			
			pstmt.setString(1, "%"+searchName+"%");
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("employee_id : %d, First_name : %s\n", rs.getInt(1), rs.getString(2));

			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void searchTest(String searchName) throws NotTwoExcption {
		if (searchName.length() >= 2) {
			System.out.println("입력한 글자는 2글자 이상입니다");
		} else {
			System.out.println("입력한 글자는 2글자 이상이 아닙니다");
			throw new NotTwoExcption();
		}
	}
}

class NotTwoExcption extends Exception{
	public NotTwoExcption() {
		super("입력한 글자는 2글자 이상이 아닙니다");
		System.exit(0);
		}
}

