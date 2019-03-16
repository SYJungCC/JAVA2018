package application;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab3 exercise 1
 */


public class Exercise1 {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String userInputString = new String(); //For user Input
		ArrayList<Insurance> insuranceList = new ArrayList<Insurance>(); 	//I want to unlimit making array that's why I used ArrayList.
		Insurance ins = null; //depends on the user Input, I want to make the class.
		do
		{
			try
			{
				//Input
				System.out.println("Please write your insurace type[Health = 0 /Life = 1].");
				userInputString =input.nextLine();
				if(userInputString.toUpperCase().equals("HEALTH") || userInputString.equals("0"))
				{
					ins = new Health();
				}
				else if (userInputString.toUpperCase().equals("LIFE") || userInputString.equals("1"))
				{
					ins = new Life();
				}
				else
				{
					System.out.println("You put in something else, please, try one more.");
					continue;
				}

				System.out.println("Please write the insurance Name");
				userInputString =input.nextLine();
				ins.setTypeOfInsurance(userInputString);

				System.out.println("How much is the monthly cost?");
				userInputString = input.nextLine();
				ins.setInsuranceCost(Double.parseDouble(userInputString));
				insuranceList.add(ins);
			}
			catch(NumberFormatException exception)
			{
				System.out.println("INVALID INPUT. MUST BE NUMBER FORMAT");
				System.out.println("More Info:" + exception.getMessage());
			}
			catch(Exception e)
			{
				if(e.getMessage() != null)
				{
					System.out.println("More Info:" + e.getMessage());
				}
				input.nextLine(); //discard the bad input;
			}

			System.out.println("Will you add more info? [Y/anyKey]");
			userInputString = input.nextLine();
			if(!userInputString.toUpperCase().equals("Y") && !userInputString.toUpperCase().equals("YES"))
			{
				System.out.println("Okay, it is done.");
				break;
			}
		}while(true);

		System.out.println("Display All Tester List");

		for(int i = 0; i < insuranceList.size(); ++i)
		{
			insuranceList.get(i).displayInfo();
		}

	}
}
