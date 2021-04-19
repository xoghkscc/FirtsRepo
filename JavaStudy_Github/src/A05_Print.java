
public class A05_Print {
	public static void main(String[] args) {
		/*
		 * int year, month, day, hour, minute, second, millisec;
		 * 
		 * year = 2021; month = 4; day = 17; hour = 11; minute = 9; second = 38;
		 * millisec = 1234;
		 * 
		 * System.out.println(year + "년" + month + "월" + day + "일" + hour + ":" + minute
		 * + ":" + second + "." + millisec);
		 * System.out.printf("%d년 %d월 %d일 / %d:%d:%d.%d\n", year, month, day, hour,
		 * minute, second, millisec);
		 * 
		 * int testNum = 30; System.out.printf("8진수로 %d는 %o\n",testNum,testNum);
		 * System.out.printf("10진수로 %d는 %d\n",testNum,testNum);
		 * System.out.printf("16진수로 %d는 %x\n",testNum,testNum);
		 * System.out.printf("16진수로 %d는 %X\n",testNum,testNum);
		 */
		/*
		 * System.out.printf("사과 : %d개\n", 10);
		 *  System.out.printf("사과 : %10d개\n", 10);		
		 * // System.out.printf("%-s : 10개\n", "사과"); 
		 * System.out.printf("사과 : %-10d개\n",10);
		 */
		
		System.out.printf("%d개\n", 5);
		System.out.printf("%02d개\n", 5);
		System.out.printf("%03d개\n", 5);
		System.out.printf("%010f개\n", 3.141234);
		
		System.out.printf("양수 : %d, 음수 : %d\n", 5, -5);
		System.out.printf("양수 : %+d, 음수 : %d\n", 5, -5);
		
		double avg = 123.12555;
		
		System.out.printf("평균 점수 : %f\n", avg);
		System.out.printf("평균 점수 : %.2f\n", avg);
	}
}
