package src.UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import src.SecondQuestion.Edge;
import src.SecondQuestion.Vertex;

public class DrawPanel extends JPanel {

	public JLabel getDrawLabel() {
		return statusLabel;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel statusLabel = new JLabel("STATUS LABEL");
	
	private JLabel DrawLabel = new JLabel("STATUS : ");

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		graphics2d.setStroke(new BasicStroke(3f));
		
		for (int i = 0;i < MainFrame.getGraphsize(); i++) {
			int x = MainFrame.gUI.getVertexs().get(i).getX();
			int y = MainFrame.gUI.getVertexs().get(i).getY();
			Rectangle2D rectangle2d = new Rectangle2D.Double(x - 30, y - 30, 60, 60);
			graphics2d.draw(rectangle2d);
			graphics2d.drawString(String.valueOf(i), x, y);
		}
		
	
		
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
		
		for (Vertex vertex : MainFrame.gUI.highLightVertexs) {
			Rectangle2D rectangle2d = new Rectangle2D.Double(vertex.getX() - 30, vertex.getY() - 30, 60, 60);
			graphics2d.setPaint(new Color(200, 50, 0));
			graphics2d.fill(rectangle2d);
			graphics2d.setPaint(new Color(255, 255, 255));
			graphics2d.drawString(String.valueOf(vertex.getVerName()), vertex.getX(), vertex.getY());
		}
		
		for (Edge edge : MainFrame.gUI.highLightEdge) {
			int x1 = edge.getStx();
			int y1 = edge.getSty();
			int x2 = edge.getEnx();
			int y2 = edge.getEny();
			if (!(x1 == x2 && y1== y2)) {
				graphics2d.setPaint(new Color(0, 50, 200));
				graphics2d.drawLine(x1, y1, x2, y2);
				Ellipse2D ellipse2d = new Ellipse2D.Double(x2, y2, 10, 10);
				graphics2d.fill(ellipse2d);
				graphics2d.drawString(String.valueOf(edge.cost), (x1 + x2)/2, (y1 + y2)/2);
			}
		}		
	}
	
	public DrawPanel() {
		JButton DRect = new JButton("DRAW RECTANGLES");
		JButton DLine = new JButton("DRAW LINES");
		JButton Generate = new JButton("Critical");
		statusLabel.setBounds(200, 0, 500, 160);
		statusLabel.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		DrawLabel.setBounds(100, 0, 100, 160);
		DrawLabel.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		Generate.setBounds(800, 500, 160, 60);
		DRect.setBounds(800, 100, 160, 60);
		DRect.setMnemonic(java.awt.event.KeyEvent.VK_R);
		Generate.setMnemonic(java.awt.event.KeyEvent.VK_G);
		DRect.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.STATUS = 0;
				statusLabel.setText("Drawing Rectangles ");
			}
			
		});
		
		DLine.setBounds(800, 300, 160, 60);
		DLine.setMnemonic(java.awt.event.KeyEvent.VK_L);
		DLine.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.STATUS = 1;
				statusLabel.setText("Drawing Lines ");
			}
			
		});
		Generate.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!MainFrame.gUI.isClose(MainFrame.getGraphsize())) {
					MainFrame.gUI.printGraph();
					MainFrame.gUI.CriticalPath();
					statusLabel.setText("»æÖÆ¹Ø¼üÂ·¾¶");
					repaint();
				} else {
					statusLabel.setText("»ØÂ·±ÕºÏ£¬ÇëÖØÐÂ¹¹½¨");
					System.out.println("»ØÂ·±ÕºÏ£¬ÇëÖØÐÂ¹¹½¨");
				}				
			}
			
		});

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem clearItem = new JMenuItem("clear");
		fileMenu.add(clearItem);
		fileMenu.addSeparator();
		JMenuItem exitItem = new JMenuItem("exit");
		fileMenu.add(exitItem);
		fileMenu.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		clearItem.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		exitItem.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.BOLD, 20));
		clearItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearPanel();
			}
		});
		
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		add(DRect);
		add(DLine);
		add(Generate);
		add(statusLabel);
		add(DrawLabel);
		MainFrame.mainFrame.setJMenuBar(menuBar);
	}
	
	public void clearPanel() {
		MainFrame.gUI.edges.clear();
		MainFrame.gUI.vertexs.clear();
		MainFrame.keyValues.clear();
		MainFrame.gUI.highLightVertexs.clear();
		MainFrame.gUI.highLightEdge.clear();
		MainFrame.setGRAPHSIZE(0);
		MainFrame.setEDGESIZE(0);
		statusLabel.setText("²Á³ýÖØ»æÖÐ...");
		repaint();
	}

}
