package SecondQuestion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseDemo extends JFrame implements MouseListener,
		MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int flag; //flag=1����Mouse Moved,flag=2����Mouse Dragged
	int x = 0;
	int y = 0;
	int startx, starty, endx, endy;//��ʼ�������յ�����
	public MouseDemo() {
		Container contentPane = getContentPane();
		contentPane.addMouseListener(this);
		contentPane.addMouseMotionListener(this);
		setSize(300, 300);
	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	/*��mousePressed(),mouseReleased()ȡ�������ҷ�Ŀ�ʼ���������*/
	public void mousePressed(MouseEvent e) {
		startx = e.getX();
		starty = e.getY();
	}
	public void mouseReleased(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	/*mouseMoved(),mouseDragged()ȡ������ƶ���ÿһ�����꣬������repaint()����*/
	public void mouseMoved(MouseEvent e) {
		flag = 1;
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		flag = 2;
		x = e.getX();
		y = e.getY();
		repaint();
	}
	public void update(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, getWidth(), getHeight()); //�����ǰ�Ĵ�������
		paint(g);
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		if (flag == 1) {
			g.drawString("������꣺(" + x + "," + y + ")", 10, 50);
			g.drawLine(startx, starty, endx, endy);
		}
		if (flag == 2) {
			g.drawString("��ҷ�������꣺(" + x + "," + y + ")", 10, 50);
			g.drawLine(startx, starty, x, y);
		}
	}
	public static void main(String[] args) {
		new MouseDemo();
	}
}
