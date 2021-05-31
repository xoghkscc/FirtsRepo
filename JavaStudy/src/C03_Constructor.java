import java.util.Scanner;

import myobj.etc.Overwatch_hero;
import myobj.etc.Peach;

public class C03_Constructor {
	public static void main(String[] args) {
		
//		new Orange();//�������� �ʱ�ȭ �Ǿ����ϴ�.-->���⼭ ��
//		Orange or = new Orange(9, 10, new int[] {235, 143, 52});//�������̵�
//		
//		Orange[] orange_box = new Orange[7];//-->OrangeŸ���� �迭 ����
//		
//		for (int i = 0; i < 5; i++) {
//			orange_box[i] = new Orange();//-->��28~33 ������ �迭 �ȿ� ��
//		}
//		
//		System.out.println(orange_box[0].sweet);//5
//		System.out.println(orange_box[1].size);//����
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
	// ������ - �� Ŭ������ �ν��Ͻ��� ������ �� ���� ���� ȣ��Ǵ� �޼���
	Orange() {//Ŭ���� Orange�� �⺻������
		System.out.println("�������� �ʱ�ȭ �Ǿ����ϴ�.");
		this.sweet = 5;
		this.size = (int)(Math.random()*3+7);
		this.color = new int[] {255, 165, 0};				
	}

	Orange(int sweet) {// �����ε�
		// �ν��Ͻ� ���� sweet�� �Ѱܹ��� sweet�� ����
		this.sweet = sweet;
	}

	Orange(int sweet, int size, int[] color) {//�����ε�
		this.sweet = sweet;
		this.size = size;
		this.color = color;
		System.out.println("�������̵�");
	}


}

class Strawberry{
	
	int seed;
	String color;
	
	public Strawberry(int seed) {
		this.seed = seed;
	}
	
}

//�Ʊ� myobj�� ������� Ŭ������ �˸��� �����ڸ� 2�� �̻� �߰��� ������.


