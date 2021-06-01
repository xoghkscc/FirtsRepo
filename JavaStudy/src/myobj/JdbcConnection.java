package myobj;

import java.sql.Connection;

public class JdbcConnection {
	private Connection conn;
	private boolean using;
	
	public JdbcConnection() {
		MySeverConnection mc = new MySeverConnection();
		conn = mc.connection();
	}

	
	public boolean using() {
		return using;//초기값은 false이므로 안사용중임
	}
	
	public Connection use() {
		using = true;
		return conn;
	}
	
	public void close() {
		using = false;
	}

}
