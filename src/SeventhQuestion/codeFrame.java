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

    public void addColor(int x) {
        contentPanel.addColor(x);
    }

    public void resumeColor(int x) {
        contentPanel.resumeColor(x);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                codeFrame frame = new codeFrame();
                frame.addColor(5);
                frame.addColor(7);
                frame.addColor(6);
                frame.resumeColor(6);
            }
        });

    }


    public void transColor(int x) {
        try {
            addColor(x);
            Thread.sleep(200L);
            resumeColor(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class codePanel extends  JPanel{

    private JLabel[] codes = new JLabel[15];

    public codePanel() {
        this.setLayout(new GridLayout(15,1));
        this.setBounds(0, 0, 500, 1000);
        codes[0] = addLine("1 if (left < right) {");
        codes[1] = addLine("2    int mid = partition(list2, left, right);");
        codes[2] = addLine("3    if (left < mid - 1) {");
        codes[3] = addLine("4        stack.push(left);  stack.push(right-1);}");
        codes[4] = addLine("5    if (mid + 1 < right) {");
        codes[5] = addLine("6        stack.push(mid + 1);stack.push(right);}");
        codes[6] = addLine("7    while (!stack.isEmpty()) {");
        codes[7] = addLine("8        int q = stack.peek();stack.pop();");
        codes[8] = addLine("9        int p = stack.peek();stack.pop();");
        codes[9] = addLine("10       mid = partition(list2, p, q);");
        codes[10] = addLine("11      if (p < mid - 1) {");
        codes[11] = addLine("12         stack.push(p);stack.push(mid - 1);}");
        codes[12] = addLine("13      if (q > mid + 1) {");
        codes[13] = addLine("14          stack.push(mid + 1);stack.push(q);}");
        codes[14] = addLine("15 }");
    }

    public JLabel addLine(String code) {
        JLabel label = new JLabel(code);
        label.setFont(new Font("微软雅黑", Font.BOLD, 20));
        this.add(label);
        return label;
    }

    public void addColor(int x) {
        codes[x].setForeground(Color.orange);
    }

    public void resumeColor(int x) {
        codes[x].setForeground(Color.black);
    }

}
