package quiz;

import java.util.ArrayList;
import java.util.Random;

public class D01_1_StudentGrade {
	Random ran = new Random();
	ArrayList<int[]> grade;
	ArrayList<Float> average;
	ArrayList<String> name;
	int[] gradeDetail;
	int maxIndex;
	Float maxNum;
	int studentNum;
	
	public D01_1_StudentGrade(int studentNum) {
		this.studentNum = studentNum;
	}
	
	public ArrayList name() {
		name = new ArrayList<String>();
		for (int i = 0; i < studentNum; i++) {
			name.add("�л�00000" + i);
		}
		this.name = name;
		return name;
	}
	
	
	
	//�л� ������ ��,��,�� ���� ���ϴ� �޼���
	public ArrayList gradeDetail() {
		grade = new ArrayList<int[]>();
		for (int i = 0; i < studentNum; i++) {
			gradeDetail = new int[3];
			for (int j = 0; j < 3; j++) {
				gradeDetail[j] = ran.nextInt(101);
			}
			grade.add(gradeDetail);
		}
		this.grade = grade;
		return grade;
	}
	//�л� ������ ��, ��, ���� ��� ���� arraylist�� ��ȯ�ϴ� �޼���
	public ArrayList gradeAverage() {
		average = new ArrayList<Float>();
		for (int j = 0; j < studentNum; j++) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += grade.get(j)[i];
			}
			// �Ҽ� ��°�ڸ� ���� ���
			average.add(Math.round((sum / 3.00) * 100) / (float) 100);
		}
		this.average = average;
		return average;
	}
	
	public int maxIndex() {
		maxNum = (float) 0;
		maxIndex = 0;
		for (int i = 0; i < studentNum; i++) {
			if (maxNum <= average.get(i)) {// 10 30 20
				maxNum = average.get(i);
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	
}
