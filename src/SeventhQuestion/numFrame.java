package SeventhQuestion;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class numFrame extends JFrame {


	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private double[] num = {7, 8 , 10, 20, 30, 40, 1, 2, 3, 4, 5, 6};
	
	public numPanel nPanel = new numPanel();

	public static void main(String[] args) {
		JFrame frame = new numFrame();
	}

	public numFrame() {
		setTitle("Table Frame");
		setBounds(500, 0, 1000, screenSize.height-100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(nPanel);
		changeNum(num);
	}
	
	public void changeNum(double[] num) {
		numPanel.setNum(num);
		nPanel.repaint();
		System.out.println("change Number done");
	}
}
