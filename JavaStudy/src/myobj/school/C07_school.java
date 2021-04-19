package myobj.school;

public class C07_school {
	public static void main(String[] args) {
		NetworkStudent[] network = new NetworkStudent[30];
		int sno=100000;
		for (int i = 0; i < 30; i++) {
			sno++;
			network[i] = new NetworkStudent(sno);
			network[i].showGrade();
		}
	}
}
