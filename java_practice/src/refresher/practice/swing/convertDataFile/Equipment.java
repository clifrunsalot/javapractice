package refresher.practice.swing.convertDataFile;

import java.io.PrintWriter;
import java.util.StringTokenizer;

class Equipment {
	Equipment() {
	}

	public String getShoeModel() {
		return shoeModel;
	}

	public String getShoeSize() {
		return shoeSize;
	}

	public void setShoeModel(String model) {
		shoeModel = model;
	}

	public void setShoeSize(String size) {
		shoeSize = size;
	}

	public void readData(StringTokenizer t) {
		setShoeSize(t.nextToken());
		setShoeModel(t.nextToken());
	}

	public void print(PrintWriter f) {
		f.print(shoeSize + "|");
		f.print(shoeModel + "|");
	}

	protected String shoeModel = "*";
	protected String shoeSize = "*";
}// ~class Equipment...
