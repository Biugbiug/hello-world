package awardproject.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class awardView extends JFrame {
	JTextArea textArea = null;
	JTextArea textArea_1 = null;
	JButton button = null;
	private JPanel contentPane;
	int i = 2;
	int count = 0;
	String name = "停止";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    awardView frame = new awardView();
		frame.setVisible(true);
		frame.showId();
	}

	/**
	 * Create the frame.
	 */
	public awardView() {
		setTitle("抽奖系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("抽取的号码为");
		label.setFont(new Font("华文中宋", Font.BOLD, 27));
		label.setBackground(Color.RED);
		label.setBounds(131, 10, 232, 65);
		contentPane.add(label);
		
	    textArea = new JTextArea(1,1);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 35));
		textArea.setBounds(86, 57, 259, 65);
		contentPane.add(textArea);
		
	    textArea_1 = new JTextArea(1,1);
		textArea_1.setRows(1);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 35));
		textArea_1.setBounds(159, 132, 111, 41);
		contentPane.add(textArea_1);
		
		  button = new JButton(name);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					count++;
				}
			});
			button.setFont(new Font("宋体", Font.BOLD, 18));
			button.setBounds(159, 202, 111, 49);
		    contentPane.add(button);
	}
	
	public void showId(){
		List list = null;
		list = excelEvent.getExcel("F://信计花名册.xls");
		while(true) {
			textArea.setText("");
			textArea_1.setText("");
		    int i =(int) (Math.random() * 50 - 9);
		    i = Math.abs(i);
			
		    try {
			String A = list.get(i).toString();
			String B = list.get(i + 41).toString();
			textArea.append(A);
			textArea_1.append(B);
			if(count % 2 == 0) {
				name = "开始";
				Thread.sleep(50);}
			else {
				name = "停止";
				Thread.sleep(5000);
				 }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
				/*if(stopThread()) {
				Thread.interrupted();
				}*/
			
		}
		}
	/*public boolean stopThread() {
	
	 return flag;
		
	}*/
	
}
	
	/*public static int stop(int i) {
		return i;
	}
	
	public static boolean A() {
		return flag;
	}
	*/
