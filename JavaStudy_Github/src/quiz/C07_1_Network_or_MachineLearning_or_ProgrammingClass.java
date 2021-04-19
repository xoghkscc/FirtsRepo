package quiz;

import java.util.ArrayList;
import java.util.HashMap;

public class C07_1_Network_or_MachineLearning_or_ProgrammingClass extends C07_1_GradeData {
	ArrayList grade;
	String name, subject;
	int studentNum;
	public C07_1_Network_or_MachineLearning_or_ProgrammingClass(String subject, ArrayList grade2, String name, int studentNum) {
		super(subject, grade2, name, studentNum);
		this.grade = grade2;
		HashMap map = new HashMap();
		if(subject.equals("프로그래밍")) {
			map.put("국어", grade.get(0));
			map.put("영어", grade.get(1));
			map.put("수학", grade.get(2));
			map.put("프로그래밍 언어", grade.get(3));
		}else if(subject.equals("네트워크")){
			map.put("국어", grade.get(0));
			map.put("영어", grade.get(1));
			map.put("리눅스", grade.get(2));
			map.put("CCNA", grade.get(3));
		}else if(subject.equals("머신러닝")) {
			map.put("국어", grade.get(0));
			map.put("영어", grade.get(1));
			map.put("수학", grade.get(2));
			map.put("통계학", grade.get(3));
			map.put("프로그래밍 언어", grade.get(4));
		}
		super.map = map;
		
	}
	

	
	
	
}
