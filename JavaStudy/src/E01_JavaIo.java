import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E01_JavaIo {
	public static void main(String[] args) {
		FileOutputStream fout = null;
		try {
			// *소스에서 현재 위치는 프로젝트의 root이다
			fout = new FileOutputStream("files\\21.04.20.txt", true);// ./은 생략되어 있는거임
			//FileOutputStram(File file, boolean append)타입이며 append가 true일 경우에는 파일의 데이터를 계속 쌓고 false거나 비어있으면 덮어 씌움
			
			for(int i = 0; i<10; i++) {
				fout.write(String.format("오늘은 날씨가 참 좋네요...%d\n", i).getBytes());//getBytes : String을 byte로 바꿔주는 메서드
			}
			System.out.println("파일 쓰기 완료");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못찾음");
		} catch (IOException e) {
			System.out.println("데이터를 쓰다가 문제가 생겼음");
		} finally {
			if(fout != null) {
				try {
					//I/O Stream은 수동으로 close()를 호출해줘야 한다 (메모리 회수)
					fout.close();
					//close하면서 오류가 생길 일은 없기에 catch는 대충 만듬 아니면 extend로 던지든지
				} catch (IOException e) {}
			}
		}
	}
}
