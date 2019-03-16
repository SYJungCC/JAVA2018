package application;

public class Life extends Insurance{

	@Override
	public void setInsuranceCost(double monthlyCost) {
		_monthlyCost = monthlyCost + (monthlyCost * 0.02);
	}

	@Override
	public void displayInfo()
	{
		System.out.println("Life Insurance Type : " + this.getTypeOfInsurance()  + "  MonthlyCost(cost + cost * 0.02) : $" + this.getMonthlyCost());
	}
}
