package quiz;

import java.util.ArrayList;

import myobj.school.Student2;

public class D01_1_StudentListTeacher {
	public static void main(String[] args) {
		ArrayList<Student2> students = new ArrayList<>();
		
		for (int i = 0; i < 30; i++) {
			students.add(new Student2());
			System.out.println(students.get(i).getTranscript());//clazz.get(0) = new Student2가 되기 때문
		}
		
		
		System.out.println("----최고 점수 학생------");
		for(Student2 student : students) {
			if(student.getTotal() == Student2.best_total) {
				System.out.println(student.getTranscript());
			}
			
		}
		
	}
}
