package myobj;

public class Overwatch_hero {
	private int health=0, power=0;
	private String heroName;
	private String position;
	
	public Overwatch_hero() {
		System.out.printf("영웅의 이름, 체력, 공격력, 포지션을 오버라이딩된 생성자에 입력해 보세요.");
	}
	public Overwatch_hero(int health, int power, String heroName, String position) {
		this.health = health;
		this.power = power;
		this.heroName = heroName;
		this.position = position;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getHeroName() {
		return heroName;
	}
	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

}
