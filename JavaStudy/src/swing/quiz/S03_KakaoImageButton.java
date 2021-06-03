package swing.quiz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S03_KakaoImageButton extends JFrame{
	public S03_KakaoImageButton() {
		ArrayList<JButton> btns = new ArrayList<JButton>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocation(200, 50);
		setLayout(null);
		btns.add(new S03_KakaoImageInsert(0, 100, 300, 152, 152));
		btns.add(new S03_KakaoImageInsert(1, 100, 450, 152, 152));
		btns.add(new S03_KakaoImageInsert(2, 300, 100, 152, 152));
		btns.add(new S03_KakaoImageInsert(3, 450, 100, 152, 152));
		add(btns.get(0));
		add(btns.get(1));
		add(btns.get(2));
		add(btns.get(3));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S03_KakaoImageButton();
	}
}
