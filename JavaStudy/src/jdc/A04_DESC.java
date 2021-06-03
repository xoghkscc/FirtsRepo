package jdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import jdc.model.Employee;
import myobj.MySeverConnection;

public class A04_DESC {
	public static void main(String[] args) {
		MySeverConnection mc = new MySeverConnection();
		String sql = "SELECT * FROM employees";
		try(
				Connection conn = mc.connection();
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs = pstm.executeQuery();
		){
			Employee e = new Employee();
			ResultSetMetaData meta = rs.getMetaData();
			System.out.println("컬럼이 몇 개인가? : "+ meta.getColumnCount());
			for(int i = 1, len = meta.getColumnCount(); i < len; i++) {
				System.out.println("----------------------------------------");
				System.out.println(i + "번째 컬럼의 이름은 ? : "+ meta.getColumnLabel(i));
				System.out.println(i + "번째 컬럼의 타입은 ? : "+ meta.getColumnTypeName(i));
				System.out.println(i + "번째 컬럼의 컬럼의 크키는 ? : "+ meta.getPrecision(i));
				
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
