package SecondQuestion;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawTest1 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int[] t;
	
	static ContentPanel panel = new ContentPanel();
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("666");
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				System.out.println("7878");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ContentPanel.list.add(e.getX());
				System.out.println("(" + e.getX() + "," + e.getY() + ")");
			}
			
		});
	
		frame.setVisible(true);
		frame.setSize(1100, 900);
		frame.setContentPane(panel);
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}


class ContentPanel extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static List<Integer> list = new ArrayList<>();
	
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		
		for (Integer l : list) {
			Rectangle2D rectangle2d = new Rectangle2D.Double(l, l, 20, 20);
			graphics2d.draw(rectangle2d);
			graphics2d.drawString("ssss", l, l);
		}
		
		
		
	}
	
	public ContentPanel() {
		setLayout(null);
		setBounds(10, 10, 1100, 800);
		JButton button = new JButton("TEST");
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				repaint();
				System.out.println(true);
			}
			 
		});
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		button.setBounds(832, 85, 174, 91);
		add(button);
	}
		
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}