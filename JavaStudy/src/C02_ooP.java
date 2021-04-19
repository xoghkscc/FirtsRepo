import myobj.Overwatch_hero;
import myobj.Peach;

public class C02_ooP {
	public static void main(String[] args) {
		//Apple 클래스(설계도)로 만들어낸 인스턴스(생산품) a1
		Apple a1 = new Apple();
		Apple a2 = new Apple();
		Apple a3 = new Apple();
		
		//다른 패키지에 선언한 public class를 사용할 수 있다.
		Peach p1 = new Peach();
		
		a1.calorie = 100;
		a2.calorie = 120;
		a3.calorie = 115;
		
		a1.eat();
		a1.eat();
//		System.out.println(a1.calorie);
//		System.out.println(a2.calorie);
//		System.out.println(a3.calorie);
		
		//myobj 패키지에 현실의 객체를 참조하여 클래스를 하나 생성한 후 인스턴스를 생성하고 값을 채운다움 출력해 보세요.
		//*인스턴스 변수 개 이상, 인스턴스 메서드 2개 이상, 과일 금지
		Overwatch_hero hero1 = new Overwatch_hero();
		
		hero1.setHeroName("reaper");
		hero1.setPosition("dealer");
		hero1.setHealth(250);
		hero1.setPower(1+20);
		
		System.out.printf("영웅 %s의 공격력은 %d, 체력은 %d, 포지션은 %s입니다", hero1.getHeroName(), hero1.getPower(), hero1.getHealth(), hero1.getPosition() );
		
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
