package myobj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import myobj.MySeverConnection;

public class HikariCP {
	HikariDataSource ds;
	public HikariCP() {
		MySeverConnection mc = new MySeverConnection();
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(mc.getUrl());
		config.setUsername(mc.getId());
		config.setPassword(mc.getPw());
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}
	
	public HikariDataSource getHikariDataSource() {
		return ds;
	}

		

		


}
