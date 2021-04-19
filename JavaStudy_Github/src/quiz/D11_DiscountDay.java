package quiz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import myobj.MyScanner;

public class D11_DiscountDay {
	//어떤 카페에서 짝수번째 목요일마다 할인행사를 진행한다고 가정 할 때 년도를 입력하면 해당 년도의
	//모든 할인 날짜를 출력해 보세요.
	public static void main(String[] args) {
		SimpleDateFormat eventFormat = new SimpleDateFormat("yyyy년MM월dd일\t");
		int cnt=1;
		Calendar korea = Calendar.getInstance();
		korea.set(Calendar.YEAR, MyScanner.inputInt("년도를 입력하세요>>"));
		for (int i = 0; i < 12; i++) {
			korea.set(Calendar.MONTH, i);
			int maxDay =korea.getActualMaximum(Calendar.DATE);
			int month =korea.get(Calendar.MONTH)+1;
			System.out.println(month+"월");
			for (int j = 1; j <= maxDay; j++) {
				korea.set(Calendar.DATE, j);
				int dow = korea.get(Calendar.DAY_OF_WEEK);
				int dowim = korea.get(Calendar.DAY_OF_WEEK_IN_MONTH);
				if(dow==5 && dowim % 2 == 0) {
					System.out.printf(eventFormat.format(korea.getTime()) + "[%d번째 행사]\n", cnt++);
//					System.out.printf("%d월 %d일\t[%s번째 행사]\n", month, korea.get(Calendar.DATE), cnt++);
//					System.out.printf("%d월 %d일\t[%s번째 행사]\n", month, korea.get(Calendar.DATE)+14, cnt++);
//					break;
				}
			}
			korea.set(Calendar.DATE, 1);
			System.out.println("-----------------------");
		}
	}
}
