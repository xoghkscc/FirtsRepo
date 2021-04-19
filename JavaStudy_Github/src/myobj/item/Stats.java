package myobj.item;

public class Stats {
	public static void main(String[] args) {
		int atk=0, speedAtk, armor, speed, price=0;
		
		Weapon sord = new Weapon("sord", 1000,100);
		sord.item_info();
		sord.use();
		atk += sord.getAtk();
		price += sord.price;
		
		Secondary_Weapon gloves = new Secondary_Weapon("gloves", 300, 20);
		gloves.item_info();
		gloves.use();
		atk += gloves.getAtk();
		gloves.setSpeedAtk(20);
		speedAtk=gloves.getSpeedAtk();
		price += gloves.price;
		
		Armor hat = new Armor("hat", 200);
		hat.item_info();
		hat.armor(20);
		hat.use();
		armor = hat.getArmor();
		price +=hat.price;
		
		Shoes sport_shoes = new Shoes("nike shoes", 400);
		sport_shoes.item_info();
		sport_shoes.speed(20);
		sport_shoes.use();
		speed = sport_shoes.getSpeed();
		price +=sport_shoes.price;
		
		System.out.printf("������ ������ ���ݷ� : %d, ���� : %d, �ӵ� : %d, ���ݼӵ� : %d\n", atk, armor, speed, speedAtk);
		System.out.println("�� ������ " +price+"��");
	}
}
