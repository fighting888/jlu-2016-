package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawTest2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0, 0, 500, 500);
		panel panel = new panel();
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(arg0.getX() + " " + arg0.getY());
			}
			
		});
		panel.setBounds(1, 1 , 490, 490);
		frame.add(panel);
	}
}

class panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		int[] x = new int[3];
		int[] y = new int[3];
		x[0] = 0;
		y[0] = 0;
		x[1] = 200;
		y[1] = 200;
		x[2] = 0;
		y[2] = 300;
		graphics2d.drawPolygon(x, y, 3);
	}
}