package application;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab3 exercisel 2
 * **/

public class Exercise2 {

	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		String userInputString = new String();
		ArrayList<GameTester> gameTester = new ArrayList<GameTester>();

		do
		{
			try
			{
				GameTester gt = null;
				//Input
				System.out.println("Are you full time Job [Y/N]?");
				userInputString =input.nextLine();
				if(userInputString.toUpperCase().equals("Y") || userInputString.toUpperCase().equals("YES"))
				{
					gt = new FullTimeGameTester();
					gt.setStatus(true);
				}
				else if (userInputString.toUpperCase().equals("N") || userInputString.toUpperCase().equals("NO"))
				{
					gt = new PartTimeGameTester();
					gt.setStatus(false);
				}
				else
				{
					System.out.println("Error : You should input 'Y' or 'N '");
					continue;
				}

				System.out.println("What is your name?");
				userInputString = input.nextLine();
				gt.setName(userInputString);

				System.out.println("How many hours have you worked? [working hour]");
				try {
					userInputString = input.nextLine();
					double hour = Double.parseDouble(userInputString);
					gt.calculateSalary(hour);
					gameTester.add(gt);
				}catch(NumberFormatException exception)
				{
					System.out.println("INVALID INPUT. MUST BE NUMBER FORMAT");
					System.out.println("More Info:" + exception.getMessage());
				}
				catch (Exception e)
				{
					System.out.println("- More Info:" + e.getMessage());
				}
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

		if(gameTester.size() > 0 )
		{
			System.out.println("Display All Tester List");

			for(int i = 0; i < gameTester.size(); ++i)
			{
				gameTester.get(i).displayTesterInfo();
			}
		}
		else
		{
			System.out.println("You didn't put in Any info. Thank you.");
		}

	}
}
