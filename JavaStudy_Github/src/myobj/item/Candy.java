package myobj.item;

public class Candy extends Item {
	
	int healthy;
	
	public Candy(String name, int price) {
		super(name, price);
		healthy = 10;
	}
	
	public void use() {
		System.out.println("������ ���㼭" + healthy+"��ŭ �� �ǰ��� ���������ϴ�.");
	}

}
