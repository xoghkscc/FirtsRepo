

public class B05_TypeCasting {
	public static void main(String[] args) {
		byte _byte = 127;
		int _int;		
		float _folat;
		long _long;
		short _short;
		
		_int = _byte;
		_int = 210000000;
		_long = _int;
		_folat = _long;
//		System.out.println(_folat);
		
		
		_int = 50000;
		_short = (short)_int;
//		System.out.println(_short);
		
		int a = 80;
		char ch = 'z';
		
		System.out.println((char)a);
		System.out.println(a);
		
		System.out.println((int)ch);
		System.out.println(ch);
	}
}
