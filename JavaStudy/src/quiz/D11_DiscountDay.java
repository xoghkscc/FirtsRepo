package quiz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import myobj.MyScanner;

public class D11_DiscountDay {
	//� ī�信�� ¦����° ����ϸ��� ������縦 �����Ѵٰ� ���� �� �� �⵵�� �Է��ϸ� �ش� �⵵��
	//��� ���� ��¥�� ����� ������.
	public static void main(String[] args) {
		SimpleDateFormat eventFormat = new SimpleDateFormat("yyyy��MM��dd��\t");
		int cnt=1;
		Calendar korea = Calendar.getInstance();
		korea.set(Calendar.YEAR, MyScanner.inputInt("�⵵�� �Է��ϼ���>>"));
		for (int i = 0; i < 12; i++) {
			korea.set(Calendar.MONTH, i);
			int maxDay =korea.getActualMaximum(Calendar.DATE);
			int month =korea.get(Calendar.MONTH)+1;
			System.out.println(month+"��");
			for (int j = 1; j <= maxDay; j++) {
				korea.set(Calendar.DATE, j);
				int dow = korea.get(Calendar.DAY_OF_WEEK);
				int dowim = korea.get(Calendar.DAY_OF_WEEK_IN_MONTH);
				if(dow==5 && dowim % 2 == 0) {
					System.out.printf(eventFormat.format(korea.getTime()) + "[%d��° ���]\n", cnt++);
//					System.out.printf("%d�� %d��\t[%s��° ���]\n", month, korea.get(Calendar.DATE), cnt++);
//					System.out.printf("%d�� %d��\t[%s��° ���]\n", month, korea.get(Calendar.DATE)+14, cnt++);
//					break;
				}
			}
			korea.set(Calendar.DATE, 1);
			System.out.println("-----------------------");
		}
	}
}
