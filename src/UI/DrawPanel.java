package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		
		// Drawing rectangles
		for (int i = 0;i < MainFrame.getGraphsize(); i++) {
			int x = MainFrame.gUI.getVertexs().get(i).getX();
			int y = MainFrame.gUI.getVertexs().get(i).getY();
			Rectangle2D rectangle2d = new Rectangle2D.Double(x - 30, y - 30, 60, 60);
			graphics2d.draw(rectangle2d);
			graphics2d.drawString(String.valueOf(i), x, y);
		}
		
		//��Drawing lines
		
		for (int i = 0;i < MainFrame.getEDGESIZE(); ++i) {
			int x1 = MainFrame.gUI.getEdges().get(i).getStx();
			int y1 = MainFrame.gUI.getEdges().get(i).getSty();
			int x2 = MainFrame.gUI.getEdges().get(i).getEnx();
			int y2 = MainFrame.gUI.getEdges().get(i).getEny();
			if (!(x1 == x2 && y1== y2)) {
				graphics2d.drawLine(x1, y1, x2, y2);
				graphics2d.drawOval(x2, y2, 10, 10);
				graphics2d.drawString(String.valueOf(MainFrame.keyValues.get(i)), (x1 + x2)/2, (y1 + y2)/2);
			}
		}
		
		
	}
	
	public DrawPanel() {
		JButton DRect = new JButton("DRAW RECTANGLES");
		JButton DLine = new JButton("DRAW LINES");
		JButton Generate = new JButton("Critical");
		Generate.setBounds(800, 500, 160, 60);
		DRect.setBounds(800, 100, 160, 60);
		DRect.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.STATUS = 0;
			}
			
		});
		
		DLine.setBounds(800, 300, 160, 60);
		DLine.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.STATUS = 1;
			}
			
		});
		Generate.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.gUI.printGraph();
				MainFrame.gUI.CriticalPath();
			}
			
		});
		add(DRect);
		add(DLine);
		add(Generate);
	}
	
	
	

}
