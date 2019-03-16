package application;

import java.util.Scanner;

public class SearchArrayDemo {

	public static final int NUM_OF_NAMES = 3;
	private String[] _nameList = new String[NUM_OF_NAMES];


	public void fillNameList()
	{
		Scanner input = new Scanner(System.in);

		//Declarations & Initializations
		for(int iElem=0; iElem < _nameList.length; ++iElem)
		{
			System.out.print("Enter the name[" + iElem + "]:");
			_nameList[iElem] = input.nextLine(); // to scan a String
		}

	}//end of the fillNameList method

	public boolean findName(String name)
	{
		for(String nameElem : this._nameList)
		{
			//if the name exists in the array
			if(nameElem.equals(name))
			{
				return true;
			}
		}
		return false;
	}
}
