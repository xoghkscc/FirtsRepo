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
	// #"frankenstein.txt"�� ��ü ������ 1 ~ 25 ������ ���� Ű�� ��ȣȭ��
	// "frankenstein.encrypted.txt�� �����غ�����.(�� ���ĺ��� ��ȣȭ �� ��)
	public static void main(String[] args) {
		File inputFile = new File("./note/txt2/frankenstein.txt");
		File outputFile = new File("./note/txt2/frankenstein.encrypted.txt");
		
		E08_CaesarCipher2 cipher = new E08_CaesarCipher2();
		StringBuilder str, str2;
		str = cipher.getFileStr(inputFile);// ���Ͽ� �ִ� ������ ���ڿ��� �޾ƿ��� �޼���
		int key = cipher.setEncrypted(str, outputFile);// ���ڿ��� �ѱ�� ��ȣȭ�� �°� ������ ��ȯ�� ������ ����� �޼���(���� KEY�� ��ȯ)
		str2 = cipher.getFileStr(outputFile, key);
		System.out.println("��ȣȭ �� �ؽ�Ʈ ������ : "+str);
		System.out.println("�������� ���� Ű �� :" + key);
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
					Boolean lower = false;//���ĺ��� �ҹ��ڿ��� �빮�ڷ� �ٲ������ ������ִ� ���
					if(Pattern.matches("[a-zA-Z]", Character.toString(alpha))) {// ���ڸ� ���ڿ��� ��ȯ�ؼ� ���ĺ����� �Ǵ�
						if(Character.toString(alpha).equals(Character.toString(alpha).toLowerCase())) {//alpha�� �� �ҹ��ڸ� �Ǵ�
							alpha -= 32;//�� alpha�� �빮�ڷ� �ٲ㼭 �ϰڴٴ� �ǹ���
							lower = true;
						}
						alpha = (char) ((int) alpha - key); 
						if(!Pattern.matches("[A-Z]", Character.toString(alpha))) {
							alpha += 26;
						}
						if(lower) {
							alpha += 32;//�빮�ڸ� �ҹ��ڷ� �ٲپ����� �ٽ� �ǵ�������
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
				Boolean upper = false;//���ĺ��� �빮�ڿ��� �ҹ��ڷ� �ٲ������ ������ִ� ���
				if (Pattern.matches("[a-zA-Z]", Character.toString(str.charAt(i)))) {// ���ڸ� ���ڿ��� ��ȯ�ؼ� ���ĺ����� �Ǵ�
					alpha = str.charAt(i);
					if(Character.toString(alpha).equals(Character.toString(alpha).toUpperCase())) {//alpha�� �빮������ �Ǵ�
						alpha += 32;//�� alpha�� �ҹ��ڷ� �ٲ㼭 �ϰڴٴ� �ǹ���
						upper = true;
					}
					
					alpha += (char) key;
					if (!Pattern.matches("[a-z]", Character.toString(alpha))) {
						alpha -= 26;
					}
					if(upper) {
						alpha -= 32;//�빮�ڸ� �ҹ��ڷ� �ٲپ����� �ٽ� �ǵ�������
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








