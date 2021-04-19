package myobj.item;

public class Secondary_Weapon extends Weapon {
	int speedAtk;
	public int getSpeedAtk() {
		return speedAtk;
	}
	public void setSpeedAtk(int speedAtk) {
		this.speedAtk = speedAtk;
	}
	public Secondary_Weapon(String name, int price, int atk) {
		super(name, price, atk);
	}
	public void attack(int atk) {
		super.atk = atk;
	}
	
	public int getAtk() {
		return super.atk;
	}
}
