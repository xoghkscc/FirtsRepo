package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import myobj.MyScanner;

public class D01_1_StudentList {
	// 학생 클래스를 요소로 갖는 ArraList를 생성하고 학생을 30명 추가해보세요.
	// 1. 각 학생의 점수는 랜덤으로 설정됩니다.
	// 2. 과목은 국, 영, 수 밖에 없습니다.
	// 3. 30명의 평균을 출력해주세요.
	// 4. 30명 중 가장 총점이 높은 학생의 이름과 성적을 출력해주세요.
	// 5. 이름은 다음과 같이 생성됩니다
	// 학생000000, 학생000001, 학생000002...

	ArrayList<int[]> grade;
	ArrayList<Float> average;
	ArrayList<String> name;
	int[] gradeDetail;
	int maxIndex;
	D01_1_StudentGrade sg;
	HashMap<String, Float> map;
	static String[] subject= {"국어", "영어", "수학"};
	
	public static void main(String[] args) {
		D01_1_StudentList list = new D01_1_StudentList();
		HashMap<String, Float> seoul = new HashMap(), pusan = new HashMap();
		seoul = list.school("서울초등");//서울초등학교의 대표 학생의 성적들을 반환
		pusan = list.school("부산초등");
		
		for (int i = 0; i < subject.length; i++) {
			System.out.println("서울초등학교 대표의 "+(subject)[i]+"점수 : "+seoul.get((subject)[i]));
			System.out.println("부산초등학교 대표의 "+(subject)[i]+"점수 : "+pusan.get((subject)[i]));
			if(seoul.get((subject)[i]) > pusan.get((subject)[i])) {
				System.out.println("서울초등학교 대표가 부산초등학교 대표보다 "+(subject)[i]+"점수가 더 높습니다.");
			}else {
				System.out.println("부산초등학교 대표가 서울초등학교 대표보다 "+(subject)[i]+"점수가 더 높습니다.");
			}
			System.out.println("-------------------------------------------------");
		}
	}
	
	public HashMap school(String schoolName) {
		
		sg = new D01_1_StudentGrade(MyScanner.inputInt(schoolName+"학교의 학생 수를 입력하세요 : "));
		name = sg.name();//학생 이름들을 name에 담기
		grade = sg.gradeDetail();// 국, 영, 수 성적을 grade에 담기
		average = sg.gradeAverage();// 각 학생의 평균점수를 average에 담기
		maxIndex = sg.maxIndex();// 점수가 가장 높은 학생의 index를 반환
		
		System.out.println(average);// 평균을 출력
		System.out.printf("%s 학교의 가장 총점이 높은 학생 : %s, 총점 : %.0f, 평균 : %.2f, 국어 : %d, 영어 : %d, 수학 : %d\n", 
				schoolName, name.get(maxIndex),average.get(maxIndex) * 3, average.get(maxIndex), grade.get(maxIndex)[0], grade.get(maxIndex)[1],grade.get(maxIndex)[2]);
		System.out.println("-----------------------------------------------------------------------------------");
		map = new HashMap<String, Float>();
		map.put("국어", (float)grade.get(maxIndex)[0]);
		map.put("영어", (float)grade.get(maxIndex)[1]);
		map.put("수학", (float)grade.get(maxIndex)[2]);
		map.put("평균", average.get(maxIndex));
		return map;
	}

}
