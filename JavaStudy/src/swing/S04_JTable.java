package swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class S04_JTable extends JFrame{
	
	public S04_JTable() {
		setLayout(new BorderLayout());
		
		String[][] data = {
			{"100", "Smith", "3500", "10"},
			{"101", "King", "4500", "30"},
			{"102", "Steve", "50000", "10"},
			{"103", "Ryo", "30", "10"},
		};
		
		String[] column = {"ID", "NAME", "SALARY", "DEPTNO"};
		
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		JScrollPane scrollpane = new JScrollPane(table);
		add(scrollpane);
		model.setColumnIdentifiers(column);//테이블의 컬럼을 추가
		model.addRow(data[0]);//테이블에 데이터를 추가 Object[]타입임
		model.addRow(data[2]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		model.addRow(data[3]);
		
		add(table, BorderLayout.CENTER);
		add(new JButton("Hello, Swing!"), BorderLayout.SOUTH);
		add(new JButton("Hello, Swing!"), BorderLayout.NORTH);
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				super.componentResized(e);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 600, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S04_JTable();
	}
}
