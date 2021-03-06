package refresher.practice.swing.comboboxes_spinners;

import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 * Defines a model for a time format of hh:mm:ss.
 */
public class TimeComboBoxModel implements ComboBoxModel {

	public TimeComboBoxModel() {
		list = new Vector();
		String hrs = "00";
		String mins = "00";
		String secs = "00";

		for (int h = 0; h < 24; h++) {
			if (h < 10) {
				hrs = "0" + h;
			} else {
				hrs = "" + h;
			}

			for (int m = 0; m < 60; m++) {
				if (m < 10) {
					mins = "0" + m;
				} else {
					mins = "" + m;
				}

				for (int s = 0; s < 60; s++) {
					if (s < 10) {
						secs = "0" + s;
					} else {
						secs = "" + s;
					}
					list.add(hrs + ":" + mins + ":" + secs);
				}
			}
		}
	}

	public Object getSelectedItem() {
		return (Object) item;
	}

	public void setSelectedItem(Object anItem) {
		item = (String) anItem;
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

	private String item;
	private Vector list;
}
