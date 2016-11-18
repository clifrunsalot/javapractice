/**
 * 
 */
package refresher.com;

/**
 * @author clif
 *
 */
public abstract class Employee {

	private String fName;
	private String lName;
	private String eID;
	private String title;

	public Employee(String fN, String lN, String id) {
		this.fName = fN;
		this.lName = lN;
		this.eID = id;
	}

	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * @param fName
	 *            the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName
	 *            the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the eID
	 */
	public String geteID() {
		return eID;
	}

	/**
	 * @param eID
	 *            the eID to set
	 */
	public void seteID(String eID) {
		this.eID = eID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return "Typical Employee";
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public abstract double calculateAnnualSalary();

}
