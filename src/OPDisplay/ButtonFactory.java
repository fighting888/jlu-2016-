package OPDisplay;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class ButtonFactory {

    private static ButtonFactory buttonFactory = new ButtonFactory();

    public static ButtonFactory getButtonFactory() {
        return buttonFactory;
    }

    public JButton makeButton(int x, int y, int width, int height, String title) {
        JButton button = new JButton(title);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        return button;
    }
}
