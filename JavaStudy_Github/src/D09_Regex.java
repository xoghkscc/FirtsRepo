import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myobj.MyScanner;

public class D09_Regex {
	public static void main(String[] args) {
		
		//Pattern.matches(regex, input) : input�� regex�� ��ġ�Ǵ� ���ڿ������� �˻����ִ� �޼���
//		System.out.println(Pattern.matches("sleep", "sleEp"));
//		
//		// 
//		System.out.println(Pattern.matches("s[lh@]eep", "sleep"));//ture
//		System.out.println(Pattern.matches("s[lh@]eep", "sheep"));//ture
//		System.out.println(Pattern.matches("s[^lh@]eep", "s@eep"));//false
//		System.out.println(Pattern.matches("s[0-9a-z]eep", "s2eep"));//true 0~9, a~z���� ���
//		System.out.println(Pattern.matches("s[a-d && c-f]eep", "sceep"));//true 
//		System.out.println(Pattern.matches("s[a-d && c-f]eep", "seeep"));//false 
//		
//		
//		
//		System.out.println(Pattern.matches("s.eep", "sheep"));//true // ��繮��
//		System.out.println(Pattern.matches("s[.]eep", "sheep"));//false // .�� ���
//		System.out.println(Pattern.matches("s\\.eep", "sheep"));//false // .�� ���
//		 
//		
//		System.out.println(Pattern.matches("s\\deep", "s9eep"));//true // ������
//		
//		System.out.println(Pattern.matches("\\D\\D\\D", "��at"));//true // ��� ����
//		
//		System.out.println(Pattern.matches("s\\seep", "s eep"));//true // ���鸸 ���
//		System.out.println(Pattern.matches("s\\Seep", "s eep"));//true // ��������
//		System.out.println(Pattern.matches("s\\weep", "s_eep"));//true // ��������
		
		
//		Pattern instance = Pattern.compile("[0-9]@[0-9]");
		
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "cat"));//false(5���� �Ǿ����)
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "c3a4t"));//true
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "34534"));//true
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "34531"));//false(���ڴ� 3-5��)
		
//		String name = "ng4$3";
//		System.out.println("sad :" +Pattern.matches("[\\D3-5]{2,5}", name));//true
//		System.out.println(Pattern.matches("[\\D3-5]{2,5}", "345d31"));//false(���ڼ��� 2~5)
//		
//		String regex1 = String.format(".{%d,}\\.txt", 2);
//		System.out.println(Pattern.matches(regex1, "abdc.txt"));//true
//		
//		System.out.println(Pattern.matches("[��-�R]{2,}", "�ȳ��ϼ���"));//true
//		System.out.println(Pattern.matches("[��-�R]{4,}", "�ȳ��"));//false(���ڼ��� 4�� �̻�)
//		
//		System.out.println(Pattern.matches("[��-�R]?\\.txt", ".txt"));//true (\\.�� .�� �־���Ѵٴ� �ǹ�)
//		System.out.println(Pattern.matches("[��-�R]?\\.txt", "��.txt"));//true
//		System.out.println(Pattern.matches("[��-�R]?\\.txt", "�ѱ�.txt"));//false(��-�R�� ���ƾ� 1�� ���;���)
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "01012341234"));//true
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "0101234134"));//true
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "010-1234-4134"));//true
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "010-123-4134"));//true
//		
//		
//		//�ڹٿ��� ����ϴ� �������� �˻��� �� �ִ� ����ǥ����(ù��° ���ڴ� ���� x, ���� x, Ư�����ڴ� _, $��)
//		System.out.println(Pattern.matches("[\\D&&($\\w)][$\\w]*", "$fsd"));
//		//							ù��°�� ����x $,�Ϲ����� ���� �ι�°���ʹ� $, �Ϲ����� ������
//		
//		
//		String fruit_text = "apple/banana/orange/grape/pineapple/peach/mango/redapple";
//		Pattern regex = Pattern.compile("/");
//		String[] fruits = regex.split(fruit_text);
//		System.out.println(Arrays.toString(fruits));
//		
//		Pattern regex3 = Pattern.compile("[a-zA-Z]");//���ĺ��� ã����
//		Pattern regex2 = Pattern.compile("apple");//apple�� �Ǵ� �͵��� ã����
//		Matcher matcher =  regex2.matcher(fruit_text);
//		System.out.println(fruit_text);
//		while(matcher.find()){
//			System.out.println("ã���� : "+matcher.group());
//			System.out.println("��ġ : "+matcher.start() + "����" + matcher.end());
//		}
//	����, ����, Ư�����ڸ� ȥ�� �����ϰ� 2���� �̻��� ���ڸ� ���� 8���̻� 16�� ����
		String regex = "(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*_]).{8,16}";
	
		while(true) {
			String input2=MyScanner.input("��й�ȣ �Է�>>");
		System.out.println(Pattern.matches(regex, input2));
		}
	}
}
