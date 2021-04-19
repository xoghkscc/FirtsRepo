
public class C05_Inheritance {
	public static void main(String[] args) {
		Person[] persons = new Person[3];

		persons[0] = new Person("ȫ�浿", 10, 10);
		persons[1] = new Person("��浿", 45, 15);
		persons[2] = new Person("�̱浿", 30, 12);

		persons[0].sayHi();// �ȳ��ϼ���! �� �̸��� ȫ�浿�Դϴ�. �� ���̴� 10���Դϴ�.
		persons[1].sayHi();// �ȳ��ϼ���! �� �̸��� ��浿�Դϴ�. �� ���̴� 45���Դϴ�.
		persons[2].sayHi();// �ȳ��ϼ���! �� �̸��� �̱浿�Դϴ�. �� ���̴� 30���Դϴ�.
		System.out.println();
		Police police1 = new Police();
		police1.sayHi();// �ȳ��Ͻʴϱ�! ���� ������ �����Դϴ�.(Police�� this.name = "������"�̱� ����
		police1.walk();// ��������� 10���� �ɾ����ϴ�.
		police1.run();// ��������� 20���� �پ����ϴ�.

		police1.thisSuperTest("�Ѹ�");// �׳� name :�Ѹ�
									// this.name :������
									// super.name :�����
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

	// �����ڰ� �����ϹǷ� PersonŬ�������� �⺻�����ڴ� ����
	void sayHi() {
		System.out.printf("�ȳ��ϼ���! �� �̸��� %s�Դϴ�. �� ���̴� %d���Դϴ�.\n", name, age);
	}

	void walk() {
		System.out.printf("%s���� %d���� �ɾ����ϴ�.\n", name, speed / 2);
	}

	void run() {
		System.out.printf("%s���� %d���� �پ����ϴ�.\n", name, speed);
	}
}

//class Programmer extends Person{
//	//�θ� Ŭ������ �⺻�����ڰ� ���� ������ �����ڸ� ȣ������ ������ �̷��� ������ ��
//}
class Police extends Person {
	String name = "������";

	public Police() {
		// �θ� Ŭ�������� �⺻ �����ڰ� ���� �׳� �����ڰ� �ֱ� ������ �θ� �����ڸ� ȣ��(super�� ȣ��)
		super("�����", 23, 20);// �� �θ� Ŭ������ �޼��带 ����ϸ� �ʿ��� ������ super�� ���� �����ؾ���
	}

	void sayHi() {
		// �������̵�, ������ ȭ��ǥ ǥ�ð� �������̵�� ������ �θ� Ŭ������ �޼���� �̵�
		System.out.printf("�ȳ��Ͻʴϱ�! ���� %s �����Դϴ�. \n", name);
	}

	void thisSuperTest(String name/* �Ѹ��� ���� */) {
		System.out.println("�׳� name :" + name); // -->�Ѹ�
		System.out.println("this.name :" + this.name);// -->������
		System.out.println("super.name :" + super.name);// -->�����
	}
	
	void arrest(String suspect) {
		System.out.printf("%s ����� ������  %s���� ü���߽��ϴ�.\n", name, suspect);
	}
	
	
	
}
