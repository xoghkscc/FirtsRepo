package swing.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import swing.S03_JButton;

public class S02_ActionTest implements ActionListener{
	ArrayList<JButton> btns;
	public S02_ActionTest(ArrayList<JButton> btns) {
		this.btns = btns;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(JButton btn : btns) {
			btn.setText("" + (int)(Math.random() * 45 + 1));
		}
		
		((JButton)e.getSource()).setText("한번 더 뽑기!");
		
	}

}
