import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myobj.MyScanner;

public class D09_Regex {
	public static void main(String[] args) {
		
		//Pattern.matches(regex, input) : inputÀÌ regex¿¡ ¸ÅÄ¡µÇ´Â ¹®ÀÚ¿­ÀÎÁö¸¦ °Ë»çÇØÁÖ´Â ¸Ş¼­µå
//		System.out.println(Pattern.matches("sleep", "sleEp"));
//		
//		// 
//		System.out.println(Pattern.matches("s[lh@]eep", "sleep"));//ture
//		System.out.println(Pattern.matches("s[lh@]eep", "sheep"));//ture
//		System.out.println(Pattern.matches("s[^lh@]eep", "s@eep"));//false
//		System.out.println(Pattern.matches("s[0-9a-z]eep", "s2eep"));//true 0~9, a~z±îÁö Çã¿ë
//		System.out.println(Pattern.matches("s[a-d && c-f]eep", "sceep"));//true 
//		System.out.println(Pattern.matches("s[a-d && c-f]eep", "seeep"));//false 
//		
//		
//		
//		System.out.println(Pattern.matches("s.eep", "sheep"));//true // ¸ğµç¹®ÀÚ
//		System.out.println(Pattern.matches("s[.]eep", "sheep"));//false // .¸¸ Çã¿ë
//		System.out.println(Pattern.matches("s\\.eep", "sheep"));//false // .¸¸ Çã¿ë
//		 
//		
//		System.out.println(Pattern.matches("s\\deep", "s9eep"));//true // ¸ğµç¼ıÀÚ
//		
//		System.out.println(Pattern.matches("\\D\\D\\D", "¤ºat"));//true // ¸ğµç ¹®ÀÚ
//		
//		System.out.println(Pattern.matches("s\\seep", "s eep"));//true // °ø¹é¸¸ Çã¿ë
//		System.out.println(Pattern.matches("s\\Seep", "s eep"));//true // °ø¹éºñÇã¿ë
//		System.out.println(Pattern.matches("s\\weep", "s_eep"));//true // °ø¹éºñÇã¿ë
		
		
//		Pattern instance = Pattern.compile("[0-9]@[0-9]");
		
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "cat"));//false(5±ÛÀÚ µÇ¾î¾ßÇÔ)
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "c3a4t"));//true
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "34534"));//true
//		System.out.println(Pattern.matches("[\\D3-5]{5}", "34531"));//false(¼ıÀÚ´Â 3-5¸¸)
		
//		String name = "ng4$3";
//		System.out.println("sad :" +Pattern.matches("[\\D3-5]{2,5}", name));//true
//		System.out.println(Pattern.matches("[\\D3-5]{2,5}", "345d31"));//false(±ÛÀÚ¼ö´Â 2~5)
//		
//		String regex1 = String.format(".{%d,}\\.txt", 2);
//		System.out.println(Pattern.matches(regex1, "abdc.txt"));//true
//		
//		System.out.println(Pattern.matches("[°¡-ÆR]{2,}", "¾È³çÇÏ¼¼¿ä"));//true
//		System.out.println(Pattern.matches("[°¡-ÆR]{4,}", "¾È³ç¿ä"));//false(±ÛÀÚ¼ö´Â 4°³ ÀÌ»ó)
//		
//		System.out.println(Pattern.matches("[°¡-ÆR]?\\.txt", ".txt"));//true (\\.Àº .ÀÌ ÀÖ¾î¾ßÇÑ´Ù´Â ÀÇ¹Ì)
//		System.out.println(Pattern.matches("[°¡-ÆR]?\\.txt", "ÇÑ.txt"));//true
//		System.out.println(Pattern.matches("[°¡-ÆR]?\\.txt", "ÇÑ±Û.txt"));//false(°¡-ÆRÀº ¸¹¾Æ¾ß 1¹ø ³ª¿Í¾ßÇÔ)
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "01012341234"));//true
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "0101234134"));//true
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "010-1234-4134"));//true
//		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}", "010-123-4134"));//true
//		
//		
//		//ÀÚ¹Ù¿¡¼­ Çã¿ëÇÏ´Â º¯¼ö¸íÀ» °Ë»çÇÒ ¼ö ÀÖ´Â Á¤±ÔÇ¥Çö½Ä(Ã¹¹øÂ° ±ÛÀÚ´Â ¼ıÀÚ x, °ø¹é x, Æ¯¼ö¹®ÀÚ´Â _, $¸¸)
//		System.out.println(Pattern.matches("[\\D&&($\\w)][$\\w]*", "$fsd"));
//		//							Ã¹¹øÂ°´Â ¼ıÀÚx $,ÀÏ¹İÀûÀÎ ¹®ÀÚ µÎ¹øÂ°ºÎÅÍ´Â $, ÀÏ¹İÀûÀÎ ¹®ÀÚÀÓ
//		
//		
//		String fruit_text = "apple/banana/orange/grape/pineapple/peach/mango/redapple";
//		Pattern regex = Pattern.compile("/");
//		String[] fruits = regex.split(fruit_text);
//		System.out.println(Arrays.toString(fruits));
//		
//		Pattern regex3 = Pattern.compile("[a-zA-Z]");//¾ËÆÄºªÀ» Ã£¾ÆÁÜ
//		Pattern regex2 = Pattern.compile("apple");//appleÀÌ µÇ´Â °ÍµéÀ» Ã£¾ÆÁÜ
//		Matcher matcher =  regex2.matcher(fruit_text);
//		System.out.println(fruit_text);
//		while(matcher.find()){
//			System.out.println("Ã£Àº°Í : "+matcher.group());
//			System.out.println("À§Ä¡ : "+matcher.start() + "ºÎÅÍ" + matcher.end());
//		}
//	¼ıÀÚ, ¹®ÀÚ, Æ¯¼ö¹®ÀÚ¸¦ È¥ÇÕ ±¸¼ºÇÏ°í 2Á¾·ù ÀÌ»óÀÇ ¹®ÀÚ¸¦ Á¶ÇÕ 8ÀÚÀÌ»ó 16ÀÚ ÀÌÇÏ
		String regex = "(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*_]).{8,16}";
	
		while(true) {
			String input2=MyScanner.input("ºñ¹Ğ¹øÈ£ ÀÔ·Â>>");
		System.out.println(Pattern.matches(regex, input2));
		}
	}
}
