package application;

import java.util.Scanner;

/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab3 exercise 3
 * **/

public class ProcessMortgage {
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		Mortgage [] mortgages = new Mortgage[3];	//Required.
		String userInputString = new String();
		String userName = null; 	//For user Input : userName
		double interestRate = 0; 	//For user Input : decide interest Rate
		double money = 0;			//For user Input : money
		int count = 0;				//Array Counting
		int term = 0; 				//For user Input : term


		try
		{
			System.out.println("Put in current interest rate [%]");
			userInputString =input.nextLine();
			interestRate = Double.parseDouble(userInputString);

			do{
				System.out.println("What is your name?");
				userName = input.nextLine();

				System.out.println("how much money do you need?");
				userInputString = input.nextLine(); //for want to check try catch, I start to read string.
				money = Double.parseDouble(userInputString);

				System.out.println("how many term do you need?");
				userInputString = input.nextLine();
				term = Integer.parseInt(userInputString);

				System.out.println("Which type of Mortgage you are interested in?[Business = 0 / Personal = 1]");
				userInputString =input.nextLine();
				if(userInputString.toUpperCase().equals("BUSINESS") || userInputString.equals("0"))
				{
					mortgages[count] = new BusinessMortgage(userName,money,interestRate, term);
					count++;
				}
				else if (userInputString.toUpperCase().equals("PERSONAL") || userInputString.equals("1"))
				{
					mortgages[count]  = new PersonalMortgage(userName,money,interestRate, term);
					count++;
				}
				else
				{
					System.out.println("You put in something else, please, try one more.\n"
										+ "you have to write "+ (mortgages.length- count) + " info more");
					continue;
				}

			}while(count < mortgages.length);	//if you fill all array, you get out of the loop.

		}catch(NumberFormatException exception)
		{
			System.out.println("INVALID INPUT. MUST BE NUMBER FORMAT");
			System.out.println("More Info:" + exception.getMessage());
		}
		catch(Exception e)
		{
			System.out.println("More Info:" + e.getMessage());
		}

		//Show the detail
		System.out.println("- User decided the interest rate : " + interestRate);

		for(int i = 0; i < mortgages.length; ++i)
		{
			if(mortgages[i] != null)
			{
				mortgages[i].getMortgageInfo();
			}
		}

	}
}
