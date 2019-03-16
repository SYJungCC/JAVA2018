package application;

import java.util.ArrayList;
import java.util.Scanner;

public class SortedArrayList {

	public static final int MAX_ELEMENTS =5 ;
	public static void main(String[] args){

		// Declarations & Initializations
		ArrayList<Integer> myList = new ArrayList<Integer>();
		SortedArrayList self = new SortedArrayList();
		Scanner input = new Scanner(System.in);

		// prompt the user for 5 elements
		for (int index = 0; index < MAX_ELEMENTS; index++){
			System.out.print("myList[" + index +"] : ");
			myList.add(input.nextInt());

		}


		// call the isSorted method to check if the array is sorted
		System.out.println("The array is sorted : " + self.isSorted(myList));



	}

	public boolean isSorted(ArrayList<Integer> list){

		// repeat for each element of the list
		for (int index = 0; index < (list.size() -1); index++){

			// check if the two adjacent elements are NOT in ascending order
			if (list.get(index) > list.get(index + 1)){
				// the array is not sorted
				return false;
			}

		}
		// the array list is sorted in ascending order
		return true;
	}

}
