package SeventhQuestion;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PurpleWall on 2016/4/15.
 */
public class codeFrame extends JFrame {

    private JLabel[] codes = new JLabel[26];

    public codeFrame

    public void setText(JLabel label, String code) {
        label.setText(code);
        label.setFont(new Font("微软雅黑", Font.BOLD, 13));
    }
}
