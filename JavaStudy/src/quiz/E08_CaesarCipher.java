package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class E08_CaesarCipher {
	// #"frankenstein.txt"의 전체 내용을 1 ~ 25 사이의 랜덤 키로 암호화한
	//"frankenstein.encrypted.txt를 생성해보세요.(단 알파벳만 암호화 할 것)
	public static void main(String[] args) {
		File file = new File("./note/txt/frankenstein.txt");
		E08_CaesarCipher cipher = new E08_CaesarCipher();
		StringBuilder str =cipher.getFileStr(file);
		cipher.setEncrypted(str);
	}
	
	public StringBuilder getFileStr(File file) {
		
		StringBuilder str = new StringBuilder();
		try {
			int ch;
			FileInputStream fi = new FileInputStream(file);
			InputStreamReader in = new InputStreamReader(fi);
			while ((ch = in.read()) != -1) {
				str.append((char) ch);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public void setEncrypted(StringBuilder str) {
		File file = new File("./note/txt/frankenstein.encrypted.txt");
		try {
			int ch;
			FileOutputStream fo = new FileOutputStream(file);
			OutputStreamWriter io = new OutputStreamWriter(fo);
			while ((ch = in.read()) != -1) {
				str.append((char) ch);
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
