package swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class S03_JButton extends JFrame{
	
	
	public S03_JButton() {
		JButton btn1 = new JButton("눌러보세요");
		setLayout(null);
		add(btn1);
		
		btn1.setBounds(100, 100, 400, 200);
		
		btn1.setEnabled(true);
		
		btn1.setBackground(new Color(199, 111, 124));
		
		btn1.setIcon(new ImageIcon());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(200, 50);
		setSize(600, 600);
		
		
		
	}
	
	public static void main(String[] args) {
		new S03_JButton();
	}
}
