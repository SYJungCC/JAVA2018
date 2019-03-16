package application;

import java.util.Random;

public class Book {

	static final int MAXIMUM_BOOKS = 10;
	private String _bookTitles[] = new String[MAXIMUM_BOOKS];
	private int _actualNumberOfBooks = 0;

	/**
	 * add a new book title to the array
	 * @param title
	 */
	void addBookTitle(String title)
	{
		_bookTitles[_actualNumberOfBooks] = title;
		_actualNumberOfBooks++;
	}

	/**
	 * show random book title
	 */
	void showBookTitle()
	{
		Random rad = new Random();
		System.out.println(_bookTitles[rad.nextInt(_actualNumberOfBooks)]);
	}

	/**
	 * show the title which contains substring word
	 * @param subString : finding book titles
	 */
	void find(String subString)
	{
		for(int i =0 ; i < _actualNumberOfBooks; ++i)
		{
			if(_bookTitles[i].contains(subString))
			{
				System.out.println( _bookTitles[i]);
			}
		}
	}


}
