package myinterface;

import myobj.Homework_0405.Ink;
import myobj.Homework_0405.Laser;

class TestPrint{
	public static void main(String[] args) {
		PrintDoIt print = new PrintDoIt();
		Laser la = new Laser();
		Ink ink = new Ink();
		print.setPrint(la);
		print.doItPrint("���г���", 4);
		
		print.setPrint(ink);
		print.doItPrint("�����", 3);
	}
}