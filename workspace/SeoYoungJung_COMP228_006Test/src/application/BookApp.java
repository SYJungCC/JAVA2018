package application;
/**
 * SeoYoung Jung 300981742
 *
 */
import java.util.Scanner;

public class BookApp {

	public static void main(String [] args)
	{
		Scanner userInput = new Scanner(System.in); //user Input
		Book book1 = new Book();	//book Class

		//add book names
		for(int i =0 ; i < Book.MAXIMUM_BOOKS; ++i)
		{
			System.out.println("- Please write the book name");
			String str = userInput.nextLine();
			if(str.isEmpty() || str.equals(" "))
			{
				break;
			}
			else
			{
				book1.addBookTitle(str);
			}
		}

		//show the title which is contains Trees
		System.out.println("- User Input is done and the machine will find the title which is contain'Trees' [It doesn't find 'trees']");
		book1.find("Trees");

		//show a random book title
		System.out.println("- Showing radom title book");
		book1.showBookTitle();
	}

}
