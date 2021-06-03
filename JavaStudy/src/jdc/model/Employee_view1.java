package jdc.model;

public class Employee_view1 extends Employee {
	public Employee_view1(String first_name, int department_id, String department_name,
			String city) {
		
		setDepartment(new Department());
		getDepartment().setLocation(new Location());
		
		setFirst_name(first_name);
		setDepartment_id(department_id);
		getDepartment().setDepartment_name(department_name);
		getDepartment().getLocation().setCity(city);
		
	}
	
	@Override
	public String toString() {
		
		return String.format("이름 : %s, 부서번호 : %d 부서명 : %s, 도시 : %s\n",
				super.getFirst_name(), super.getDepartment_id(),
				super.getDepartment().getDepartment_name(),
				super.getDepartment().getLocation().getCity()) ;
	}
}
