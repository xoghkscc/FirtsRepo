public class C06_Polymorphism {

	public static void doSomethingwhitMainMaterial(MainMaterial mat) {
		
	}
	
	public static void main(String[] args) {
		new Food(new PigMeat(), new Vege(), new Balskmic() );
		
		MainMaterial main_mat = new MainMaterial();
		MainMaterial main_mat2 = new Meat();//*�̰� ��ü�� �������� Meat�� MainMaterial�� ��ӹ޾ұ� ������ ����-->�����ϱ� �����ϰ� 
		//���������ϱ� �����ϱ� ���ؼ��� �� ������ MainMaterial�� �Ǿ� ������ ������ ���� Meat, Fish, Sauce�� ���� �����ϱ� ����
		
		
		doSomethingwhitMainMaterial(main_mat2);//-->�Ʒ��� Ŭ���� ���¸� �Ű������� ���� ����
		doSomethingwhitMainMaterial(new MainMaterial());//-->�Ʒ��� Ŭ���� ���¸� �Ű������� ���� ����
		doSomethingwhitMainMaterial(new Meat());//-->MainMaterial�� ��ӹ��� meat ����
		doSomethingwhitMainMaterial(new Fish());//-->MainMaterial�� ��ӹ��� fish ����
		doSomethingwhitMainMaterial(new PigMeat());//-->MainMaterial�� ��ӹ��� meat ��ӹ� ����
		
		Police p1 = new Police();
		p1.sayHi();
		p1.arrest("�谭��");
		
		Person person = new Police();//��ĳ����
		Person person2 = new Person("����ġ", 20, 30);
		person.sayHi();//police�� �ִ� sayHi�� ����
//		person.thisSuperTest();//�ڽ�ĳ������ ��ĳ������ �Ǿ Police�� thisSuperTest �޼��� ��� �Ұ���
		//�ٿ� ĳ������ Ȱ���� ���� ��� �ٽ� ����ϱ�
		((Police)person).arrest("��Ҹ�");//���� �����̾��� �ν��Ͻ��� �ٿ�ĳ������ ����
		((Police)person2).arrest("��ٺ�");//������ �ƴϾ��� �ν��Ͻ��� �ٿ�ĳ������ �Ұ���
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

//���� ���� �θ� Ŭ���� (�����, �����, �ҽ�)
class MainMaterial{}
class SubMaterial{}
class Sauce {}

//����Ḧ ��ӹ��� Ŭ������
class Fish extends MainMaterial{}
class Meat extends MainMaterial{}

//����Ḧ ��ӹ��� Ŭ������ ��ӹ��� Ŭ����
class PigMeat extends Meat{}

//����Ḧ ��ӹ��� Ŭ������
class Vege extends SubMaterial{}

//�ҽ��� ��ӹ��� Ŭ������
class Balskmic extends Sauce{}



