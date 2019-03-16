package application;

public class OverloadingExample {

	public static int max(int num1, int num2)
	{
		if (num1 > num2)
		{
			return num1;
		}
		else
		{
			return num2;
		}
	}//end of the max method

	public static double max(double num1, double num2)
	{
		return (num1 > num2) ? num1 : num2;
	}//end of the max method


	public static int min(int num1, int num2)
	{
		return (num1 < num2) ? num1 : num2;
	}//end of the max method


	public static double min(double num1, double num2)
	{
		return (num1 < num2) ? num1 : num2;
	}//end of the max method


	public static int min(int num1, int num2, int num3)
	{
		return min(min(num1, num2), num3);
	}//end of the max method
}


