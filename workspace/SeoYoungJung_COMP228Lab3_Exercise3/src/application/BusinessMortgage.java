package application;

public class BusinessMortgage extends Mortgage{


	/**
	 * constructor set interest rate to 1% over the current prime rate.
	 * I understood I should plus 1 from userInput.
	 * if user Input is 1 -> The business Mortgage is 3% rate.
	 * @param customerName
	 * @param amountOfMortgage
	 * @param interestrate
	 * @param term
	 */
	BusinessMortgage(String customerName, double amountOfMortgage, double interestrate,  int term)
	{
		super(0,customerName, amountOfMortgage, interestrate + 1, term);

	}

	@Override
	void getMortgageInfo() {
		System.out.println("¡Ú¡Ú¡Ú Business Mortgage ¡Ú¡Ú¡Ú \n" +
				"Bank Name : " + BANK_NAME +
				 "\nMortage Number : " + this.getMortageNumber()+
				 "\nCustomer Name : " + this.getCustomerName()  +
				 "\nAmount Of Mortgage : " + this.getAmountOfMortgage() +
				 "\nInterestRate(user input(%) + 1(%)) : " + this.getInterestRate() +
				 "\nTerm : " + this.getTerm() +
				 "\nTotal Amount : " + this.getTotal());
	}
}
