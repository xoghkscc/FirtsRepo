
public class C11_AnonymousInnerlass {

//	public static void kick(Kickable something) {
//		something.kick();
//	}

	public static void main(String[] args) {

		class Tree extends Punchable {
			void punch() {
				System.out.println("������ ġ�� ���� ����");
			}
		}

		class Human extends Punchable {
			void punch() {
				System.out.println("����� ġ�� ��� �Ծ�");
			}
		}
		class Jelly extends Punchable {
			void punch() {
				System.out.println("������ ġ�� ������");
			}
		}
		class Dog extends Punchable {
			void punch() {
				System.out.println("�������� ġ�� ������");
			}
		}

		punch(new Tree());// �� 55�� Punchable Ÿ���� �־�� �ϳ� Tree�� Punchable�� �ڽ� Ŭ�����̱� ������ ���� ����
		punch(new Human());// �ְ� �Ǹ� �� 55�� ���Եǿ� Human.punch()�� �ߵ� -->"����� ġ�� ��� �Ծ�
		punch(new Jelly());
		punch(new Dog());

		punch(new Jelly() {
			void punch() {
				System.out.println("������ ġ�� ������");
			}
		});
		punch(new Dog() {
			void punch() {
				System.out.println("�������� ġ�� ������");
			}
		});
		// �߻� Ŭ������ �͸� Ŭ������ ���� �Ｎ���� ��
		punch(new Punchable() {
			void punch() {
				System.out.println("�߻� Ŭ������ �Ｎ���� ������");
			}
		});
	}

	public static void punch(Punchable something) {
		something.punch();
	}
}

abstract class Punchable {
	abstract void punch();
}
