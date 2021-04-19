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
		LocalDate childrensDay = LocalDate.of(2021, 5, 5);//2021년 5월 5일을 설정(0월x)
		System.out.println("4 : "+childrensDay);//2021-05-05
		LocalTime promise = LocalTime.of(17, 8);
		System.out.println("5 : "+promise);//17:08
		LocalDateTime myPromise = LocalDateTime.of(childrensDay, promise);
		System.out.println("6 : "+myPromise);//2021-05-05T17:08
		//3. 시간을 변경하기
		System.out.println(promise.plusHours(3));//약속시간보다 3시간 뒤인 인스턴스를 반환 20:08
		System.out.println(promise);//그대로 17시로 유지 17:08
		System.out.println(childrensDay.minusWeeks(1));//2021-04-28
		System.out.println(childrensDay.plusWeeks(3));//2021-05-26(원본에서 3주 플러스)
		//4. 시간을 문자열로 변환하기
		System.out.println(childrensDay.format(DateTimeFormatter.ofPattern("y년 M월 d일")));//2021년 5월 5일
		System.out.println(myPromise.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(myPromise.format(DateTimeFormatter.BASIC_ISO_DATE));
		//5. 시간 객체끼리 비교하기
		LocalDate christmas = LocalDate.of(2020, 12, 25);
		System.out.println("2021년 어린이날이 2020년 크리스마스보다 뒤인가요? : "+childrensDay.isAfter(christmas));//true
		System.out.println("2021년 어린이날이 2021년 크리스마스보다 앞인가요? : "+childrensDay.isBefore(christmas.plusYears(1)));//true
		System.out.println(today.getDayOfWeek().name());
	}
}
