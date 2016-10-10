package OPDisplay.util;

import javax.swing.*;

/**
 * Created by PurpleWall on 2016/9/19.
 */
public class JTextFactory {

    private static JTextFactory jTextFactory = new JTextFactory();

    /**
     * 制作生成输入框
     * @param x
     * @param y
     * @param width
     * @param height
     * @param text:需要默认显示的文本
     * @return
     */
    public JTextArea makeTextArea(int x, int y, int width, int height, String text) {
        JTextArea area = new JTextArea();
        area.setBounds(x, y, width, height);
        if (text != null) {
            area.setText(text);
        }
        return area;
    }

    public JTextField makeTextField(int x, int y, int width, int height, String text) {
        JTextField field = new JTextField();
        field.setBounds(x, y, width, height);
        if (text != null) {
            field.setText(text);
        }
        return field;
    }

    public static JTextFactory getjTextFactory() {
        return jTextFactory;
    }
}
