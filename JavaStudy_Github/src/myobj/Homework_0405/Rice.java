package myobj.Homework_0405;

import myinterface.Shopping_0405;

public class Rice implements Shopping_0405 {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "½Ò";
	}

	@Override
	public int price() {
		// TODO Auto-generated method stub
		return 50000;
	}

	@Override
	public String origin() {
		// TODO Auto-generated method stub
		return "korea";
	}

	@Override
	public int calorie() {
		// TODO Auto-generated method stub
		return 400;
	}

}
