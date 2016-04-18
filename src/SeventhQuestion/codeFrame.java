package SeventhQuestion;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PurpleWall on 2016/4/15.
 */
public class codeFrame extends JFrame {

    private codePanel contentPanel = new codePanel();

    public codeFrame() {
        this.setBounds(1500, 0, 500, 1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(contentPanel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                codeFrame frame = new codeFrame();
            }
        });

    }


}

class codePanel extends  JPanel{

    private JLabel[] codes = new JLabel[15];

    public codePanel() {
        this.setLayout(new GridLayout(15,1));
        this.setBounds(0, 0, 500, 1000);
        codes[0] = addLine("if (left < right) {");
        codes[1] = addLine("    int mid = partition(list2, left, right);");
        codes[2] = addLine("    if (left < mid - 1) {");
        codes[3] = addLine("        stack.push(left);  stack.push(right-1);}");
        codes[4] = addLine("    if (mid + 1 < right) {");
        codes[5] = addLine("        stack.push(mid + 1);stack.push(right);}");
        codes[6] = addLine("    while (!stack.isEmpty()) {");
        codes[7] = addLine("        int q = stack.peek();stack.pop();");
        codes[8] = addLine("        int p = stack.peek();stack.pop();");
        codes[9] = addLine("        mid = partition(list2, p, q);");
        codes[10] = addLine("       if (p < mid - 1) {");
        codes[11] = addLine("           stack.push(p);stack.push(mid - 1);}");
        codes[12] = addLine("       if (q > mid + 1) {");
        codes[13] = addLine("           stack.push(mid + 1);stack.push(q);}");
        codes[14] = addLine("}");
    }

    public JLabel addLine(String code) {
        JLabel label = new JLabel(code);
        label.setFont(new Font("微软雅黑", Font.BOLD, 20));
        this.add(label);
        return label;
    }
}
