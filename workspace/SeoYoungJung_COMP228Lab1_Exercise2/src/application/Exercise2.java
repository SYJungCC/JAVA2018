package application;
/**
 * 300981742 SeoYoung Jung
 */
import java.util.Scanner;

public class Exercise2 {
	public static void main(String [] args)
	{
		int number = 0;	//user input
		int count = 0;	//if user input can be divided, it will be added
		Scanner input = new Scanner(System.in);

		System.out.print("Could you write integer? (only integer): ");
		number = input.nextInt();

		if(number % 5 == 0)
		{
			count++;
			if(number % 6 == 0)
			{
				count++;
			}
		}

		switch (count)
		{
		case 0 :
			System.out.print( number + " is not divisible by either 5 or 6.");
			break;
		case 1 :
			System.out.print( number + " is divisible by 5 or 6, but not both.");
			break;
		case 2:
			System.out.print( number + " is divisible by both 5 and 6.");
			break;
		}

	}
}
