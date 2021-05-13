import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class E04_StreamToChar {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("./note/output.txt");
			OutputStreamWriter out = new OutputStreamWriter(fout, Charset.forName("UTF-8"));
			out.write("히힛2");//OutputStreamWriter을 할때는 입력할 때 한글이 깨지지 않음
			
			out.close();
//			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			int ch;
			FileInputStream in2 = new FileInputStream(new File("./note/output.txt"));
			InputStreamReader in = 	new InputStreamReader(in2, "UTF-8");
			while((ch = in.read()) != -1) {
				System.out.print((char)ch);//InputStreamReader을 할때는 한글이 깨지나 이걸로하면 한글이 안깨짐
		
			}
			in.close();
//			in2.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
