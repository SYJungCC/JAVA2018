package application;
/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab1
 */
import java.util.Scanner;

public class Exercise3 {


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
		//System.out.print(userPounds + " pounds is " + userKG + " kilograms\n");
		System.out.printf("User pounds is %.3f and it is %.3f kilograms\n", userPounds, userKG);

		System.out.print("Could you write your height? (only feet): ");
		userFeet = input.nextFloat();
		userMeter = (userFeet * 0.304f);
		//System.out.print(userFeet + " feet is " + userMeter + " meters\n");
		System.out.printf("User feet is %.3f and it is %.3f meters\n", userFeet, userMeter);

		bmiResult = userKG / (userMeter * userMeter);

		Exercise3 ex = new Exercise3();
		System.out.print("BMI Result is " + bmiResult + " and "+ ex.calculateBmiDescription(bmiResult));
	}
/**
 * I try to follow class that's why I don't make static method
 * @param bmi //BMI
 * @return str // result of BMI
 */
	public String calculateBmiDescription(float bmi)
	{
		String str = new String();

		if(bmi < 18.5f)
		{
			str = "Underweight";
		}
		else if(18.5f >= bmi && bmi <= 24.9f)
		{
			str = "Normal";
		}
		else if(25.0f >= bmi && bmi <= 29.9f)
		{
			str = "Overweight";
		}
		else if(bmi >= 30f)
		{
			str = "Obese";
		}
		return str;
	}
}
