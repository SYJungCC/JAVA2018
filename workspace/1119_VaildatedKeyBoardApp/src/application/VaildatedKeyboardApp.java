package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VaildatedKeyboardApp {

	static void main(String arg[])
	{
		//Scanner input = new Scanner();

		try
		{

		//	input.nextLine(); //discard the bad input.
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Invaild Arguemnt : " + e.getMessage());
			//note: the stack trace can be printed for debugging the application
			//do not show the stack trace to the user.
			//e.printStackTrace(); //오직 메인만 되는거 맞는지 확인..




		}
		catch(InputMismatchException e)
		{
			System.out.println("INVAILD INPU. MUST BE AN INTEGER");
			if(e.getMessage() != null)
			{
				System.out.println("More Info: " + e.getLocalizedMessage());

			}
		}
	}

}
