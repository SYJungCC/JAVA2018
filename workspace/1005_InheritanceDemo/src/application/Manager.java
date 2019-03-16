package application;

public  class Manager extends Employee{

	private double _bonus;

	public Manager(String name, double hours, double hourlySal, double bonus)
	{
		super(name,hours,hourlySal);
		this._bonus = bonus;
	}

	@Override
	public double calcPay()
	{
		return (this._hours * this._hourlySalary) + _bonus;
	}
}
