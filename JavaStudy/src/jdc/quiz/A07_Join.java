package jdc.quiz;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariDataSource;

import jdc.model.Department;
import jdc.model.Employee;
import jdc.model.Employee_view1;
import jdc.model.Location;
import myobj.FileBaseHikariCP;
import myobj.MyScanner;

public class A07_Join {
//이름에 en이 들어가는 모든 사원의 이름/고용일/부서번호/부서명/도시를 조회
	public static void main(String[] args) {
		ArrayList<Employee> info = new ArrayList<>();
		FileBaseHikariCP cp = new FileBaseHikariCP();
		HikariDataSource ds = cp.getHikariDataSource();
		String sql =
				"SELECT first_name, hire_date, department_id, department_name, city FROM employees "
				+ "INNER JOIN departments USING (department_id) INNER JOIN locations USING (location_id)"
				+ "WHERE first_name like ?";
		String sql2 =
				"SELECT * FROM v1";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		){
			pstmt.setString(1, "%en%");
			ResultSet rs = pstmt.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			
			while(rs.next()) {
				Employee e = new Employee();
				Department d = new Department();
				Location l = new Location();
				e.setFirst_name(rs.getString(1));
				e.setDepartment_id(rs.getInt(3));
				d.setDepartment_name(rs.getString(4));
				l.setCity(rs.getString(5));
				d.setLocation(l);
				e.setDepartment(d);
				e.setHire_date(rs.getDate(2));
				
				System.out.println("asdas"+rs.getDate(2));
				System.out.println("asdas"+rs.getTime(2));
			}
			
			for(int i = 0; i < info.size(); i++) {
				System.out.printf("이름 : %s, 입사일 : %s 부서번호 : %d 부서명 : %s, 도시 : %s\n",
						info.get(i).getFirst_name(), info.get(i).getHire_date(), info.get(i).getDepartment_id(),
						info.get(i).getDepartment
						().getDepartment_name(), 
						info.get(i).getDepartment().getLocation().getCity());
			}
			ArrayList<Employee_view1> info2 = new ArrayList<>();
			while(rs2.next()){
				Employee_view1 v = new Employee_view1(rs2.getString(1), rs2.getInt(2), 
						rs2.getString(3), rs2.getString(4));
				info2.add(v);
			}
			
//			for(int i = 0; i < info2.size(); i++) {
//				System.out.println(info2.get(i));
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
