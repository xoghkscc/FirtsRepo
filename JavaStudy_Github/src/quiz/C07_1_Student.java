package quiz;

import java.util.ArrayList;
import java.util.Random;

public class C07_1_Student {
	Random ran = new Random();
	String name;
	ArrayList grade = null;
	int num=4;
	int studentNum=0;
	boolean tf = true;
	char[] firstName = { '김', '이', '박', '최', '고' };
	String[] lastName = { "태환", "혁준", "동욱", "민우", "성진", "부자", "도둑" };
	
	public C07_1_Student(int choose) {
		if(choose==3) {
			num=5;
		}
		for (int j = 0; j < 30 && tf; j++) {
			grade = new ArrayList();
			for (int i = 0; i < num; i++) {
				grade.add(ran.nextInt(100));
			}
			Random ran2 = new Random(j);
			this.name = firstName[ran.nextInt(5)] + lastName[ran.nextInt(7)];
			this.studentNum = ran2.nextInt(99) + 1;
//			nmGrade[j] = new C07_1_Network_or_MachineLearning_or_ProgrammingClass(subject, grade, name, studentNum);
			
		
		}
	}


	public String getName() {
		return name;
	}

	public ArrayList getGrade() {
		return grade;
	}

	public int getStudentNum() {
		return studentNum;
	}
	
	
}
