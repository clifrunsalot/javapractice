/**
 * 
 */
package refresher.practice.oo;

/**
 * @author clif
 *
 */
public class HrEmployee extends Employee {

	public HrEmployee(String fN, String lN, String id) {
		super(fN, lN, id);
	}
	
	public String getTitle(){
		return "Human Resources";
	}

	@Override
	public double calculateAnnualSalary() {
		return 5;
	}

}
