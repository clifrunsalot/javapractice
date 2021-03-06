package refresher.practice.swing.comboboxes_spinners;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 * Defines a model for doubles.
 */
public class DoubleComboBoxModel implements ComboBoxModel {

	public DoubleComboBoxModel(double s, double e) {
		start = s;
		end = e;
		list = new Vector();
		NumberFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);

		for (double i = start; i < end + 0.1; i += 0.1) {
			list.add((String) nf.format(i));
		}
	}

	public Object getSelectedItem() {
		return (Object) item;
	}

	public void setSelectedItem(Object anItem) {
		item = anItem;
	}

	public void addListDataListener(ListDataListener l) {

	}

	public Object getElementAt(int index) {
		return (Object) list.elementAt(index);
	}

	public int getSize() {
		return list.size();
	}

	public void removeListDataListener(ListDataListener l) {

	}

	private double start;
	private double end;
	private Object item;
	private Vector list;
}
