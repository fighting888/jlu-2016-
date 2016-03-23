package src.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class inputDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public inputDialog(JFrame owner) {
		super(owner, "dialog Test", true);
		final JTextArea textArea = new JTextArea();
		add(new JLabel("输入边的权值"), BorderLayout.CENTER);
		add(textArea);
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isInteger(textArea.getText())) {
					setVisible(false);
					MainFrame.keyValues.add(Integer.valueOf(textArea.getText()));
					System.out.println(textArea.getText());
				} else {
					textArea.setText("输入错误请重新输入");
				}
			}
		});

		JPanel panel = new JPanel();


		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		pack();
	}
	
	public boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}
	}
}
