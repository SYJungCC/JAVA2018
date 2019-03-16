package application;

public class OverloadingEx3 {

	/**
	 * 	if user input String , it will be running
	 * @param str1 string
	 * @param str2 string
	 * @return
	 */
	public static String checkFormat(String str1, String str2)
	{
		return "[String] string1 : "  + str1 + " string2: "+ str2;
	}


	/**
	 * 	if user input int type, it will be running
	 * @param num1 int
	 * @param num2 int
	 * @return
	 */
	public static String checkFormat(double num1, double num2)
	{
		return "[double] number1 : "  + num1 + " number2: "+ num2;
	}

	/**
	 * if user input float type, it will be running
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String checkFormat(float num1, float num2)
	{
		return "[float] number1 : "  + num1 + " number2: "+ num2;
	}

	/**
	 * if user input double type, it will be running
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String checkFormat(int num1, int num2)
	{
		return "[int] number1 : "  + num1 + " number2: "+ num2;
	}

}
