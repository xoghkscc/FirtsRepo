public class A04_VarNaming {
	public static void main(String[] args) {
		int apple_count = 15;
		int apple_price = 493;
		int apple_calorie = 110;
		int apple_gram = 50;
		
		System.out.println("사과의 개수 : " + apple_count);
		System.out.println("사과의 총 가격 : " + apple_price * apple_count + "원");
		System.out.println("사과의 총 칼로리 : " + apple_calorie * apple_count + "kcal");
		System.out.println("사과의 총 무게 : " + apple_gram * apple_count + "g");
	}
}
