package jdc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class A06_FileBaseHikariCP {
	public static void main(String[] args) {
		HikariConfig config = new HikariConfig("./JavaStudy/files/hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
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
