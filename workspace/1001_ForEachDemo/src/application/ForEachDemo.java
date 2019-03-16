package application;

import java.util.Scanner;

public class ForEachDemo {

	public static void main(String[] args)
	{
		//Declarations & initiailization
		Scanner input = new Scanner(System.in);
		String[] nameList = new String[5];//represents the array of names
		int numOfNames; //user requested number of values;

		System.out.println("How many names do you want:");
		numOfNames = input.nextInt();
		input.nextLine(); // discard the new line character

		//initiailize the array object with numOfNames elements
		nameList = new String[numOfNames];

		for(int iElem=0; iElem < nameList.length; ++iElem)
		{
			System.out.print("Enter the name[" + iElem + "]:");
			nameList[iElem] = input.nextLine(); // to scan a String
		}

		for(String name: nameList)
		{
			System.out.println(name);
		}

	}

}
