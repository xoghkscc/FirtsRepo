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
		Weapon wp = new Weapon("장검", 10000, 100);
		inven1.put(wp);
		
		Armor ar = new Armor("방패", 5000);
		ar.armor(50);
		inven1.put(ar);
		
		Shoes sh = new Shoes("날개신발", 20000);
		sh.speed(15);
		inven1.put(sh);
		inven1.useAllItems();
		//Item을 넣어야 하는 자리에 Item을 상속받은 모든 것들이 들어갈 수 있다.
		
//		for (int i = 0; i < 4; i++) {
//			if(inven1.put(new Candy("리콜라", 3000))) {
//				System.out.println("아이템이 잘 들어가면 put()에서 true가 리턴됨");
//			}else {
//				System.out.println("아이템이 못들어가면 put()에서 false가 리턴됨");
//			}
// 		}
	}
}
