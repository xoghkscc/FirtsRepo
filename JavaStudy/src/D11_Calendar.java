import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class D11_Calendar {
	public static void main(String[] args) {
//		System.out.println("1970년 1월 1일 이후로..."+System.currentTimeMillis()+"밀리초 흘렀습니다.");
//		System.out.println("1970년 1월 1일 이후로..."+System.currentTimeMillis()/1000+"초 흘렀습니다.");
//		System.out.println("1970년 1월 1일 이후로..."+System.currentTimeMillis()/1000/60+"분 흘렀습니다.");
//		System.out.println("1970년 1월 1일 이후로..."+System.currentTimeMillis()/1000/60/60+"시간 흘렀습니다.");
//		System.out.println("1970년 1월 1일 이후로..."+System.currentTimeMillis()/1000/60/60/24+"일 흘렀습니다.");
//		System.out.println("1970년 1월 1일 이후로..."+System.currentTimeMillis()/1000/60/60/24/365+"년 흘렀습니다.");
		
		Date now = new Date();
//		System.out.println(now);
//		System.out.println(now.getMinutes());
		
//		System.out.println("한국 현재 시간 : "+korea.get(Calendar.HOUR));
//		Calendar hawaii = Calendar.getInstance(TimeZone.getTimeZone("US/Hawaii"));
//		System.out.println("하와이 현재 시간 : "+hawaii.get(Calendar.HOUR));
//		for(String zoneId : TimeZone.getAvailableIDs()) {
//			System.out.println(zoneId);
//		}
		Calendar korea = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		//타임존은 생략 가능 다른 나라를 알고 싶으면 TimeZone.getAvailableIDs()을 이용
		int year = korea.get(Calendar.YEAR);
		int month = korea.get(Calendar.MONTH);//Calender 클래스는 month만 0으로 시작한다.
		int date = korea.get(Calendar.DATE);
		korea.set(Calendar.HOUR_OF_DAY, 15);//24시간을 기준으로 15시라고 셋팅
		int hourOfDay = korea.get(Calendar.HOUR_OF_DAY);
		int hour = korea.get(Calendar.HOUR);
		int minute = korea.get(Calendar.MINUTE);
		int second = korea.get(Calendar.SECOND);
		int millisec = korea.get(Calendar.MILLISECOND);
		korea.set(Calendar.YEAR, -50);
		int era = korea.get(Calendar.ERA);
		//Calendar.AM_PM이 필드 상수이고, Calendar.AM과 Calendar.PM은 상수이다(am : 0, pm : 1)
		int am = korea.get(Calendar.AM_PM);
		int doy = korea.get(Calendar.DAY_OF_YEAR);//올해가 시작되고 지난 날짜
		int dom = korea.get(Calendar.DAY_OF_MONTH);//이번 달 시작되고 지난 날짜
		int dow = korea.get(Calendar.DAY_OF_WEEK);//이번 주 시작되고 지난 날짜
		int dowim = korea.get(Calendar.DAY_OF_WEEK_IN_MONTH);//오늘의 요일이 이번달의 몇번째 요일인지
		System.out.printf("%s :  %d/%d/%d\n",korea.getTimeZone().getID(),year,month+1,date);
		//korea.getTimeZone().getID() : Asia/Seoul
		System.out.printf("hour(12H) : %d, hourOfDay(24H) : %d\n", hour, hourOfDay);//(3, 15)
		//hourOfDay가 15시(오후 3시)이므로 hour가 3시가 됨
		System.out.printf("%d:%d.%d\n", minute, second, millisec);
		System.out.println(era==1 ? "AD" : "BC");//Calendar.YEAR을 -50이므로 era = 0이 되어 BC(기원 후면 ear=1)
		System.out.println(am == Calendar.AM ? "AM" : "PM");//Calendar.HOUR_OF_DAY가 15이므로 am = 1이 되어 PM
		System.out.println("DOY(올해가 시작되고 지난 날짜) : "+ doy);
		System.out.println("DOM(이번 달 시작되고 지난 날짜) : "+ dom);
		System.out.println("DOW(이번 주 시작되고 지난 날짜) : "+ dow);
		System.out.println("DOWIM(몇 번째 해당 요일인가) : "+ dowim);
	}
}
