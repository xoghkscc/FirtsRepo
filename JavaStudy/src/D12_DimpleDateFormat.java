import java.text.SimpleDateFormat;
import java.util.Calendar;

public class D12_DimpleDateFormat {
	public static void main(String[] args) {
		SimpleDateFormat f1 = new SimpleDateFormat("yy/MM/dd HH:mm:ss.SSS a EEEE w W");
		System.out.println(f1.format(Calendar.getInstance().getTime()));
	}
}
