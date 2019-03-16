package application;

import java.util.Scanner;

/* keyboard Application. java
 * author : Elmira Adeeb
 * purpose : Develop a java application to decide the movement.
 * 			using a method named printMovenemt
 * */

/*
 * what is the different design time , compile, run time
 * */
public class KeyboardAppOOP {
	private  int _userKey= 0 ;
	public static void main(String [] arg){
		//Declaration & Initializations

		Scanner input = new Scanner(System.in);

		KeyboardAppOOP self = new KeyboardAppOOP();
		do{
		//Input
		System.out.print("Eneter an integer value (1-9). 0 to stop:");
		System.out.print("Enter an integer value: ");
		self._userKey = input.nextInt();	//<------------------------- self._userKey.

		//print movement
		self.printfMovenemt();
	}while(self._userKey != 0); // as long key is not zero

	}//end of the main method
	/**printMovement decides the movement based on the key
	 * @param userKey: the key that the user enters
	 *
	 */
	public  void printfMovenemt()
	{
		//ctrl + i = fix the line
		switch(this._userKey) //check the different values of the key
		{
		case 0:
			System.out.println("You've entered zero. Application will end");
			break;
		case 2 :
			System.out.println("Move Down");
			break;
		case 4 :
			System.out.println("Move Left");
			break;
		case 8 :
			System.out.println("Move Up");
			break;
		case 6 :
			System.out.println("Move Right");
			break;

		case 1 :
		case 3 :
		case 7 :
		case 9 :
			System.out.println("Diagonal Movement Not Allowed");
			break;
		default :
			System.out.println("Invalied key");
			break;
		}//end of the switch

	}
}// end of the class
