import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class D11_Calendar {
	public static void main(String[] args) {
//		System.out.println("1970�� 1�� 1�� ���ķ�..."+System.currentTimeMillis()+"�и��� �귶���ϴ�.");
//		System.out.println("1970�� 1�� 1�� ���ķ�..."+System.currentTimeMillis()/1000+"�� �귶���ϴ�.");
//		System.out.println("1970�� 1�� 1�� ���ķ�..."+System.currentTimeMillis()/1000/60+"�� �귶���ϴ�.");
//		System.out.println("1970�� 1�� 1�� ���ķ�..."+System.currentTimeMillis()/1000/60/60+"�ð� �귶���ϴ�.");
//		System.out.println("1970�� 1�� 1�� ���ķ�..."+System.currentTimeMillis()/1000/60/60/24+"�� �귶���ϴ�.");
//		System.out.println("1970�� 1�� 1�� ���ķ�..."+System.currentTimeMillis()/1000/60/60/24/365+"�� �귶���ϴ�.");
		
		Date now = new Date();
//		System.out.println(now);
//		System.out.println(now.getMinutes());
		
//		System.out.println("�ѱ� ���� �ð� : "+korea.get(Calendar.HOUR));
//		Calendar hawaii = Calendar.getInstance(TimeZone.getTimeZone("US/Hawaii"));
//		System.out.println("�Ͽ��� ���� �ð� : "+hawaii.get(Calendar.HOUR));
//		for(String zoneId : TimeZone.getAvailableIDs()) {
//			System.out.println(zoneId);
//		}
		Calendar korea = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		//Ÿ������ ���� ���� �ٸ� ���� �˰� ������ TimeZone.getAvailableIDs()�� �̿�
		int year = korea.get(Calendar.YEAR);
		int month = korea.get(Calendar.MONTH);//Calender Ŭ������ month�� 0���� �����Ѵ�.
		int date = korea.get(Calendar.DATE);
		korea.set(Calendar.HOUR_OF_DAY, 15);//24�ð��� �������� 15�ö�� ����
		int hourOfDay = korea.get(Calendar.HOUR_OF_DAY);
		int hour = korea.get(Calendar.HOUR);
		int minute = korea.get(Calendar.MINUTE);
		int second = korea.get(Calendar.SECOND);
		int millisec = korea.get(Calendar.MILLISECOND);
		korea.set(Calendar.YEAR, -50);
		int era = korea.get(Calendar.ERA);
		//Calendar.AM_PM�� �ʵ� ����̰�, Calendar.AM�� Calendar.PM�� ����̴�(am : 0, pm : 1)
		int am = korea.get(Calendar.AM_PM);
		int doy = korea.get(Calendar.DAY_OF_YEAR);//���ذ� ���۵ǰ� ���� ��¥
		int dom = korea.get(Calendar.DAY_OF_MONTH);//�̹� �� ���۵ǰ� ���� ��¥
		int dow = korea.get(Calendar.DAY_OF_WEEK);//�̹� �� ���۵ǰ� ���� ��¥
		int dowim = korea.get(Calendar.DAY_OF_WEEK_IN_MONTH);//������ ������ �̹����� ���° ��������
		System.out.printf("%s :  %d/%d/%d\n",korea.getTimeZone().getID(),year,month+1,date);
		//korea.getTimeZone().getID() : Asia/Seoul
		System.out.printf("hour(12H) : %d, hourOfDay(24H) : %d\n", hour, hourOfDay);//(3, 15)
		//hourOfDay�� 15��(���� 3��)�̹Ƿ� hour�� 3�ð� ��
		System.out.printf("%d:%d.%d\n", minute, second, millisec);
		System.out.println(era==1 ? "AD" : "BC");//Calendar.YEAR�� -50�̹Ƿ� era = 0�� �Ǿ� BC(��� �ĸ� ear=1)
		System.out.println(am == Calendar.AM ? "AM" : "PM");//Calendar.HOUR_OF_DAY�� 15�̹Ƿ� am = 1�� �Ǿ� PM
		System.out.println("DOY(���ذ� ���۵ǰ� ���� ��¥) : "+ doy);
		System.out.println("DOM(�̹� �� ���۵ǰ� ���� ��¥) : "+ dom);
		System.out.println("DOW(�̹� �� ���۵ǰ� ���� ��¥) : "+ dow);
		System.out.println("DOWIM(�� ��° �ش� �����ΰ�) : "+ dowim);
	}
}
