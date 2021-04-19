package myobj.item;

import java.util.Arrays;

public class Inventory {
	Item[] inventory;
	int size;
	public Inventory(int size) {
		inventory = new Item[size];
	}
	
	public void put(Item item) {
		for (int i = 0; i < inventory.length; i++) {
			if(inventory[i] == null) {
				inventory[i] = item;
				break;
			}
		}
	}
	
	public void useAllItems() {
		for(Item item : inventory) {
			if(item != null) {
				item.use();
			}
		}
	}

	public static void main(String[] args) {
		Inventory inven1 = new Inventory(3);
		Weapon wp = new Weapon("���", 10000, 100);
		inven1.put(wp);
		
		Armor ar = new Armor("����", 5000);
		ar.armor(50);
		inven1.put(ar);
		
		Shoes sh = new Shoes("�����Ź�", 20000);
		sh.speed(15);
		inven1.put(sh);
		inven1.useAllItems();
		//Item�� �־�� �ϴ� �ڸ��� Item�� ��ӹ��� ��� �͵��� �� �� �ִ�.
		
//		for (int i = 0; i < 4; i++) {
//			if(inven1.put(new Candy("���ݶ�", 3000))) {
//				System.out.println("�������� �� ���� put()���� true�� ���ϵ�");
//			}else {
//				System.out.println("�������� ������ put()���� false�� ���ϵ�");
//			}
// 		}
	}
}
