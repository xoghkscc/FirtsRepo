package quiz;

import java.util.Scanner;

public class B05_1_ConditionQuiz2 {
	/*
    [ ¾Ë¸ÂÀº Á¶°Ç½ÄÀ» ¸¸µé¾îº¸¼¼¿ä ]

    1. charÇü º¯¼ö a°¡ 'q'¶Ç´Â 'Q'ÀÏ ¶§ true
       2. charÇü º¯¼ö b°¡ °ø¹éÀÌ³ª ÅÇÀÌ ¾Æ´Ò ¶§ true
    3. charÇü º¯¼ö c°¡ ¹®ÀÚ('0' ~ '9')ÀÏ ¶§ true
    4. charÇü º¯¼ö d°¡ ¿µ¹®ÀÚ(´ë¹®ÀÚ ¶Ç´Â ¼Ò¹®ÀÚ)ÀÏ ¶§ true
    5. charÇü º¯¼ö e°¡ ÇÑ±ÛÀÏ ¶§ true
    6. charÇü º¯¼ö f°¡ ÀÏº»¾îÀÏ ¶§ true    
    7. »ç¿ëÀÚ°¡ ÀÔ·ÂÇÑ ¹®ÀÚ¿­ÀÌ exitÀÏ ¶§ true    
*/
	public static void main(String[] args) {
		char a='q', b='%', c='3', d='C', e='¤É', f='d';
		 
		Scanner sc = new Scanner(System.in);
		String str;
		
		System.out.printf("¹®ÀÚ¿­À» ÀÔ·ÂÇÏ¼¼¿ä : ");
		str = sc.next();
		
		System.out.println("1 : " + ((a == 'q') || (a == 'Q')));
		System.out.println("2 : " + ((b != '\t') && (b != ' ')));
		System.out.println("3 : " + (c >= '0' && c <= '9'));
		System.out.println("4 : " + ((d>'A' && d<'Z') || (d>'a' && d<'z')));
		System.out.println("5 : " + ((e>='¤¡' && e<='ÆR')));
		System.out.println("6 : " + ((f>=0x3040 && f<=0x309F) || (f>=0x30A0 && f<=0x30FF) ));
		System.out.println("7 : " + str.equals("exit"));
		
	}
} 