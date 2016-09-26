package OPDisplay;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class JLableFactory {

    private static JLableFactory jLableFactory = new JLableFactory();

    public static JLableFactory getjLableFactory() {
        return jLableFactory;
    }

    /**
     *
     * @param x
     * @param y
     * @param font
     * @param content
     * @return
     */
    public JLabel makeLable(int x, int y, int font, String content) {
        JLabel label = new JLabel(content);
        label.setBounds(x, y, 60, 20);
        label.setFont(new Font("微软雅黑", Font.BOLD, font));
        return label;
    }
}
