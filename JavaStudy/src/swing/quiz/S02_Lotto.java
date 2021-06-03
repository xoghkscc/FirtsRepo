package swing.quiz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.layout.Border;

public class S02_Lotto extends JFrame {
	public S02_Lotto() {
		ArrayList<Integer> ran = new ArrayList<Integer>();
		for (int i = 1; i < 7; i++) {
			ran.add(i);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 600);
		setLocation(200, 50);
		setLayout(null);

		JButton ran_btn = new JButton("뽑기");

		JButton[] btnArr = { new JButton("1 : " + ran.get(0)), new JButton("2 : " + ran.get(1)),
				new JButton("3 : " + ran.get(2)), new JButton("4 : " + ran.get(3)),
				new JButton("5 : " + ran.get(4)), new JButton("6 : " + ran.get(5)) };

		ran_btn.setLocation(200, 300);
		ran_btn.setSize(100, 100);
		add(ran_btn);

		int x = 100;
		int y = 100;

		for (int i = 0; i < btnArr.length; i++) {
			btnArr[i].setLocation(x, y);
			btnArr[i].setSize(100, 50);
			if (x == 300) {
				x = 0;
				y = 200;
			}
			x += 100;
			add(btnArr[i]);
		}

		ran_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(ran);
				for (int i = 0; i < btnArr.length; i++) {
					btnArr[i].setText("" + ran.get(i));
				}

			}
		});

	}

	public static void main(String[] args) {
		new S02_Lotto();
	}
}
