import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class D13_Time {
	public static void main(String[] args) {
		//1. now()
		LocalDate today = LocalDate.now();
		System.out.println("1 : " +today);//2021-04-16
		LocalTime now = LocalTime.now();
		System.out.println("2 : "+now);//15:03:30.542
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println("3 : "+ datetime);//2021-04-16T15:03:30.542
		//2. of()
		LocalDate childrensDay = LocalDate.of(2021, 5, 5);//2021�� 5�� 5���� ����(0��x)
		System.out.println("4 : "+childrensDay);//2021-05-05
		LocalTime promise = LocalTime.of(17, 8);
		System.out.println("5 : "+promise);//17:08
		LocalDateTime myPromise = LocalDateTime.of(childrensDay, promise);
		System.out.println("6 : "+myPromise);//2021-05-05T17:08
		//3. �ð��� �����ϱ�
		System.out.println(promise.plusHours(3));//��ӽð����� 3�ð� ���� �ν��Ͻ��� ��ȯ 20:08
		System.out.println(promise);//�״�� 17�÷� ���� 17:08
		System.out.println(childrensDay.minusWeeks(1));//2021-04-28
		System.out.println(childrensDay.plusWeeks(3));//2021-05-26(�������� 3�� �÷���)
		//4. �ð��� ���ڿ��� ��ȯ�ϱ�
		System.out.println(childrensDay.format(DateTimeFormatter.ofPattern("y�� M�� d��")));//2021�� 5�� 5��
		System.out.println(myPromise.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(myPromise.format(DateTimeFormatter.BASIC_ISO_DATE));
		//5. �ð� ��ü���� ���ϱ�
		LocalDate christmas = LocalDate.of(2020, 12, 25);
		System.out.println("2021�� ��̳��� 2020�� ũ������������ ���ΰ���? : "+childrensDay.isAfter(christmas));//true
		System.out.println("2021�� ��̳��� 2021�� ũ������������ ���ΰ���? : "+childrensDay.isBefore(christmas.plusYears(1)));//true
		System.out.println(today.getDayOfWeek().name());
	}
}
