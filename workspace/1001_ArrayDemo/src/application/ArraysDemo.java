package application;

public class ArraysDemo {
	public static void main(String[] args)
	{
		//Declarations & initializations
		int[] numBox = {-33, 46, 100,24,41};

		//print the elements of numBox

		//repeat for all elements of the array
		for(int iElem = 0; iElem < numBox.length; ++iElem)
		{
			//print each element
			System.out.println("Element ["+ iElem +"]:" + numBox[iElem]);
		}

		//print the elements of the array in reversed order
		System.out.println("\nPrint the elements in reversed order : ");

		//repeat for all elements of the array
		for(int iElem = (numBox.length -1 ); iElem >= 0; --iElem)
		{
			//print each element
			System.out.println("Element ["+ iElem +"]:" + numBox[iElem]);
		}
	}
}
