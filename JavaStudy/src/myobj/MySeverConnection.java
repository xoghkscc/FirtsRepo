package myobj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class MySeverConnection {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	static String driverName;
	static String url;
	static String id;
	static String pw;
	
	public MySeverConnection() {
		StringBuffer sb = new StringBuffer();
		
		try {
			FileInputStream in = new FileInputStream(new File("./JavaStudy/serverInfo/server.txt"));
			InputStreamReader ist = new InputStreamReader(in);
			int len = 0;
			while((len = ist.read()) != -1) {
				sb.append((char) len);
			}
			ist.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Pattern regex = Pattern.compile("\n");
		String[] fruits = regex.split(sb);
		driverName = fruits[0];
		url = fruits[1];
		id = fruits[2];
		pw = fruits[3];
	}
	
	public void oracleConn() {//안써도 되는 메서드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName에 문제가 생김");
			e.printStackTrace();
		}
	}
	
	public Connection connection() {
		try {
			this.conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("Connection에 문제가 생김");
			e.printStackTrace();
		}
		
		return this.conn;
	}
	
	public PreparedStatement preparedStatement(String queryStatement) {
		try {
			this.pstmt = conn.prepareStatement(queryStatement);
		} catch (SQLException e) {
			System.out.println("PreparedStatement에 문제가 생김");
			e.printStackTrace();
		}
		return this.pstmt;
	}
	
	public ResultSet resultSetQuery() {
		try {
			this.rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("ResultSet에 문제가 생김");
			e.printStackTrace();
		}
		return this.rs;
	}

}
