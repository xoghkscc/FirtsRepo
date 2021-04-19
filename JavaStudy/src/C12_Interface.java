
public class C12_Interface {
	public static void main(String[] args) {
		new OrangeTree().click();
	}
}

interface CanClick{
	int a = 10;//인터페이스 내부의 변수는 자동으로 final static이 됨
	
	//abstract 안써도 됨
	//인터페이스 내부에 메서드를 정의할 때 default를 붙이면 기본 동작을 설정-
	default void click() {
		System.out.println("클릭 인터페이스가 달려있는 클래스의 기본 동작." + "(오버라이드해서 사용해주세요.)");
	}
}

interface CanPunch{
	abstract void punch();
	
//	void click() {//앞에 default를 쓰지 않으면 작동하지 않음
//		System.out.println("ㅎㅇ");
//	}
}

class OrangeTree implements CanClick, CanPunch{


	@Override
	public void punch() {
		
	}
	
}

