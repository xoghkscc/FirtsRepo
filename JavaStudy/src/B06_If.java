
public class B06_If {
	public static void main(String[] args) {
		
		int a = 10;
		
		if(a < 5) {
			System.out.println("hello");
		}else if(a<15) {
			System.out.println("¾È´¨");			
		}else if(a>0) {
			System.out.println("´ë¹Ú");
		}
		
		char ch = '$';
		
		if(ch >='°¡' && ch <= 'ÆR') {
			System.out.println("ch¿¡ µé¾îÀÖ´Â °ªÀº ÇÑ±ÛÀÔ´Ï´Ù." + ch);
		} else if(ch>='a' && ch <= 'z') {
			System.out.println("ch´Â ¿µ¾î´Ù" + ch);
		}
		
		else {
			System.out.println("ch¿¡ µé¾îÀÖ´Â °ªÀº ÇÑ±ÛÀÌ ¾Æ´Õ´Ï´Ù." + ch);
		}
		
	} 

}
