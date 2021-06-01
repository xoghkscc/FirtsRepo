package jdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import myobj.FileBaseHikariCP;
import myobj.MyScanner;
import myobj.MySeverConnection;

public class A01_03Practice {

	PreparedStatement psmt;
	PreparedStatement psmt2;
	Connection conn;
	FileBaseHikariCP cp;
	HikariDataSource ds;
	public static void main(String[] args) {
		A01_03Practice ap = new A01_03Practice();
		ap.start();
	}
	
	public void start() {
		cp = new FileBaseHikariCP();
		ds = cp.getHikariDataSource();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			switch (MyScanner.inputInt("1. 계산, 2. 개별 조회, 3. 매출 조회 4. 그만>>")) {
			case 1:
				calculation();
				break;
			case 2:
				showcnt();
				break;
			case 3:
				showsales();
				break;
	
			default:
				System.out.println("끝");
				System.exit(0);
				break;
			}
		}
	}
	
	public void showsales() {
		String sql = "SELECT sales_number, sum(price*object_count) FROM test0531 INNER JOIN test0531conn USING (object_id) GROUP BY sales_number ORDER BY sales_number";
		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("판매 번호 : %d, 매출 : %d\n",rs.getInt(1), rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void showcnt() {
		FileBaseHikariCP cp = new FileBaseHikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		
		int object_id = MyScanner.inputInt("판매번호(SALES_NEMBER)>>");
		try {
			psmt = conn.prepareStatement("SELECT * FROM test0531 INNER JOIN test0531conn USING (object_id) WHERE sales_number = ?");
			psmt2 = conn.prepareStatement("SELECT sum(price*object_count) FROM test0531 INNER JOIN test0531conn USING (object_id) WHERE sales_number = ?");
			psmt.setInt(1, object_id);
			psmt2.setInt(1, object_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int sumPrice = 0;
		try {
			ResultSet rs = psmt.executeQuery();
			ResultSet rs2 = psmt2.executeQuery();
			while(rs.next()) {
				System.out.printf("판매 번호 : %d, 물건 이름 : %s, 개수 : %d, 가격 : %d[%d]\n",rs.getInt(2), rs.getString(4), rs.getInt(3), rs.getInt(5), rs.getInt(3)*rs.getInt(5));
			}
			while(rs2.next()) {
				System.out.printf("합계 : %d\n" , rs2.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int max_sales_number() {
		int sales_number=0;
		try {
			psmt2 = conn.prepareStatement("SELECT max(sales_number) FROM test0531");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs2;
		try {
			rs2 = psmt2.executeQuery();
			while(rs2.next()) {
				sales_number = rs2.getInt(1);
				break;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sales_number+1;
		
	}
	
	public void calculation() {
		int sales_number= max_sales_number();
		int shoppingNum=0;
		while(true) {
			switch (MyScanner.inputInt("1. 새우깡, 2. 파, 3. 고구마, 4. 두부, 5. 삼겹살, 6. 우유, 7. 쌀, 8. 그만>>")) {
			case 1:
				shoppingNum = 1;
				break;
			case 2:
				shoppingNum = 2;
				break;
			case 3:
				shoppingNum = 3;
				
				break;
			case 4:
				shoppingNum = 4;
				break;
			case 5:
				shoppingNum = 5;
				
				break;
			case 6:
				shoppingNum = 6;
				break;
			case 7:
				shoppingNum = 7;
				break;
	
			default:
				System.out.println("끝");
				System.exit(0);
				break;
			}
			shooping(shoppingNum, sales_number);
		}
	}
	public void shooping(int shoppingNum, int sales_number) {
		try {
			psmt = conn.prepareStatement("SELECT * FROM test0531conn");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int cnt = MyScanner.inputInt("몇 개 사쉴?");
		String query;
		try {
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				if(shoppingNum == rs.getInt(1)) {
					query = String.format("INSERT INTO test0531 VALUES(%d, %d, %d)", sales_number, cnt, shoppingNum);
					psmt.executeUpdate(query);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
