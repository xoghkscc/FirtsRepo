
public class C05_Inheritance {
	public static void main(String[] args) {
		Person[] persons = new Person[3];

		persons[0] = new Person("홍길동", 10, 10);
		persons[1] = new Person("고길동", 45, 15);
		persons[2] = new Person("이길동", 30, 12);

		persons[0].sayHi();// 안녕하세요! 제 이름은 홍길동입니다. 제 나이는 10살입니다.
		persons[1].sayHi();// 안녕하세요! 제 이름은 고길동입니다. 제 나이는 45살입니다.
		persons[2].sayHi();// 안녕하세요! 제 이름은 이길동입니다. 제 나이는 30살입니다.
		System.out.println();
		Police police1 = new Police();
		police1.sayHi();// 안녕하십니까! 저는 마동석 형사입니다.(Police에 this.name = "마동석"이기 때문
		police1.walk();// 김경찰씨는 10미터 걸었습니다.
		police1.run();// 김경찰씨는 20미터 뛰었습니다.

		police1.thisSuperTest("둘리");// 그냥 name :둘리
									// this.name :마동석
									// super.name :김경찰
	}
}

class Person {
	String name;
	int age;
	int speed;

	public Person(String name, int age, int speed) {
		this.name = name;
		this.age = age;
		this.speed = speed;
	}

	// 생성자가 존재하므로 Person클래스에는 기본생성자는 없다
	void sayHi() {
		System.out.printf("안녕하세요! 제 이름은 %s입니다. 제 나이는 %d살입니다.\n", name, age);
	}

	void walk() {
		System.out.printf("%s씨는 %d미터 걸었습니다.\n", name, speed / 2);
	}

	void run() {
		System.out.printf("%s씨는 %d미터 뛰었습니다.\n", name, speed);
	}
}

//class Programmer extends Person{
//	//부모 클래스의 기본생성자가 없기 때문에 생성자를 호출하지 않으면 이렇게 오류가 뜸
//}
class Police extends Person {
	String name = "마동석";

	public Police() {
		// 부모 클래스에는 기본 생성자가 없고 그냥 생성자가 있기 때문에 부모 생성자를 호출(super로 호출)
		super("김경찰", 23, 20);// 즉 부모 클래스의 메서드를 사용하면 필요한 변수를 super로 통해 전달해야함
	}

	void sayHi() {
		// 오버라이드, 좌측에 화살표 표시가 오버라이드고 누르면 부모 클래스의 메서드로 이동
		System.out.printf("안녕하십니까! 저는 %s 형사입니다. \n", name);
	}

	void thisSuperTest(String name/* 둘리를 기입 */) {
		System.out.println("그냥 name :" + name); // -->둘리
		System.out.println("this.name :" + this.name);// -->마동석
		System.out.println("super.name :" + super.name);// -->김경찰
	}
	
	void arrest(String suspect) {
		System.out.printf("%s 형사는 용의자  %s씨를 체포했습니다.\n", name, suspect);
	}
	
	
	
}
