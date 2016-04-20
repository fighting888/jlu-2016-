package SeventhQuestion;

import javax.swing.*;
import java.awt.*;

/**
 * Created by PurpleWall on 2016/4/20.
 */
public class MainFrame extends JFrame {

    static double[] list = {7, 8 , 10, 20, 30, 40, 1, 2, 3, 4, 5, 6};

    public numPanel nPanel;

    private static stackFrame sFrame;

    private inputFrame iFrame;

    private static codeFrame cFrame;

    public static QuickSort qSort = new QuickSort();

    private JPanel panel = new JPanel(new GridLayout(1,2));


    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,1000, 800);
        setVisible(true);
//        this.add(nPanel);
        this.add(iFrame);
//        setContentPane(panel);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }
}
