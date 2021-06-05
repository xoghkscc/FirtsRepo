package jdc.quiz;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import myobj.HikariCP;

public class A06_FileBaseHikariCP {
	public static void main(String[] args) {
		HikariCP cp = new HikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		String sql = "SELECT * FROM employees";
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		){
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	
	
	
	
}
