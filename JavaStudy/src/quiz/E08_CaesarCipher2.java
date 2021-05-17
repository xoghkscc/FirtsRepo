package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E08_CaesarCipher2 {
	// #"frankenstein.txt"의 전체 내용을 1 ~ 25 사이의 랜덤 키로 암호화한
	// "frankenstein.encrypted.txt를 생성해보세요.(단 알파벳만 암호화 할 것)
	public static void main(String[] args) {
		File inputFile = new File("./note/txt2/frankenstein.txt");
		File outputFile = new File("./note/txt2/frankenstein.encrypted.txt");
		
		E08_CaesarCipher2 cipher = new E08_CaesarCipher2();
		StringBuilder str, str2;
		str = cipher.getFileStr(inputFile);// 파일에 있는 정보를 문자열로 받아오는 메서드
		int key = cipher.setEncrypted(str, outputFile);// 문자열을 넘기면 암호화에 맞게 정보를 변환한 파일을 만드는 메서드(사용된 KEY값 반환)
		str2 = cipher.getFileStr(outputFile, key);
		System.out.println("암호화 된 텍스트 돌리기 : "+str);
		System.out.println("랜덤으로 사용된 키 값 :" + key);
	}

	public StringBuilder getFileStr(File inputFile) {

		StringBuilder str = new StringBuilder();
		try (FileReader fr = new FileReader(inputFile);
				BufferedReader br = new BufferedReader(fr)){
			String line = null;;
			while((line = br.readLine()) != null) {
				str.append(line);
				str.append("\n");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public StringBuilder getFileStr(File inputFile, int key) {
		
		StringBuilder str = new StringBuilder();
		try {
			int ch;
			FileInputStream fi = new FileInputStream(inputFile);
			InputStreamReader in = new InputStreamReader(fi);
			while ((ch = in.read()) != -1) {
					char alpha = (char) ch;
					Boolean lower = false;//알파벳이 소문자에서 대문자로 바뀌었는지 기록해주는 기능
					if(Pattern.matches("[a-zA-Z]", Character.toString(alpha))) {// 문자를 문자열로 변환해서 알파벳인지 판단
						if(Character.toString(alpha).equals(Character.toString(alpha).toLowerCase())) {//alpha가 대 소문자를 판단
							alpha -= 32;//즉 alpha를 대문자로 바꿔서 하겠다는 의미임
							lower = true;
						}
						alpha = (char) ((int) alpha - key); 
						if(!Pattern.matches("[A-Z]", Character.toString(alpha))) {
							alpha += 26;
						}
						if(lower) {
							alpha += 32;//대문자를 소문자로 바꾸었으니 다시 되돌려야함
						}
					}
					str.append(alpha);
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
	

	public int setEncrypted(StringBuilder str, File outputFile) {
		Random ran = new Random();
		int key = ran.nextInt(25) + 1;

		StringBuffer sb = new StringBuffer();
		try (FileWriter fw = new FileWriter(outputFile);
				BufferedWriter bw = new BufferedWriter(fw)){

			for (int i = 0; i < str.length(); i++) {
				char alpha;
				Boolean upper = false;//알파벳이 대문자에서 소문자로 바뀌었는지 기록해주는 기능
				if (Pattern.matches("[a-zA-Z]", Character.toString(str.charAt(i)))) {// 문자를 문자열로 변환해서 알파벳인지 판단
					alpha = str.charAt(i);
					if(Character.toString(alpha).equals(Character.toString(alpha).toUpperCase())) {//alpha가 대문자인지 판단
						alpha += 32;//즉 alpha를 소문자로 바꿔서 하겠다는 의미임
						upper = true;
					}
					
					alpha += (char) key;
					if (!Pattern.matches("[a-z]", Character.toString(alpha))) {
						alpha -= 26;
					}
					if(upper) {
						alpha -= 32;//대문자를 소문자로 바꾸었으니 다시 되돌려야함
					}
				} else {
					alpha = str.charAt(i);
				}
				sb.append(alpha);
			}
			bw.append(sb);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
	
	//abcdefghijklmnopqrstuvwxyz
}








