package swing.quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_LottoTea extends JFrame {
	public S02_LottoTea() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 600);
		setLocation(200, 50);
		setLayout(null);
		
		ArrayList<JButton> list = new ArrayList<JButton>();
		JButton nextBtn = new S02_NextButton(100, 300, list);
		nextBtn.addActionListener(new S02_ActionTest(list));
		add(nextBtn);
		list.add(new S02_NumberButton(100, 100));
		list.add(new S02_NumberButton(190, 100));
		list.add(new S02_NumberButton(280, 100));
		list.add(new S02_NumberButton(370, 100));
		list.add(new S02_NumberButton(460, 100));
		list.add(new S02_NumberButton(550, 100));
		
		for(JButton btn : list) {
			add(btn);
		}
		
	}

	public static void main(String[] args) {
		new S02_LottoTea();
	}
}
