
public class D03_WrapperClass {

	
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt("1234ABC", 16);//-->문자가 있어 오류가 남
			System.out.println(a);
		}
		catch (NumberFormatException e) {
			System.out.println("int로 변환할 수 없는 문자열이었습니다.");
		}
		
		//스태틱 메서드
		System.out.println(Integer.toString(123456,2));//123456을 2진법
		System.out.println(Integer.toString(123456));//123456을 10진법
		//인스턴스 메서드
		Integer num2 = 10;
		System.out.println(num2.toString());
		
		Integer num = 10000000;
		System.out.println(num.byteValue());//-128
		System.out.println(num.shortValue());//-27008
		System.out.println(num.doubleValue());//1.0E7
		System.out.println(num.floatValue());//1.0E7
		System.out.println(num.longValue());//10000000
	
	}
	
}
