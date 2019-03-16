package application;

abstract class Mortgage implements MortgageConstants{

	private int _mortageNumber;
	private String _customerName;
	private double _amountOfMortgage;
	private double _interestRate;
	private int _term;
	private double _total;


	Mortgage()
	{

	}
	/**
	 * abstract method which I implement other child class
	 */
	abstract void getMortgageInfo();

	/**
	 * define the variable which in the Mortgage class.
	 * @param mortageNumber
	 * @param customerName
	 * @param amountOfMortgage
	 * @param interestRate
	 * @param term
	 */
	Mortgage(int mortageNumber,String customerName,double amountOfMortgage,  double interestRate, int term)
	{

		_mortageNumber= mortageNumber;
		_customerName = customerName;
		_interestRate = interestRate ;

		if(amountOfMortgage >= LIMIT_AMOUNT)
			amountOfMortgage = LIMIT_AMOUNT;
		else
			_amountOfMortgage= amountOfMortgage;

		if(SHORT_TERM == term || MEDIUM_TERM == term || LONG_TERM == term)
		{
			_term = term;
		}
		else
		{
			_term = SHORT_TERM;
		}

		_total = amountOfMortgage + (amountOfMortgage * (_interestRate * 0.01));
	}


	/**
	 * Getter & Setter Set
	 * @return
	 */
	public int getMortageNumber() {
		return _mortageNumber;
	}
	public void setMortageNumber(int mortageNumber) {
		this._mortageNumber = mortageNumber;
	}
	public String getCustomerName() {
		return _customerName;
	}
	public void setCustomerName(String customerName) {
		this._customerName = customerName;
	}
	public double getAmountOfMortgage() {
		return _amountOfMortgage;
	}
	public void setAmountOfMortgage(double amountOfMortgage) {
		if(amountOfMortgage >= LIMIT_AMOUNT)
			amountOfMortgage = LIMIT_AMOUNT;
		else
			_amountOfMortgage= amountOfMortgage;
	}
	public double getInterestRate() {
		return _interestRate;
	}
	public void setInterestRate(double interestRate) {
		this._interestRate = interestRate;
	}
	public int getTerm() {
		return _term;
	}
	public void setTerm(int term) {
		if(SHORT_TERM == term || MEDIUM_TERM == term || LONG_TERM == term)
		{
			_term = term;
		}
		else
		{
			_term = SHORT_TERM;
		}

	}
	public double getTotal() {
		return _total;
	}
	public void setTotal(double total) {
		this._total = total;
	}
}
