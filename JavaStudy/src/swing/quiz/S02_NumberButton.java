package swing.quiz;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class S02_NumberButton extends JButton{
	public S02_NumberButton(int x, int y) {
		super("0");
		
		setSize(80, 80);
		setLocation(new Point(x, y));
	}

}
