package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import javafx.scene.layout.Border;

public class S06_JPanel extends MyFrame{
	JPanel main_panel;
	JPanel sub_pannel;
	
	public S06_JPanel() {
		
		setLayout(new BorderLayout(3, 3));
		
		ArrayList<JButton> main_panel_btns = new ArrayList<JButton>();
		ArrayList<JButton> sub_panel_btns = new ArrayList<JButton>();
		
		for(int  i = 0; i < 4; i++) {
			main_panel_btns.add(new JButton("Button"+i));
		}
		
		main_panel = new JPanel();
		sub_pannel = new JPanel();
		
		main_panel.setLayout(new GridLayout(2, 2, 15, 5));
		main_panel.add(main_panel_btns.get(0));
		main_panel.add(main_panel_btns.get(1));
		main_panel.add(main_panel_btns.get(2));
		main_panel.add(main_panel_btns.get(3));
		
		sub_pannel.setLayout(new GridLayout(5, 2, 15, 5));
		for(int  i = 0; i < 10; i++) {
			sub_panel_btns.add(new JButton("Sub"+i));
			sub_pannel.add(sub_panel_btns.get(i));
		}
		
		
		add(main_panel, BorderLayout.CENTER);
		add(sub_pannel, BorderLayout.WEST);
		add(new JButton("Hello!"), BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new S06_JPanel();
	}
}
