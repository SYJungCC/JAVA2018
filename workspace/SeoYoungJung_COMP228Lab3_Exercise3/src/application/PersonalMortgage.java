package application;

public class PersonalMortgage  extends Mortgage {


	/**
	 * constructor set interest rate to 2% over the current prime rate.
	 * I understood I should plus 2 from userInput.
	 * @param customerName
	 * @param amountOfMortgage
	 * @param interestRate
	 * @param term
	 */
	PersonalMortgage(String customerName,double amountOfMortgage, double interestRate, int term)
	{
		super(1,customerName, amountOfMortgage, interestRate + 2, term);
	}

	@Override
	void getMortgageInfo() {
		System.out.println("¡Ú¡Ú¡Ú Personal Mortgage ¡Ú¡Ú¡Ú \n" +
							"Bank Name : " + BANK_NAME +
							 "\nMortage Number : " + this.getMortageNumber()+
							 "\nCustomer Name : " + this.getCustomerName()  +
							 "\nAmount Of Mortgage : " + this.getAmountOfMortgage() +
							 "\nInterestRate(user input(%) + 2(%)) : " + this.getInterestRate() +
							 "\nTerm : " + this.getTerm() +
							 "\nTotal Amount : " + this.getTotal());
	}
}
