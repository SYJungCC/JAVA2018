package application;

import java.util.ArrayList;

public class ArraryListDemo {
	public static void main(String[] args)
	{
		//Declarations & Initializations
		ArrayList<Integer> numList = new ArrayList<Integer>();
		//add elements to the arrayList
		numList.add(6);
		numList.add(7);
		numList.add(100);
		numList.add(56);
		numList.add(-33);

		//get the value of an element
		//reg array : int value  list[0]
		int value3 = numList.get(3); //get the value at index 3
		System.out.println("The value at index 3 is :" + value3);

		System.out.println("** Origin List");
		//print the elements of the array list
		for(int index = 0; index < numList.size(); index++)
		{
			System.out.println("numList["+ index +"]=" + numList.get(index));

		}

		//modify an element in the array list
		//reg array list[4] -00;
		numList.set(4, -99); // change the value at index 4 to -99

		//insert an element to the array list
		//reg array : N/A
		numList.add(1,78);

		//remove an element from the array list
		//reg array : N/A
		numList.remove(0);

		System.out.println("** Modify Arrary List **");
		//print the elements of the array list
		for(int index = 0; index < numList.size(); index++)
		{
			System.out.println("numList["+ index +"]=" + numList.get(index));

		}
	}
}
