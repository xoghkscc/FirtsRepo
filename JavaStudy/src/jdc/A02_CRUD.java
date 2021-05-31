package jdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myobj.MySeverConnection;

public class A02_CRUD {
	public static void main(String[] args) throws SQLException {

		MySeverConnection sc = new MySeverConnection();
		sc.oracleConn();
		String sql = "INSERT INTO fruits VALUES (fruits_seq.nextval, 'iwi', 'range')";
		String sql2 = "SELECT * FROM fruits ORDER BY fid";

		Connection conn = sc.connection();
		PreparedStatement psmt = sc.preparedStatement(sql);
		PreparedStatement psmt2 = sc.preparedStatement(sql2);

		int rows=0;
		for (int i = 0; i < 10; i++) {
			psmt.executeUpdate();
			rows ++;
		}
		System.out.println(rows + " : row update");
		
		ResultSet rs = sc.resultSetQuery();

		while (rs.next()) {
			System.out.printf("%d\t%s\t%s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
		}
	}

}
