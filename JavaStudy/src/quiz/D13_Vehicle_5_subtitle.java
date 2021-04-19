package quiz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myobj.MyScanner;

public class D13_Vehicle_5_subtitle {
	String todayWeekend = weekend();
	HashMap<String, int[]> endNumber;

	public D13_Vehicle_5_subtitle(Car mycar) {
		ArrayList<String> exceptType = new ArrayList<String>();
		Collections.addAll(exceptType, "LightCar", "Disabled", "InfantRide");
		if (exceptType.contains(mycar.getCarType())) {
			System.out.println("당신의 차량은 " + mycar.getCarType() + "이므로 제외차량입니다. 금일 운행 가능합니다.");
			return;
		}
		if (checkWeeknd(mycar)) {
			System.out.printf("오늘은 %s입니다. 당신의 차 번호는 %s이므로 운행이 가능합니다.", todayWeekend, mycar.getNumber());
		} else {
			System.out.printf("오늘은 %s입니다. 당신의 차량은 " + mycar.getCarType()+"이며 차 번호는 %s이므로 운행이 불가능합니다.", todayWeekend, mycar.getNumber());
		}
	}

	public boolean checkWeeknd(Car mycar) {
		int endNum = mycar.getNumber() % 10;
		int[] mon = {1, 6};
		int[] tue = {2, 7};
		int[] wed = {3, 8};
		int[] thu = {4, 9};
		int[] fri = {5, 0};
		endNumber = new HashMap<String, int[]>();
		endNumber.put("MONDAY", mon);
		endNumber.put("TUESDAY", tue);
		endNumber.put("WEDNESDAY", wed);
		endNumber.put("THURSDAY", thu);
		endNumber.put("FRIDAY", fri);

		for (Entry<String, int[]> entry : endNumber.entrySet()) {
			if (todayWeekend.equals(entry.getKey())) {
				for (int i = 0; i < entry.getValue().length; i++) {
					if (endNum == entry.getValue()[i]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public String weekend() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("오늘 날짜를 기준으로 추가할 date를 쓰세요 (테스트용, 0을 기입 시 today기준>>");
		int plusDay = sc.nextInt();
		LocalDate today = LocalDate.now().plusDays(plusDay);// 테스트용이며 테스트 하기 싫을 시 주석처리
//		LocalDate today = LocalDate.now();테스트를 위해 주석처리
		return today.getDayOfWeek().name();
	}

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.testCar(); // 테스트용이며 테스트 하기 싫을 시 주석처리
		D13_Vehicle_5_subtitle vs = new D13_Vehicle_5_subtitle(myCar);
	}
}

class Car {
	Random ran;
	private int number;
	ArrayList<String> vehicleType = new ArrayList<String>();
	private String carType;

	public Car() {
		ran = new Random();
		this.number = ran.nextInt(9000) + 1000;// 1000~9999 실제용
		Collections.addAll(vehicleType, "LightCar", "Disabled", "InfantRide", "MidsizeCar", "LargeCar", "Sedan", "SemiMediumCar");
		// 앞에 3개는 경차, 유아동승, 장애인차이므로 제외 뒤에 4개는 중형차, 대형차, 세단, 준중형차라서 차량 5부제에 걸림

		this.carType = vehicleType.get(ran.nextInt(7)); // 실제용
		System.out.printf("나의 차량 종류 :%s 번호 :%d\n", carType, number);
	}

	public void testCar() {
		while(true) {
			int inputNum = MyScanner.inputInt("차량 번호를 입력>> ");
			if(Pattern.matches("[\\d]{4}", ""+inputNum)) {
				this.number = inputNum;
				break;
			}else {
				System.out.println("차량 번호는 1000~9999까지 숫자입니다.");
			}
		}
		switch (MyScanner.inputInt("1번 : 제외차량, 2번 : 일반 차량>>")) {
		case 1:
			this.carType = vehicleType.get(0);// 테스트용
			break;
		case 2:
			this.carType = vehicleType.get(3);// 테스트용
			break;
		default:
			break;
		}
	}

	public int getNumber() {
		return number;
	}

	public String getCarType() {
		return carType;
	}

}
