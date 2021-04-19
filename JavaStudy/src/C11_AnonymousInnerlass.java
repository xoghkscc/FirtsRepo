
public class C11_AnonymousInnerlass {

//	public static void kick(Kickable something) {
//		something.kick();
//	}

	public static void main(String[] args) {

		class Tree extends Punchable {
			void punch() {
				System.out.println("나무를 치면 손이 아파");
			}
		}

		class Human extends Punchable {
			void punch() {
				System.out.println("사람을 치면 콩밥 먹어");
			}
		}
		class Jelly extends Punchable {
			void punch() {
				System.out.println("젤리를 치면 말랑해");
			}
		}
		class Dog extends Punchable {
			void punch() {
				System.out.println("강아지는 치면 쓰레기");
			}
		}

		punch(new Tree());// 행 55에 Punchable 타입을 넣어야 하나 Tree는 Punchable의 자식 클래스이기 때문에 대입 가능
		punch(new Human());// 넣게 되면 행 55에 대입되여 Human.punch()가 발동 -->"사람을 치면 콩밥 먹어
		punch(new Jelly());
		punch(new Dog());

		punch(new Jelly() {
			void punch() {
				System.out.println("젤리를 치면 으깨져");
			}
		});
		punch(new Dog() {
			void punch() {
				System.out.println("강아지를 치면 깨개갱");
			}
		});
		// 추상 클래스도 익명 클래스를 통해 즉석으로 함
		punch(new Punchable() {
			void punch() {
				System.out.println("추상 클래스도 즉석으로 되지롱");
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
