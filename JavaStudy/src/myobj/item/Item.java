package myobj.item;


//�� Ŭ������ ��ӹ޾� �������� 3�� ��������.
//Item Ŭ������ �������� ����

abstract class Item {
	String name;
	int price;
	
	
	public Item(String name, int price) {
		this.name =name;
		this.price = price;
	}
	
	//final�� ���� �޼���� �ڽ� Ŭ�������� �������̵带 ������Ų��.
	final public void item_info() {
		System.out.printf("�̸� : "+name);
		System.out.println();
		System.out.printf("���� : "+price+"��\n");
	}
	
	abstract void use();
}

	
