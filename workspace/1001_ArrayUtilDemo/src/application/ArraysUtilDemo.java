package application;

import java.util.Arrays;

public class ArraysUtilDemo {

	public static void main(String []args)
	{
		//Declaration & initializations
		int[] numBox = {-33, 46, 100,24,41};

		//print the elements of numBox
		System.out.println("Array elements " + Arrays.toString(numBox));

		int[] copyBox = numBox;
		//sort the element of the array in ascending
		Arrays.sort(numBox);

		System.out.println("sorted Array elements " + Arrays.toString(copyBox));

		//Do not use this
		//int [] newArray = oldArray; //->it means same array but different name;

		//Resize numBox
		int[] bigNumBox = Arrays.copyOf(numBox, 10);
		System.out.println("ReSize Array elements " + Arrays.toString(bigNumBox));

	}

}
