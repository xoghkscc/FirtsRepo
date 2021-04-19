package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import myobj.MyScanner;

public class D01_1_StudentList {
	// �л� Ŭ������ ��ҷ� ���� ArraList�� �����ϰ� �л��� 30�� �߰��غ�����.
	// 1. �� �л��� ������ �������� �����˴ϴ�.
	// 2. ������ ��, ��, �� �ۿ� �����ϴ�.
	// 3. 30���� ����� ������ּ���.
	// 4. 30�� �� ���� ������ ���� �л��� �̸��� ������ ������ּ���.
	// 5. �̸��� ������ ���� �����˴ϴ�
	// �л�000000, �л�000001, �л�000002...

	ArrayList<int[]> grade;
	ArrayList<Float> average;
	ArrayList<String> name;
	int[] gradeDetail;
	int maxIndex;
	D01_1_StudentGrade sg;
	HashMap<String, Float> map;
	static String[] subject= {"����", "����", "����"};
	
	public static void main(String[] args) {
		D01_1_StudentList list = new D01_1_StudentList();
		HashMap<String, Float> seoul = new HashMap(), pusan = new HashMap();
		seoul = list.school("�����ʵ�");//�����ʵ��б��� ��ǥ �л��� �������� ��ȯ
		pusan = list.school("�λ��ʵ�");
		
		for (int i = 0; i < subject.length; i++) {
			System.out.println("�����ʵ��б� ��ǥ�� "+(subject)[i]+"���� : "+seoul.get((subject)[i]));
			System.out.println("�λ��ʵ��б� ��ǥ�� "+(subject)[i]+"���� : "+pusan.get((subject)[i]));
			if(seoul.get((subject)[i]) > pusan.get((subject)[i])) {
				System.out.println("�����ʵ��б� ��ǥ�� �λ��ʵ��б� ��ǥ���� "+(subject)[i]+"������ �� �����ϴ�.");
			}else {
				System.out.println("�λ��ʵ��б� ��ǥ�� �����ʵ��б� ��ǥ���� "+(subject)[i]+"������ �� �����ϴ�.");
			}
			System.out.println("-------------------------------------------------");
		}
	}
	
	public HashMap school(String schoolName) {
		
		sg = new D01_1_StudentGrade(MyScanner.inputInt(schoolName+"�б��� �л� ���� �Է��ϼ��� : "));
		name = sg.name();//�л� �̸����� name�� ���
		grade = sg.gradeDetail();// ��, ��, �� ������ grade�� ���
		average = sg.gradeAverage();// �� �л��� ��������� average�� ���
		maxIndex = sg.maxIndex();// ������ ���� ���� �л��� index�� ��ȯ
		
		System.out.println(average);// ����� ���
		System.out.printf("%s �б��� ���� ������ ���� �л� : %s, ���� : %.0f, ��� : %.2f, ���� : %d, ���� : %d, ���� : %d\n", 
				schoolName, name.get(maxIndex),average.get(maxIndex) * 3, average.get(maxIndex), grade.get(maxIndex)[0], grade.get(maxIndex)[1],grade.get(maxIndex)[2]);
		System.out.println("-----------------------------------------------------------------------------------");
		map = new HashMap<String, Float>();
		map.put("����", (float)grade.get(maxIndex)[0]);
		map.put("����", (float)grade.get(maxIndex)[1]);
		map.put("����", (float)grade.get(maxIndex)[2]);
		map.put("���", average.get(maxIndex));
		return map;
	}

}
