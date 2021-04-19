package myinterface;

import myobj.Homework_0405.Ink;
import myobj.Homework_0405.Laser;

public interface Print_0405 {
	void print(String contents, int num);
}


class PrintDoIt{
	Print_0405 printer;
	
	public void setPrint(Print_0405 printer) {
		this.printer = printer;
	}
	
	public void doItPrint(String contents, int num) {
		printer.print(contents, num);
	}
}

