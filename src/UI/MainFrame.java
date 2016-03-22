package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import SecondQuestion.*;
import UI.inputDialog;

import javax.swing.*;

public class MainFrame extends JFrame {
	
	public static int getEDGESIZE() {
		return EDGESIZE;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static inputDialog input;

	protected static List<Integer> keyValues = new ArrayList<Integer>();
	
	private static int GRAPHSIZE = 0;
	
	private static int EDGESIZE = 0;
	
	private static int[] tempx = new int[2];

	private static int[] tempy = new int[2];
	
	protected static int[] tempVertex = new int[2];
	
	static int STATUS = -1;  // Drawing Status 0 for rectangle ;1 for line;
	
	public static graphListWithUI gUI = new graphListWithUI();
	
	public static int getGraphsize() {
		return GRAPHSIZE;
	}

	
	public int getGRAPHSIZE() {
		return GRAPHSIZE;
	}


	public void setGRAPHSIZE(int gRAPHSIZE) {
		GRAPHSIZE = gRAPHSIZE;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final JFrame mainFrame = new JFrame("TEST DRAWING");
		final DrawPanel contentPanel = new DrawPanel();
		contentPanel.setBounds(5, 5, 1000, 900);
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		JMenuItem aboutItem = new JMenuItem("about");
		fileMenu.add(aboutItem);
		contentPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (STATUS == 0) {
					++GRAPHSIZE;
					contentPanel.repaint();
					//创建vertex列表
					SecondQuestion.Vertex vertex = new Vertex();
					vertex.VerName = GRAPHSIZE - 1;
					vertex.setX(arg0.getX());
					vertex.setY(arg0.getY());
					gUI.vertexs.add(vertex);
				} 
				STATUS = -1;
				System.out.println("(" + arg0.getX() + "," + arg0.getY() + ")");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				tempx[0] = arg0.getX();
				tempy[0] = arg0.getY();
				System.out.println("Mouse Pressed : (" + arg0.getX() + "," + arg0.getY() + ")   ");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				tempx[1] = arg0.getX();
				tempy[1] = arg0.getY();
				int x1 = vertexName(tempx[0], tempy[0]);
				int x2 = vertexName(tempx[1], tempy[1]);
				
				if (x1 != x2 && x1 != -1 && x2 != -1) {
					// 在vertex的adjacent中插入或者后面的链表插入！！！	
					SecondQuestion.Edge edge = new Edge();
					edge.link = null;
					edge.VerAdj = x2;
					edge.setStx(tempx[0]);
					edge.setSty(tempy[0]);
					edge.setEnx(arg0.getX());
					edge.setEny(arg0.getY());
					
					++EDGESIZE;
					input = new inputDialog(mainFrame);
					input.setVisible(true);
					
					edge.cost = keyValues.get(EDGESIZE - 1);
					gUI.insertPost(gUI.vertexs.get(x1), edge);
					gUI.edges.add(edge);
					System.out.println("Mouse Released : (" + arg0.getX() + "," + arg0.getY() + ")  edgesize : " + EDGESIZE);
				}
				contentPanel.repaint();
			
			}
		});
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel.setLayout(null);
		mainFrame.add(contentPanel);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setBounds(0, 0, 1000, 1000);
	}

	public static int vertexName(int x, int y) {
		for (int i = 0;i < GRAPHSIZE; i++) {
			if (checkSize(x, gUI.getVertexs().get(i).getX()) && checkSize(y, gUI.getVertexs().get(i).getY())) {
				System.out.println("第" + i + "个Vertex");
				return i;
			}
		}
		return -1;
	}
	
	
	public static boolean checkSize(int x1, int x2) {
		return ((x1 <= x2 + 60) && (x1 >= x2 - 60)) ? true : false;
	}
}


