package swing.quiz;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class S02_NextButton extends JButton{
	ArrayList<JButton> btns;
public S02_NextButton(int x, int y, ArrayList<JButton> btns) {
	super("뽑기");
	
	this.btns = btns;
	setSize(800, 50);
	setLocation(new Point(x, y));
}
	

}