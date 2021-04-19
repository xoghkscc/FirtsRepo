public class C06_Polymorphism {

	public static void doSomethingwhitMainMaterial(MainMaterial mat) {
		
	}
	
	public static void main(String[] args) {
		new Food(new PigMeat(), new Vege(), new Balskmic() );
		
		MainMaterial main_mat = new MainMaterial();
		MainMaterial main_mat2 = new Meat();//*이게 객체의 다형성임 Meat는 MainMaterial를 상속받았기 때문에 가능-->수정하기 유용하고 
		//유지보수하기 쉽게하기 위해서임 즉 좌측이 MainMaterial로 되어 있으면 우측에 대해 Meat, Fish, Sauce로 변경 가능하기 때문
		
		
		doSomethingwhitMainMaterial(main_mat2);//-->아래에 클래스 형태를 매개변수로 대입 가능
		doSomethingwhitMainMaterial(new MainMaterial());//-->아래에 클래스 형태를 매개변수로 대입 가능
		doSomethingwhitMainMaterial(new Meat());//-->MainMaterial을 상속받은 meat 가능
		doSomethingwhitMainMaterial(new Fish());//-->MainMaterial을 상속받은 fish 가능
		doSomethingwhitMainMaterial(new PigMeat());//-->MainMaterial을 상속받은 meat 상속받 가능
		
		Police p1 = new Police();
		p1.sayHi();
		p1.arrest("김강도");
		
		Person person = new Police();//업캐스팅
		Person person2 = new Person("전우치", 20, 30);
		person.sayHi();//police에 있는 sayHi가 나옴
//		person.thisSuperTest();//자식캐스팅이 업캐스팅이 되어서 Police에 thisSuperTest 메서드 사용 불가능
		//다운 캐스팅을 활용해 원래 기능 다시 사용하기
		((Police)person).arrest("김소매");//원래 경찰이었던 인스턴스는 다운캐스팅이 가능
		((Police)person2).arrest("김바보");//경찰이 아니었던 인스턴스는 다운캐스팅이 불가능
	}
	
}

class Food{
	public Food(MainMaterial mainMat, SubMaterial subMat, Sauce sauce) {
	}
}
class PorkCutlet{
	public PorkCutlet(PigMeat pig, SubMaterial subMat, Sauce sauce) {
		
	}
	
}

//제일 높은 부모 클래스 (주재료, 부재료, 소스)
class MainMaterial{}
class SubMaterial{}
class Sauce {}

//주재료를 상속받은 클래스들
class Fish extends MainMaterial{}
class Meat extends MainMaterial{}

//주재료를 상속받은 클래스를 상속받은 클래스
class PigMeat extends Meat{}

//부재료를 상속받은 클래스들
class Vege extends SubMaterial{}

//소스를 상속받은 클래스들
class Balskmic extends Sauce{}



