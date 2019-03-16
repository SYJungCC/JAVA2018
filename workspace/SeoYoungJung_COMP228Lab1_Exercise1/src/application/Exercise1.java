package application;
/**
 * 300981742 SeoYoung Jung
 */
import java.util.Scanner;

public class Exercise1 {
	public static void main(String [] args)
	{
		float userPounds = 0f;	//user weight in lbs
		float userKG = 0f; 		//user weight in kg
		float userFeet = 0f;	//user height in ft
		float userMeter = 0f; 	//user height in m
		float bmiResult = 0f;	//user BMI

		Scanner input = new Scanner(System.in);

		System.out.print("Could you write your weight? (only pounds): ");
		userPounds = input.nextFloat();
		userKG = userPounds * 0.453f;
		System.out.printf("User pounds is %.3f and it is %.3f kilograms\n", userPounds, userKG);

		System.out.print("Could you write your height? (only feet): ");
		userFeet = input.nextFloat();
		userMeter = (userFeet * 0.304f);
		System.out.printf("User feet is %.3f and it is %.3f meters\n", userFeet, userMeter);

		bmiResult = userKG / (userMeter * userMeter);
		System.out.printf("BMI Result is %.3f \n", bmiResult);
	}
}
