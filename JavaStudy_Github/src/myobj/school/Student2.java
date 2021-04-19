package myobj.school;

import java.util.Random;

public class Student2 {
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	private static Random ran = new Random();
	private static int sno = 0;
	public static int best_total = 0; 
	
	private static int getRandomScore() {
		return ran.nextInt(101);
	}
	
	public Student2() {
		ran = new Random();
		kor = getRandomScore();
		eng = getRandomScore();
		math = getRandomScore();
		name  = String.format("«–ª˝%06d", sno++);
		best_total = getTotal() > best_total ? getTotal() : best_total; 
	}
	
	public String getTranscript() {
		return String.format("¿Ã∏ß : %s\t / √—¡°: %d\t / ∆Ú±’ : %.2f", name, getTotal(), getAvg());
	}

	private double getAvg() {
		// TODO Auto-generated method stub
		return getTotal() / 3.0;
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		return kor + eng + math;
	}
}
