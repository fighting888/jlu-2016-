package SeventhQuestion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import static SeventhQuestion.QuickSort.*;

public class inputFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    private JTextArea array = addTextArea();

    private JPanel buttonPanel = new JPanel();

    private JButton generate = addButton("Generate");

    private JButton submit = addButton("Submit");

	public inputFrame() {
		setTitle("input number spilte with space");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(buttonPanel, BorderLayout.SOUTH);
        submit.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent arg0) {

                for (double l : qSort.list) {
                    System.out.println(l);
                }

                QuickSort.frame.changeNum(qSort.list);

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(QuickSort.qSort.getList().length + "    origin list");

                QuickSort.qSort.quickSort(qSort.setList(submitArray()), 0, submitArray().length-1);

            }

        });

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] strings = array.getText().split(" ");
                QuickSort.qSort.list = new double[strings.length];
                for (int i = 0;i < strings.length; ++i)	{
                    qSort.list[i] = Integer.parseInt(strings[i]);
                }
                frame.changeNum(list);
            }
        });
	}

    public JTextArea addTextArea() {
        JTextArea tArea = new JTextArea();
        tArea.setText("input numbers");
        tArea.setFont(new Font("微软雅黑", Font.BOLD, 25));
        this.add(tArea, BorderLayout.CENTER);
        return tArea;
    }

    public JButton addButton(String name) {
        JButton button = new JButton(name);
        button.setFont(new Font("微软雅黑", Font.BOLD, 25));
        buttonPanel.add(button);
        return button;
    }

    public double[] submitArray() {
        return qSort.list;
    }

}
