/**
 * 
 */
package refresher.com;

/**
 * @author clif
 *
 */
public class SwEngineer extends Employee implements EmployeeType{
	
	private String grade;

	public SwEngineer(String fN, String lN, String id) {
		super(fN, lN, id);
	}

	@Override
	public void setType(String t) {
		this.grade = t;
	}

	@Override
	public String getType() {
		return this.grade;
	}
	
	public String getTitle(){
		return "Software Engineer";
	}

	@Override
	public double calculateAnnualSalary() {
		return 10;
	}

	@Override
	public String getClearance() {
		return "SECRET";
	}
	
}
