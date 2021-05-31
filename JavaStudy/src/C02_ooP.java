import myobj.etc.Overwatch_hero;
import myobj.etc.Peach;

public class C02_ooP {
	public static void main(String[] args) {
		//Apple Ŭ����(���赵)�� ���� �ν��Ͻ�(����ǰ) a1
		Apple a1 = new Apple();
		Apple a2 = new Apple();
		Apple a3 = new Apple();
		
		//�ٸ� ��Ű���� ������ public class�� ����� �� �ִ�.
		Peach p1 = new Peach();
		
		a1.calorie = 100;
		a2.calorie = 120;
		a3.calorie = 115;
		
		a1.eat();
		a1.eat();
//		System.out.println(a1.calorie);
//		System.out.println(a2.calorie);
//		System.out.println(a3.calorie);
		
		//myobj ��Ű���� ������ ��ü�� �����Ͽ� Ŭ������ �ϳ� ������ �� �ν��Ͻ��� �����ϰ� ���� ä��ٿ� ����� ������.
		//*�ν��Ͻ� ���� �� �̻�, �ν��Ͻ� �޼��� 2�� �̻�, ���� ����
		Overwatch_hero hero1 = new Overwatch_hero();
		
		hero1.setHeroName("reaper");
		hero1.setPosition("dealer");
		hero1.setHealth(250);
		hero1.setPower(1+20);
		
		System.out.printf("���� %s�� ���ݷ��� %d, ü���� %d, �������� %s�Դϴ�", hero1.getHeroName(), hero1.getPower(), hero1.getHealth(), hero1.getPosition() );
		
	}
}

class Apple {
	int size, calorie;
	long lifetime;
	double sweet;
	String color;
	
	void eat() {
		size--;
		calorie -=10;
	}
}
