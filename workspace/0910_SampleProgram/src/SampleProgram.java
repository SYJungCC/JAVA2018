// find the average of two integer
import java.util.Scanner;
public class SampleProgram {
	public static void main(String [] args)
	{

		//Declarations & Initializations
		int firstNum; //represents the first value
		double secondNum; //represents the second value

		double average; //represents the average of the two inputs
		Scanner input = new Scanner(System.in); //this object is used to access met

		//Promt the user - don't use println - she notices to me
		System.out.print("Enter the first value: ");
		firstNum = input.nextInt();
		System.out.print("Enter the second value: ");
		secondNum = input.nextDouble();
		//calculate average
		average = (firstNum + secondNum) / 2.0;

		System.out.println("The average of " + firstNum + "and " + secondNum + "is " + average);
		System.out.printf("The average of %d and %.3f is %3f", firstNum , secondNum, average);




	}

}
