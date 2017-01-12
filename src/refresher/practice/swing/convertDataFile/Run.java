package refresher.practice.swing.convertDataFile;

import java.io.PrintWriter;
import java.util.StringTokenizer;

class Run extends Equipment {
	Run() {
	}

	public void readData(StringTokenizer t) {
		super.readData(t);
	}

	public void print(PrintWriter f) {
		f.print("equiprun" + "|");
		super.print(f);
	}
}// ~class Run extends Equipm...
