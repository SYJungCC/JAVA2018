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
public class KeyboardApplicationV2 {
	public static void main(String [] arg){
		//Declaration & Initializations
		int userKey = 0; //represents the key entered by the user
		Scanner input = new Scanner(System.in);

		KeyboardApplicationV2 self = new KeyboardApplicationV2();

		//Input
		System.out.print("Enter an integer value: ");
		userKey = input.nextInt();

		//print movement
		self.printfMovenemt(userKey);
	//	printfMovenemt(userKey);

	}//end of the main method
/**printMovement decides the movement based on the key
 * @param userKey: the key that the user enters
 *
 */
	public  void printfMovenemt(int userKey)
	{
		//ctrl + i = fix the line
		switch(userKey) //check the different values of the key
		{
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
