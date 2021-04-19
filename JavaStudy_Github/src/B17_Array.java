
public class B17_Array {
	public static void main(String[] args) {
		int[] score = new int[100];
		
		for (int i = 0; i < score.length; i++) {
			score[i] = (int)(Math.random()*101);
		}
		System.out.println("10번째 학생의 점수 : " +score[9]);
		
		//연습문제: score의 총합과 평균을 출력
		float sum=0, avg=0;
		
		for (int i = 0; i < score.length; i++) {
			sum += score[i]; 
		}
		avg = sum/score.length;
		
		System.out.println((int)sum);
		System.out.println(avg);
		
		int[] age = {10, 15, 20, 31, 80, 75};
		boolean[] passExam = {true, false, true, true, false};
		String[] animals = new String[] {"lion", "tiger"};		
		char[] grade = new char[50];
		
		System.out.println((int)grade[3]);
		
		char[] msg1 = new char[] {'h', 'e', 'l', 'l', 'o'};
		String msg2 = "hello";
		char[] msg3 = msg2.toCharArray();
		
		
	}
}
