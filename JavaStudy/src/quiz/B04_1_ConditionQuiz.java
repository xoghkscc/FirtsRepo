package quiz;

public class B04_1_ConditionQuiz {
	/*
    [ 알맞은 비교연산을 만들어보세요 ]
        
    1. int형 변수 a가 10보다 크고 20보다 작을 때 true
    2. int형 변수 b가 짝수일 때 true                
    3. int형 변수 c가 7의 배수일 때 true
    4. int형 변수 hour가 0미만 24이상이 아니고, 12이상일 때 true
    5. int형 변수 d와 e의 차이가 30일 때 true                
    6. int형 변수 year가 400으로 나누어 떨어지거나   
       또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true
    7. 민수가 철수보다 2살 많으면 true
    8. 민수가 철수보다 생일이 3달 빠르면 true  
     9. boolean형 변수 powerOn이 false일 때 true
    10. 문자열 참조변수 str이 "yes"일 때 true
*/  
	public static void main(String[] args) {
		int a = 11, b = 2, c = 14, hour = 13, d = 1, e = 31, year = 400, minsuAge = 20, chulsuAge = 18, minsuBirth = 1,
				chulsuBirth = 4;
		boolean powerOn = false;
		String str = "yes";

		System.out.println("1 :" + (a > 10 && a < 20));
		System.out.println("2 :" + (b % 2 == 0));
		System.out.println("3 :" + (c % 7 == 0));
		System.out.println("4 :" + (!((hour < 0) || (hour >= 24)) && (hour >= 12)));
		System.out.println("5 :" + (Math.abs(d - e) == 30));
		System.out.println("6 :" + ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))));
		System.out.println("7 :" + (minsuAge == chulsuAge + 2));
		System.out.println("8 :" + (minsuBirth == chulsuBirth - 3));
		System.out.println("9 :" + (powerOn == false));
		System.out.println("10 :" + (str.equals("yes")));
		
		String str1 = "yes";
		String str2 = new String("yes");
		String str3 = "yes";
		
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		System.out.println("str1 == str2 :" + (str1 == str2));
		System.out.println("str1 == str2 :" + (str1.equals(str2)));
		System.out.println("str1 == str3 :" + (str1 == str3));
	}

}

