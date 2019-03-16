package application;

import java.util.Scanner;

public class ArrayMethodDemo {

	public static final int NUM_OF_ELEMETS = 5;

	public static void main(String[] args)
	{
		//Declarations & initializations
		int[] numBox = {-33, 46, 100,24,41};

		ArrayMethodDemo self = new ArrayMethodDemo();

		self.printArryElemnts(numBox);
		//print the elements of the array in reversed order
		System.out.println("\nPrint the elements in reversed order : ");

		self.reverseArrayElements(numBox);

	}//end of the main method

	public void printArryElemnts(int []arr)
	{
		//repeat for all elements of the array
		for(int iElem = 0; iElem < arr.length; ++iElem)
		{
			//print each element
			System.out.print("Element[" + iElem + "]: " + arr[iElem]);
		}
	}

	public void reverseArrayElements(int[]arr)
	{
		//repeat for all elements of the array
		for(int iElem= (arr.length -1) ; iElem>=0; --iElem)
		{
			//print each element
			System.out.print("Element[" + iElem + "]: " + arr[iElem]);
		}
	}
}
