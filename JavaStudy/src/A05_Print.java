
public class A05_Print {
	public static void main(String[] args) {
		/*
		 * int year, month, day, hour, minute, second, millisec;
		 * 
		 * year = 2021; month = 4; day = 17; hour = 11; minute = 9; second = 38;
		 * millisec = 1234;
		 * 
		 * System.out.println(year + "��" + month + "��" + day + "��" + hour + ":" + minute
		 * + ":" + second + "." + millisec);
		 * System.out.printf("%d�� %d�� %d�� / %d:%d:%d.%d\n", year, month, day, hour,
		 * minute, second, millisec);
		 * 
		 * int testNum = 30; System.out.printf("8������ %d�� %o\n",testNum,testNum);
		 * System.out.printf("10������ %d�� %d\n",testNum,testNum);
		 * System.out.printf("16������ %d�� %x\n",testNum,testNum);
		 * System.out.printf("16������ %d�� %X\n",testNum,testNum);
		 */
		/*
		 * System.out.printf("��� : %d��\n", 10);
		 *  System.out.printf("��� : %10d��\n", 10);		
		 * // System.out.printf("%-s : 10��\n", "���"); 
		 * System.out.printf("��� : %-10d��\n",10);
		 */
		
		System.out.printf("%d��\n", 5);
		System.out.printf("%02d��\n", 5);
		System.out.printf("%03d��\n", 5);
		System.out.printf("%010f��\n", 3.141234);
		
		System.out.printf("��� : %d, ���� : %d\n", 5, -5);
		System.out.printf("��� : %+d, ���� : %d\n", 5, -5);
		
		double avg = 123.12555;
		
		System.out.printf("��� ���� : %f\n", avg);
		System.out.printf("��� ���� : %.2f\n", avg);
	}
}
