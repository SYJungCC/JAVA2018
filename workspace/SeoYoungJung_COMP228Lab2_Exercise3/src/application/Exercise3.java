package application;
/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab2
 */

public class Exercise3 {

	public static void main(String [] args)
	{
		System.out.println("The checkFormat(90,65) is: " + OverloadingEx3.checkFormat(90, 65));							//put in int
		System.out.println("The checkFormat(1.7, 25.9) is: " + OverloadingEx3.checkFormat(1.7, 25.9)); 					//put in double
		System.out.println("The checkFormat(15f, 78f) is: " + OverloadingEx3.checkFormat(15f, 78f));					//put in float
		System.out.println("The checkFormat(90,I put in 65) is: " + OverloadingEx3.checkFormat("90", "I put in 65"));   //put in string
	}
}
