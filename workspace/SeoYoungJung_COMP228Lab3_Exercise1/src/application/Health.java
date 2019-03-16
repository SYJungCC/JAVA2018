package application;

public class Health extends Insurance {


	@Override
	public void setInsuranceCost(double monthlyCost) {
		_monthlyCost = monthlyCost + (monthlyCost * 0.05);
	}

	@Override
	public void displayInfo()
	{
		System.out.println("Health Insurance Type : " + this.getTypeOfInsurance() + "  MonthlyCost(cost + cost * 0.05) : $" + this.getMonthlyCost());
	}

}
