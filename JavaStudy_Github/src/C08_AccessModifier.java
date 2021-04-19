import myobj.Diffpackage;

public class C08_AccessModifier {
	public static void main(String[] args) {
		
		C08_2_SamePackage instance = new C08_2_SamePackage();
		
		instance.protected_method();
		instance.default_method();
		instance.public_method();
		
		Diffpackage instance2 = new Diffpackage();
		instance2.public_method();
	}
}

class Snack{
	int size = 10;
	
	private void eat() {
		System.out.println(size - 1);
	}
}

class HoneyButterChip extends Snack{
	private void abc() {
		System.out.println(size);
	}
}

class Choco extends Diffpackage{
	
		public Choco() {
			this.protected_method();
			//상속 받으면 다른 패키지에서도 사용 가능
		}
	void abc() {
		Snack s = new Snack();
		System.out.println(s.size);
		
	}
}