package SeventhQuestion;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Stack;

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

		if (num != null) {
			for (int i = 0;i < num.length; i++) {
				start = start + 30;

				Rectangle2D rectangle2d = new Rectangle2D.Double(start, height-num[i] * 5, width, num[i] * 5);
                if (i % 2 == 0) {
                    graphics2d.setPaint(Color.ORANGE);
                } else if (i % 3 == 0) {
                    graphics2d.setPaint(Color.red);
                } else {
                    graphics2d.setPaint(Color.green);
                }
				graphics2d.fill(rectangle2d);
                graphics2d.setPaint(Color.black);
				graphics2d.drawString(String.valueOf(num[i]), (int)start+5, (int)height+30);
			}
		}

        System.out.println("paint done");
    }

    public static void setNum(double[] n) {
		num = n;
	}


}
