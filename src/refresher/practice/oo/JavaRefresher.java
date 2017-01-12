package refresher.practice.oo;
/**
 * 
 */

/**
 * @author clif
 *
 */
public class JavaRefresher {

	public static void logIt(Employee e) {

		try {
			System.out
					.println(e.getfName() + " " + e.getlName() + " " + e.getTitle() + " " + e.calculateAnnualSalary());
		} catch (NullPointerException npe) {
			System.out.println("Employee cannot be null");
		} finally {
			System.out.println("Ended at " + System.currentTimeMillis());
		}
	}

	public static void logfName(Employee e) throws NullPointerException {
		if (e == null) {
			throw new NullPointerException("Employee cannot be null 2");
		} else {
			System.out.println(e.getfName());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SwEngineer swemp = new SwEngineer("joann", "hudson", "cc03");
		swemp.setType("Geek");
		logIt(swemp);
		System.out.println("Type: " + swemp.getType());
		System.out.println("Clearance: " + swemp.getClearance());
		if (swemp instanceof Employee) {
			System.out.println("Instance Of Employee");
		} else if (swemp instanceof SwEngineer) {
			System.out.println("Instance Of SwEngineer");
		}

		HrEmployee hremp = new HrEmployee("sirena", "hudson", "dd04");
		logIt(hremp);

		SwEngineer swemp2 = null;
		System.out.println("PREFIX: " + swemp2.PREFIX);
		logIt(swemp2);
		try {
			logfName(swemp2);
		} catch (NullPointerException npe) {
			System.out.println("Employee is null");
		}

	}

}
