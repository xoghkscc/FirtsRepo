package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class S07_CardLayout extends MyFrame {
	
	Container main = getContentPane();
	
	public S07_CardLayout() {
		JPanel main = new JPanel();
		add(main);
		setLayout(new BorderLayout());
		
		JPanel center = new JPanel();
		
		JLabel label1 = new JLabel("Hello!");
		JLabel label2 = new JLabel("Nice to meet you!");
		JLabel label3 = new JLabel("Good bye!");
		
		center.setLayout(new CardLayout(5, 5));
		center.add("card1",label1);
		center.add("card2", label2);
		center.add("card3", label3);
		
		JPanel south = new JPanel();
		
		JButton prev = new JButton("<");
		JButton next = new JButton(">");
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout)center.getLayout();
				card.next(center);
				//다음 카드로 넘기기 (레이아웃이 설정된 컨테이너의 인스턴스가 필요)
			}
		});
		
		south.setLayout(new GridLayout(1, 2));
		south.add(prev);
		south.add(next);
		
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		main.setVisible(true);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S07_CardLayout();
	}
}
