package refresher.practice.swing.final_Tewl;

/** T.E.W.L - Triathlon Electronic Workout Log
* Copyright 2002 by Clifton B. Hudson
* Purpose: Electronic exercise log with a file database *
* File: RecordDialog.java
*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class RecordDialog extends JFrame {
	public RecordDialog(Workout w) {
		d = new Debug();
		this.setName("recordDialog");

		localWorkout = new Workout();
		localWorkout = w;

		myModel = new RecordTableModel(localWorkout);
		table = new JTable(myModel);

		table.setPreferredScrollableViewportSize(new Dimension(400, 135));
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(425);

		// Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(table);

		summaryLabel = new JLabel("Summary");

		summaryTextArea = new JTextArea();
		summaryTextArea = new JTextArea(4, 45);
		summaryTextArea.setLineWrap(true);
		summaryTextArea.setWrapStyleWord(true);
		summaryTextArea.setEditable(false);
		summaryScrollPane = new JScrollPane(summaryTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		summaryTextArea.insert("", 0);

		p = new JPanel(new BorderLayout());
		p.add(scrollPane, BorderLayout.NORTH);
		p.add(summaryLabel, BorderLayout.CENTER);
		p.add(summaryScrollPane, BorderLayout.SOUTH);
		getContentPane().add(p);
		setResizable(false);
	}

	public void refreshTable(Workout w) {
		myModel = new RecordTableModel(w);
		table.setModel(myModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(425);
		summaryTextArea.setText(w.getSummary());
	}

	public void windowClosing(WindowEvent we) {
	}

	public void windowOpened(WindowEvent we) {
	}

	public void windowIconified(WindowEvent we) {
	}

	public void windowDeiconified(WindowEvent we) {
	}

	public void windowClosed(WindowEvent we) {
	}

	public void windowActivated(WindowEvent we) {
	}

	public void windowDeactivated(WindowEvent we) {
	}

	private Debug d;
	private Workout localWorkout;
	private JScrollPane scrollPane, summaryScrollPane;
	private RecordTableModel myModel;
	private JTable table;
	private JPanel p;
	private JTextArea summaryTextArea;
	private JLabel summaryLabel;

}// ~class RecordDialog exten...
