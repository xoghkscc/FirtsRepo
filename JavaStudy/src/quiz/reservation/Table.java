package quiz.reservation;

import java.util.ArrayList;

class Table implements Comparable<Table>{
	int tableNum;
	int startDay, starthour, endDay;
	int userhour;
	int endhour;
	ArrayList<Integer> usehour = new ArrayList<Integer>();
	String name;
	String phoneNum;
	final int dayOfHour = 24;
	
	public Table(int tableNum, String phoneNum, String name, int startDay, int starthour, int userhour) {
		this.tableNum = tableNum;
		this.userhour = userhour;
		this.phoneNum = phoneNum;
		this.name = name;
		this.startDay = startDay;
		this.starthour = starthour;
		this.endhour =starthour + userhour;
		for(int idx=starthour; idx<endhour; idx++) {
			usehour.add(idx);
		}
		this.endDay = this.startDay;
		
		while(true) {
			if(endhour >= dayOfHour) {
				endhour -= dayOfHour;
				endDay++;
			}
			if(endhour < dayOfHour) {
				break;
			}
		}
	}
	
	public void showReservation(String phoneNum, String name) {
		if(this.phoneNum.equals(phoneNum) && this.name.equals(name)) {
			System.out.println("------------------------------------------------");
			System.out.printf("입력하신 정보에 대한 예약이 존재합니다.\n");
			System.out.printf("[%d일 %d시부터 %d일 %d시까지 입니다.]\n", startDay, starthour, endDay, endhour);
			System.out.println("------------------------------------------------");
		}else {
			System.out.println("------------------------------------------------");
			System.err.println("해당하는 정보는 존재하지 않습니다.");
			System.out.println("------------------------------------------------");
		}
	}
	
	@Override
	public String toString() {
		String contents = String.format("[%d번 테이블 %d일 %d시부터 %d일 %d시까지 입니다.]",tableNum, startDay, starthour, endDay, endhour);
		return contents;
	}
	@Override
	public int compareTo(Table o) {
		if(this.startDay < o.startDay) {
			return -1;
		} else if(this.startDay > o.startDay) {
			return 1;
		} else if(this.startDay == o.startDay) {
			
			if(this.starthour < o.starthour) {
				return -1;
			}else if(this.starthour > o.starthour) {
				return +1;
			}else if(this.starthour == o.starthour) {
				return (this.tableNum<o.tableNum ? -1 : +1);
			}
		}
		return 0;
	}
	
	public boolean checkTable(int startDay, int starthour, int userhour) {
		boolean isTf;
		ArrayList<Integer> checkhour = new ArrayList<Integer>();
		for(int idx=Math.max(starthour, this.starthour); idx<Math.min(starthour +userhour, this.endhour); idx++) {
			checkhour.add(idx);
		}
		if(this.startDay == startDay) {
			checkhour.retainAll(usehour);
			isTf = true;
			System.out.println("------------------------------------------------");
			System.out.println(tableNum+"테이블과 중복됩니다. ");
			System.out.println(tableNum+"번 테이블과 중복되는 시간은 : "+checkhour+"입니다.");
			System.out.println("------------------------------------------------");
		}else {
			isTf =false;
		}
		return isTf;
	}

	
}
