package SeventhQuestion;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class numPanel extends JPanel {

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private static double[] num;
	
	double start = 0;
	
	private final double height = screenSize.height-300;
	
	private static final double width = 30;
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		start = 0;

		Graphics2D graphics2d = (Graphics2D) graphics;
		
		graphics2d.setFont(new Font("微软雅黑", Font.BOLD, 10));
		
		graphics2d.setStroke(new BasicStroke(3f));

		for (int i = 0;i < num.length; i++) {
			start = start + 30;
			Rectangle2D rectangle2d = new Rectangle2D.Double(start, height-num[i] * 5, width, num[i] * 5);
			graphics2d.draw(rectangle2d);
			graphics2d.drawString(String.valueOf(num[i]), (int)start+5, (int)height+30);
        }

        System.out.println("paint done");
    }

    public static void setNum(double[] n) {
		num = n;
	}



}
