package myinterface;

import myobj.remote.AirConRemocon;
import myobj.remote.Televisioncon;

//�������̽��� ���� ���յ��� ���� �ڵ带 �ۼ��� �� �ִ�.
public class TestRemocon {
	public static void main(String[] args) {
		test(new AirConRemocon());
		test(new Televisioncon());
	} 
	
	public static void test(Remocon remocon) {
		remocon.power();
		remocon.up(1);
		remocon.down(1);
		remocon.change();
	}
	
	
	
}
