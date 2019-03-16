package application;
/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab2
 */
 abstract class GameTester {

	private String _name;
	private double _salary;
	private boolean _status; //full time true , part time false

	/**
	 * part time = 20* hour
	 * pull time = 3000
	 * @param hour
	 */
	abstract void calculateSalary(double hour);

	/**
	 * for displaying information.
	 */
	abstract void displayTesterInfo();


	/**
	 * Variables are private, That's why I made Getter & Setter
	 */

	/**
	 *Get Tester Name
	 * @return
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Set Tester Name
	 * @param name
	 */
	public void setName(String name) {
		this._name = name;
	}

	/**
	 * Get Salary
	 * @return
	 */
	public double getSalary() {
		return _salary;
	}

	/**
	 * Set Salary
	 * @param salary
	 */
	public void setSalary(double salary) {
		this._salary = salary;
	}

	/**
	 * Get Status :
	 * @return full time -> true , part time -> false
	 */
	public boolean isStatus() {
		return _status;
	}

	/**
	 * Set Status
	 * @param status
	 */
	public void setStatus(boolean status) {
		this._status = status;
	}



}
