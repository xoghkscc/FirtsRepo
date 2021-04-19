import java.util.Scanner;

import myobj.Overwatch_hero;
import myobj.Peach;

public class C03_Constructor {
	public static void main(String[] args) {
		
//		new Orange();//오렌지가 초기화 되었습니다.-->여기서 끝
//		Orange or = new Orange(9, 10, new int[] {235, 143, 52});//오버라이딩
//		
//		Orange[] orange_box = new Orange[7];//-->Orange타입의 배열 생성
//		
//		for (int i = 0; i < 5; i++) {
//			orange_box[i] = new Orange();//-->열28~33 내용이 배열 안에 들어감
//		}
//		
//		System.out.println(orange_box[0].sweet);//5
//		System.out.println(orange_box[1].size);//랜덤
//		System.out.println(orange_box[2].color[0]);//255
//		System.out.println(orange_box[3].color[1]);//165
//		System.out.println(orange_box[4].color[2]);//0
//		System.out.println(or.color[2]);//52
//		Strawberry berry01 = new Strawberry(150);
//		
//		System.out.println(berry01.color);
//		System.out.println(berry01.seed);
		
		
		Overwatch_hero ow = new Overwatch_hero();
		Overwatch_hero ow2 = new Overwatch_hero(250, 120, "reaper", "dealer");
		System.out.println();
		System.out.println(ow2.getPower());
		System.out.println(ow2.getHealth());
		System.out.println(ow2.getHeroName());
		System.out.println(ow2.getPosition());
		
		
	}
}

class Orange {
	int sweet;
	int size;
	int[] color;
	// 생성자 - 이 클래스의 인스턴스를 생성할 때 가장 먼저 호출되는 메서드
	Orange() {//클래스 Orange의 기본생성자
		System.out.println("오렌지가 초기화 되었습니다.");
		this.sweet = 5;
		this.size = (int)(Math.random()*3+7);
		this.color = new int[] {255, 165, 0};				
	}

	Orange(int sweet) {// 오버로딩
		// 인스턴스 변수 sweet에 넘겨받은 sweet를 대입
		this.sweet = sweet;
	}

	Orange(int sweet, int size, int[] color) {//오버로딩
		this.sweet = sweet;
		this.size = size;
		this.color = color;
		System.out.println("오버라이딩");
	}


}

class Strawberry{
	
	int seed;
	String color;
	
	public Strawberry(int seed) {
		this.seed = seed;
	}
	
}

//아까 myobj에 만들었던 클래스에 알맞은 생성자를 2개 이상 추가해 보세요.


