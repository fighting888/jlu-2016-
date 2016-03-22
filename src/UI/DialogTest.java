package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DialogTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static dialog dia;

	public static void main(String[] args) {
		final JFrame frame = new JFrame("dialogtest");
		frame.setVisible(true);
		frame.setBounds(0, 0, 500, 500);
		JButton button = new JButton("dialog");
		frame.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					dia = new dialog(frame);
					dia.setVisible(true);
				
				
			}
		});
	}
}

class dialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public dialog(JFrame owner) {
		super(owner, "dialog Test", true);
		final JTextArea textArea = new JTextArea("test");
		add(new JLabel("TEST!!"));
		add(textArea);
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				System.out.println(textArea.getText());
			}
		});
		
		JPanel panel = new JPanel();


		panel.add(ok);
		add(panel, BorderLayout.SOUTH);
		pack();
	}
}
