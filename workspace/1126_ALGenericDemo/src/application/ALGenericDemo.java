package application;

import java.util.ArrayList;

public class ALGenericDemo {
	public static void main(String[] arg)
	{
		ArrayList nameList = new ArrayList(); //class Object

		//add one element
		nameList.add("John"); //String is converted to Object
		nameList.add(5); //NOTE : generic of the array is more type safe
						//getting a syntax for adding an element of the worng

		//get the value of the first elemetn
		String firstName = (String)nameList.get(0);



	}
}
