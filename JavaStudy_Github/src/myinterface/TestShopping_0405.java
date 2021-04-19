package myinterface;

import myobj.Homework_0405.Jajangmyeon;
import myobj.Homework_0405.Rice;

public class TestShopping_0405 {
	public static void test(Shopping_0405 shop) {
		System.out.printf("%s은 %d원이고 원산지는 %s, 칼로리는 %d입니다.\n"
		,shop.name(),shop.price(), shop.origin(), shop.calorie() );
	}
	
	public static void main(String[] args) {
		Shopping_0405 rice = new Rice();
		Shopping_0405 jajang = new Jajangmyeon();
		
		test(rice);
		test(jajang);
	}
	
}


