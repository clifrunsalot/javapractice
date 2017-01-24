package refresher.practice.swing.convertDataFile;

import java.io.PrintWriter;
import java.util.StringTokenizer;

class Bike extends Equipment {
	Bike() {
	}

	public String getBikeFrameSize() {
		return bikeFrameSize;
	}

	public String getBikeModel() {
		return bikeModel;
	}

	public String getBikeName() {
		return bikeName;
	}

	public String getBikeTireSize() {
		return bikeTireSize;
	}

	public String getBikeSN() {
		return bikeSN;
	}

	public String getSeatPostDiameter() {
		return seatPostDiameter;
	}

	public void setBikeFrameSize(String bSize) {
		bikeFrameSize = bSize;
	}

	public void setBikeModel(String bModel) {
		bikeModel = bModel;
	}

	public void setBikeName(String bName) {
		bikeName = bName;
	}

	public void setBikeTireSize(String bTireSize) {
		bikeTireSize = bTireSize;
	}

	public void setBikeSN(String bSN) {
		bikeSN = bSN;
	}

	public void setSeatPostDiameter(String bDiameter) {
		seatPostDiameter = bDiameter;
	}

	public void readData(StringTokenizer t) {
		super.readData(t);
		setBikeFrameSize(t.nextToken());
		setBikeModel(t.nextToken());
		setBikeName(t.nextToken());
		setBikeTireSize(t.nextToken());
		setBikeSN(t.nextToken());
		setSeatPostDiameter(t.nextToken());
	}// ~public void readData(Str...

	public void print(PrintWriter f) {
		f.print("equipbike" + "|");
		super.print(f);
		f.print(getBikeFrameSize() + "|");
		f.print(getBikeModel() + "|");
		f.print(getBikeName() + "|");
		f.print(getBikeTireSize() + "|");
		f.print(getBikeSN() + "|");
		f.print(getSeatPostDiameter() + "|");
	}// ~public void print(PrintW...

	private String bikeFrameSize = "*";
	private String bikeModel = "*";
	private String bikeName = "*";
	private String bikeSN = "*";
	private String bikeTireSize = "*";
	private String seatPostDiameter = "*";

}// ~class Bike extends Equip...
