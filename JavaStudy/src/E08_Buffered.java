import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class E08_Buffered {
	// frankenstein.txt를 한 글자씩 모두 읽고 시간을 측정해 보세요.
	// 배열을 사용해서 읽을 때 성능 비교
	public static void main(String[] args) {
		long stratTime = System.currentTimeMillis();
		File file = new File("./note/txt/frankenstein.txt");
		try {
			int ch;
			FileInputStream fi = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fi);
			while ((ch = in.read()) != -1) {
//				System.out.print((char) ch);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long lastTime = System.currentTimeMillis();
		int time = (int) ((int) lastTime - stratTime);
		System.out.println("*******************************");
		System.out.printf("한 글자씩 읽을 때 걸린 시간 : %d(m/s)\n", time);
		System.out.println("*******************************");

		long stratTime2 = System.currentTimeMillis();


		try  {
			StringBuilder sb = new StringBuilder();
			FileReader fr = new FileReader(file);
			char[] buff = new char[2048];
			int len = -1;
			while ((len = fr.read(buff)) != -1) {
				sb.append(new String(buff, 0, len));
			}
//			System.out.println(sb);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		long lastTime2 = System.currentTimeMillis();
		int time2 = (int) ((int) lastTime2 - stratTime2);
		System.out.printf("배열로 읽을 때 걸린 시간 : %d(m/s)\n", time2);
		
		
		long stratTime3 = System.currentTimeMillis();
		
		StringBuilder sb = new StringBuilder();
		try (BufferedReader bin = new BufferedReader(new FileReader(file))){
			String line = null;
			while((line = bin.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long lastTime3 = System.currentTimeMillis();
		int time3 = (int) ((int) lastTime3 - stratTime3);
		System.out.printf("버퍼로 읽을 때 걸린 시간 : %d(m/s)", time3);
		
		
		try (BufferedWriter bout = new BufferedWriter(new FileWriter(new File("./note/txt/abc.txt")))){
			bout.append("Hello, BufferedWriter!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
