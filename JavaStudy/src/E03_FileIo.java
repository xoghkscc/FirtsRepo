import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class E03_FileIo {
	public static void main(String[] args) {
		File git = new File("./note/01_Git.txt");

//		System.out.println(git.exists());
//		System.out.println(git.isDirectory());
//		System.out.println(git.isFile());

		try {
			FileInputStream fin = new FileInputStream(git);
//			int _byte;
//			while ((_byte=fin.read()) != -1) {
//				System.out.print((char)_byte);
//			}
			
//			byte[] buffer = new byte[20000];
//			int len;
//			while((len = fin.read(buffer)) != -1) {
//				System.out.println(new String(buffer));
//			}
			
			fin.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File newFile = new File("./note/my first file output.txt");
			try {
				FileOutputStream fout = new FileOutputStream(newFile,true);
				//1. int를 사용하는 방식
				fout.write(65);
				fout.write(66);
				fout.write(67);
				fout.write(68);
				fout.write(69);
				fout.write(70);
				fout.write('\n');
				
				//2. byte[]를 이용하는 방식
				fout.write("안녕하세요!\n".getBytes());
				
				
				
				fout.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
}
