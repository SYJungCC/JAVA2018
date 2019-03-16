package application;

abstract class Insurance {

	private String _typeOfInsurance;
	protected double _monthlyCost;

	abstract void setInsuranceCost(double montlyCost);
	abstract void displayInfo();

	/**
	 * specific insurance name
	 * @param typeOfInsurance
	 */
	public  void setTypeOfInsurance(String typeOfInsurance)
	{
		 _typeOfInsurance = typeOfInsurance;
	}

	/**
	 * get insurance name
	 * @return
	 */
	public  String getTypeOfInsurance()
	{
		return _typeOfInsurance;
	}

	/**
	 * get Monthly Cost
	 * @return
	 */
	public double getMonthlyCost()
	{
		return _monthlyCost;
	}

}
