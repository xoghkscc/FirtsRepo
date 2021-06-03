package swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S01_JavaSwing {
	public static void main(String[] args) {
		//frame.setLocation(2200, 50);
		
		JFrame frame = new JFrame();
		JButton btn1 = new JButton("This is button");
		
		frame.add(btn1);
		btn1.setLocation(100, 100);
		btn1.setSize(200, 50);
		
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
}
