package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_BorderLayout extends JFrame{
	public S02_BorderLayout() {
		//X버튼을 눌렀을 때의 동작 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 프레임을 보이게 성정
		setVisible(true);
		
		// 프레임의 크기 설정
		setSize(600, 600);
		
		//위치 설정
		setLocation(200, 50);
		
		//이 프레임의 레이아웃 설정
		setLayout(new BorderLayout());
		//레이아웃 설정 후 추가
		JButton quit_btn = new JButton("Quit");
		JButton save_btn = new JButton("Save");
		JButton load_btn = new JButton("Load");
		JButton delete_btn = new JButton("Delete");
		JButton update_btn = new JButton("Update");
		quit_btn.setFont(new Font("궁서체", Font.BOLD, 35));
		
		
		
		
		//버튼에 이벤트를 추가
		quit_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//해당 컴포넌트에 action 발생시 e로 이벤트 당시의 정보가 넘어온다
				System.out.println("눌린것 정보 1 : " +e.getActionCommand());
				System.out.println("눌린것 정보 2 : " +e.getID());
				System.out.println("눌린것 정보 3 : " +e.getModifiers());
				System.out.println("눌린것 정보 4 : " +e.getWhen());
				System.out.println("눌린것 정보 5 : " +e.getClass());
				System.out.println("눌린것 정보 6 : " +e.getSource());
				
				((JButton) e.getSource()).setText("눌렸음");
			}
		});
		
		save_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PopMenuExam pm = new PopMenuExam();
//				((JButton) e.getSource()).add(popup);;
				
				
			}
		});
		
		add(save_btn, BorderLayout.CENTER);
		add(load_btn, BorderLayout.EAST);
		add(delete_btn, BorderLayout.WEST);
		add(update_btn, BorderLayout.NORTH);
		add(quit_btn, BorderLayout.SOUTH);
		
		
		
		
	}
	
	public static void main(String[] args) {
		new S02_BorderLayout();
	}
}


class PopMenuExam extends Frame{
	
	
	public PopMenuExam() {
		PopupMenu pm = new PopupMenu();
		MenuItem pm_item1 = new MenuItem("hi");
		pm.add(pm_item1);
		
		add(pm);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
}
