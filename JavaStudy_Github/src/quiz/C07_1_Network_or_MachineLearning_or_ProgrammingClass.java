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
		if(subject.equals("���α׷���")) {
			map.put("����", grade.get(0));
			map.put("����", grade.get(1));
			map.put("����", grade.get(2));
			map.put("���α׷��� ���", grade.get(3));
		}else if(subject.equals("��Ʈ��ũ")){
			map.put("����", grade.get(0));
			map.put("����", grade.get(1));
			map.put("������", grade.get(2));
			map.put("CCNA", grade.get(3));
		}else if(subject.equals("�ӽŷ���")) {
			map.put("����", grade.get(0));
			map.put("����", grade.get(1));
			map.put("����", grade.get(2));
			map.put("�����", grade.get(3));
			map.put("���α׷��� ���", grade.get(4));
		}
		super.map = map;
		
	}
	

	
	
	
}
