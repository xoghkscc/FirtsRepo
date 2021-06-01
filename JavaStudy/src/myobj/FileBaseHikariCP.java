package myobj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class FileBaseHikariCP {
	HikariDataSource ds;
	public FileBaseHikariCP() {
		// TODO Auto-generated constructor stub
		HikariConfig config = new HikariConfig("./JavaStudy/files/hikari.properties");
		ds = new HikariDataSource(config);
	}
	
	public HikariDataSource getHikariDataSource() {
		return ds;
	}
}
	

	
	
	
	
	
	
	
	
	
