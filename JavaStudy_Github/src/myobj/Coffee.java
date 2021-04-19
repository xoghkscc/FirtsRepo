package myobj;

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
	
	public final static CoffeeCode AMERICANO = new CoffeeCode(0, "아메리카노");
	public final static CoffeeCode CAFE_LATTE = new CoffeeCode(1, "카페라떼");
	public final static CoffeeCode CAFE_MOCHA = new CoffeeCode(2, "카페모카");
	
	public final static OriginCode COLIMBIA = new OriginCode(0, "콜롬비아");
	public final static OriginCode BRAZIL = new OriginCode(1, "브라질");
	public final static OriginCode ETHIOPIA = new OriginCode(2, "에티오피아");
	public final static OriginCode KENYA = new OriginCode(3, "케냐");
	public final static OriginCode INDIA = new OriginCode(4, "인도");
	
	
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
