package myobj.school;

import java.util.Random;

public class Student {
	String[] firstName = {"±Ë", "¿Ã"};
	String[] lastName = {"≈¬»Ø", "πª∫¡"};
	
	int kor, eng;
	String name;
	
	public Student() {
		this.kor = randomScore();
		this.eng = randomScore();
		name=firstName[(int) (Math.random()*2)]+lastName[(int) (Math.random()*2)];
	}
	
	public int randomScore() {
		Random ran = new Random();
		return ran.nextInt(101);
	}
}
