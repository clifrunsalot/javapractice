package refresher.practice.swing.comboboxes_spinners;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class ComboBoxTest extends JFrame {
	public ComboBoxTest() {
		super("ComboBox Test");
		container = getContentPane();

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 200));

		doubleComboBox = new JComboBox(new DoubleComboBoxModel(0.0, 500.0));
		doubleComboBox.setSelectedIndex(0);
		doubleTextField = new JTextField(doubleComboBox.getItemAt(0).toString(), 10);

		integerComboBox = new JComboBox(new IntegerComboBoxModel(1, 500));
		integerComboBox.setSelectedIndex(0);
		integerTextField = new JTextField(integerComboBox.getItemAt(0).toString(), 10);

		timeComboBox = new JComboBox(new TimeComboBoxModel());
		timeComboBox.setSelectedIndex(0);
		timeTextField = new JTextField(timeComboBox.getItemAt(0).toString(), 10);

		dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dateTextField = new JFormattedTextField(dateFormatter);
		dateTextField.setValue(new Date());

		doubleComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doubleTextField.setText(doubleComboBox.getSelectedItem().toString());
			}
		});

		integerComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				integerTextField.setText(integerComboBox.getSelectedItem().toString());
			}
		});

		timeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeTextField.setText(timeComboBox.getSelectedItem().toString());
			}
		});

		dateSpinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor de = new JSpinner.DateEditor(dateSpinner, "MM/dd/yy");
		dateSpinner.setEditor(de);

		dateSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				dateTextField.setValue(dateSpinner.getValue());
			}
		});

		panel.add(doubleComboBox);
		panel.add(doubleTextField);
		panel.add(integerComboBox);
		panel.add(integerTextField);
		panel.add(timeComboBox);
		panel.add(timeTextField);
		panel.add(dateSpinner);
		panel.add(dateTextField);

		container.add(panel);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private Container container;
	private JPanel panel;
	private JComboBox doubleComboBox;
	private JComboBox integerComboBox;
	private JComboBox timeComboBox;
	private JTextField doubleTextField;
	private JTextField integerTextField;
	private JTextField timeTextField;
	private JFormattedTextField dateTextField;
	private JSpinner dateSpinner;
	private DateFormat dateFormatter;
}

public class test {
	public static void main(String[] args) {
		ComboBoxTest cbt = new ComboBoxTest();
		cbt.pack();
		cbt.setVisible(true);
	}
}
