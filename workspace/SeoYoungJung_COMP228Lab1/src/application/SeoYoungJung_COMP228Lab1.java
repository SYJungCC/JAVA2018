package application;
/**
 * 300981742 SeoYoung Jung
 */
import java.util.Scanner;

public class SeoYoungJung_COMP228Lab1 {
	public static void main(String [] args)
	{
		float userPounds = 0f;	//user weight in lbs
		float userKG = 0f; 		//user weight in kg
		float userFeet = 0f;	//user height in ft
		float userMeter = 0f; 	//user height in m
		float bmiResult = 0f;	//user BMI

		Scanner input = new Scanner(System.in); //this object is used to access met

		System.out.print("Could you write your weight? (only pounds): ");
		userPounds = input.nextFloat();
		userKG = userPounds * 0.453f;
		System.out.print(userPounds + " pounds is " + userKG + " kilograms\n");
		System.out.printf("User pounds is %.3f and it is %.3f kilograms\n", userPounds, userKG);

		System.out.print("Could you write your height? (only feet): ");
		userFeet = input.nextFloat();
		userMeter = (userFeet * 0.304f);
		System.out.print(userFeet + " feet is " + userMeter + " meters\n");
		System.out.printf("User feet is %.3f and it is %.3f meters\n", userFeet, userMeter);

		bmiResult = userKG / (userMeter * userMeter);
		System.out.print("BMI Result is "+ bmiResult);
	}
}
