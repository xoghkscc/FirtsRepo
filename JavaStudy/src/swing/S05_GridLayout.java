package swing;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S05_GridLayout extends MyFrame{
	public S05_GridLayout() {
		setLayout(new GridLayout(2, 5, 15, 5));
		ArrayList<JButton> btns = new ArrayList<JButton>();
		for(int  i =0; i<14; i++) {
			btns.add(new JButton("Button"+i));
		}
		
		for (JButton btn : btns) {
			add(btn);
		}
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new S05_GridLayout();
	}
}
