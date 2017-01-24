/**
 * 
 */
package refresher.practice.oo;

/**
 * @author clif
 *
 */
public interface EmployeeType {
	
	String PREFIX = "SW";
	String POSTFIX = "-000";
	
	public void setType(String t);
	
	public String getType();
	
	public String getClearance();

}
