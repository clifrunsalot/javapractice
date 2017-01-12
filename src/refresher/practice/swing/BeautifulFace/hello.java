package refresher.practice.swing.BeautifulFace;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	MyPanel(String s) {
		myString = s;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font f = new Font("SansSerif", Font.BOLD, 20);
		g.setFont(f);
		g.drawString(myString, 10, 75);

	}

	private String myString;
}

class BeautifulFace extends JFrame {
	BeautifulFace() {
		contentPane = getContentPane();
		setTitle("New Look");
		setSize(300, 150);
		panel = new MyPanel("Yeah Baby! I'm sooo sexy!");
		label = new JLabel("Option:");
		comboBox = new JComboBox();
		comboBox.addItem("first");
		comboBox.addItem("second");
		checkBox = new JCheckBox("Option:");

		panel.add(label);
		panel.add(comboBox);
		panel.add(checkBox);
		contentPane.add(panel);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private Container contentPane;
	private JPanel panel;
	private JLabel label;
	private JComboBox comboBox;
	private JCheckBox checkBox;
}

public class hello {
	public static void main(String[] args) {
		JFrame look = new BeautifulFace();
		look.setVisible(true);
	}
}
