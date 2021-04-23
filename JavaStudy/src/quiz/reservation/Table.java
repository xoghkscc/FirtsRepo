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
			System.out.printf("�Է��Ͻ� ������ ���� ������ �����մϴ�.\n");
			System.out.printf("[%d�� %d�ú��� %d�� %d�ñ��� �Դϴ�.]\n", startDay, starthour, endDay, endhour);
			System.out.println("------------------------------------------------");
		}else {
			System.out.println("------------------------------------------------");
			System.err.println("�ش��ϴ� ������ �������� �ʽ��ϴ�.");
			System.out.println("------------------------------------------------");
		}
	}
	
	@Override
	public String toString() {
		String contents = String.format("[%d�� ���̺� %d�� %d�ú��� %d�� %d�ñ��� �Դϴ�.]",tableNum, startDay, starthour, endDay, endhour);
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
			System.out.println(tableNum+"���̺�� �ߺ��˴ϴ�. ");
			System.out.println(tableNum+"�� ���̺�� �ߺ��Ǵ� �ð��� : "+checkhour+"�Դϴ�.");
			System.out.println("------------------------------------------------");
		}else {
			isTf =false;
		}
		return isTf;
	}

	
}
