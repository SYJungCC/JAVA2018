package application;

public class Employee {

	protected String _name;
	protected double _hours;
	protected double _hourlySalary;

	public Employee(String name, double hours, double hourlySalary)
	{
		this._name = name;
		this._hours = hours;
		this._hourlySalary = hourlySalary;
	}

	@Override
	public String toString()
	{
		return _name + ", " + this.calcPay();

	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public double getHours() {
		return _hours;
	}

	public void setHours(double hours) {
		this._hours = hours;
	}

	public double getHourlySalary() {
		return _hourlySalary;
	}

	public void setHourlySalary(double hourlySalary) {
		this._hourlySalary = hourlySalary;
	}

	public double calcPay()
	{
		return this._hours * this._hourlySalary;
	}

}
