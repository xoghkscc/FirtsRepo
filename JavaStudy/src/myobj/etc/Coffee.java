package myobj.etc;

public class Coffee {
	
	static class CoffeeCode{
		int code;
		static String name;
		 public CoffeeCode(int code, String name) {
			this.code = code;
			this.name = name;
		}
	}
	
	static class OriginCode{
		int code;
		static String name;
		public OriginCode(int code, String name) {
			this.code = code;
			this.name = name;
		}
	}
	
	public final static CoffeeCode AMERICANO = new CoffeeCode(0, "�Ƹ޸�ī��");
	public final static CoffeeCode CAFE_LATTE = new CoffeeCode(1, "ī���");
	public final static CoffeeCode CAFE_MOCHA = new CoffeeCode(2, "ī���ī");
	
	public final static OriginCode COLIMBIA = new OriginCode(0, "�ݷҺ��");
	public final static OriginCode BRAZIL = new OriginCode(1, "�����");
	public final static OriginCode ETHIOPIA = new OriginCode(2, "��Ƽ���Ǿ�");
	public final static OriginCode KENYA = new OriginCode(3, "�ɳ�");
	public final static OriginCode INDIA = new OriginCode(4, "�ε�");
	
	
	CoffeeCode coffee;
	int price;
	int caffeine;
	OriginCode origin;
	
	boolean hot;
	
	public Coffee(CoffeeCode coffee, int price, int caffeine, OriginCode country) {
		this.coffee=coffee;
		this.price = price;
		this.caffeine = caffeine;
		this.origin = origin;
		this.hot = true;
	}
	
	
	public String getCoffeeName() {
		return CoffeeCode.name;
	}
	
	public String getOriginName() {
		return OriginCode.name;
	}
	
	
	public static void main(String[] args) {
		Coffee coffee = new Coffee(Coffee.AMERICANO, 1500, 10, Coffee.COLIMBIA);
		Coffee coffee1 = new Coffee(Coffee.CAFE_LATTE, 1500, 10, Coffee.BRAZIL);
		Coffee coffee2= new Coffee(Coffee.CAFE_MOCHA, 1500, 10, Coffee.ETHIOPIA);
		Coffee coffee3 = new Coffee(Coffee.CAFE_MOCHA, 1500, 10, Coffee.KENYA);
		
		System.out.println(coffee3.getCoffeeName());
		System.out.println(coffee3.getOriginName());
	}
	
}
