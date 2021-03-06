package refresher.practice.swing.comboboxes_spinners;

import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Defines an event and organizes its data according to name, distance, time,
 * summary.
 */
public class Event {

	public Event() {
		name = "";
		distance = "0.0";
		time = "00:00:00";
		summary = "";
	}

	public Event(String n, String d, String t, String s) {
		name = n;
		distance = d;
		time = t;
		summary = s;
	}

	/**
	 * Getter methods
	 */
	public String getName() {
		return name;
	}

	public String getDistance() {
		return distance;
	}

	public String getEventTime() {
		return time;
	}

	public String getSummary() {
		return summary;
	}

	/**
	 * Setter methods
	 */
	public void setEvent(String n, String d, String t, String s) {
		name = n;
		distance = d;
		time = t;
		summary = s;
	}

	public void setName(String n) {
		name = n;
	}

	public void setDistance(String d) {
		distance = d;
	}

	public void setTime(String t) {
		time = t;
	}

	public void setSummary(String s) {
		summary = s;
	}

	/**
	 * Reads from StringTokenizer
	 */
	public void readEvent(StringTokenizer t) {
		name = t.nextToken();
		distance = t.nextToken();
		time = t.nextToken();
		summary = t.nextToken();
	}

	/**
	 * Writes to file
	 */
	public void writeEvent(PrintWriter pw) {
		pw.write(name);
		pw.write(']');
		pw.write(distance);
		pw.write(']');
		pw.write(time);
		pw.write(']');
		pw.write(summary);
		pw.write(']');
	}

	private String name = "";
	private String distance = "0.0";
	private String time = "00:00:00";
	private String summary = "";
}
