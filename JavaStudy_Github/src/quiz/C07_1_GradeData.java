package quiz;

import java.util.ArrayList;
import java.util.HashMap;

public class C07_1_GradeData {
	ArrayList grade;
	int sum, avg, studentNum;
	String subject, name;
	HashMap map;
	public C07_1_GradeData(String subject, ArrayList grade, String name, int studentNum) {
		this.grade = grade;
		this.subject = subject;
		this.name = name;
		this.studentNum = studentNum;
	}
	
	public int sumGrade() {
		sum = 0;
		for (int i = 0; i < grade.size(); i++) {
			sum +=(int)grade.get(i);
		}
		this.sum = sum;
		return sum;
	}
	
	public int avgGrade() {
		this.avg = sum / grade.size();
		
		return avg;
	}
	
	public void showInfo() {
		System.out.printf("%s반 '%s' 학생의 학번 : %d, 총점 : %d, 평균 : %d점\n", subject, name, studentNum,sumGrade(), avgGrade());
	}
	public void showGrade() {
		System.out.println(map);
		System.out.println();
	}
}
