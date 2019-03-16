package application;
/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab2
 */
import javax.swing.JOptionPane;
public class Exercise2 {

	static final int MAXIMUM_NUMBER = 27;					//Maximum Game which player can play.
	static final int MINIMUM_NUMBER = 3;					//Maximum Game which player can play.
	static final int MAX_PLAY_COUNT = 5;					//Maximum Game which player can play.

	public static void main(String [] args)
	{
		Lotto lotto = new Lotto();				//Lotto Class
		String userInput;

		int lottoSum = 0;						//sum number of userInput
		int answerCount = 0;					//counting how many times user play the game

		boolean finishGame = false;				//checking user keep put in number
		boolean doesUserWin = false;			//cheking user win the game or not

		//checking Lotto Random number;
		lotto.getTestLog();

		//Make lotto Sum
		for(int i = 0;  i< lotto.getLottoArray().length; ++i)
		{
			lottoSum += lotto.getLottoArray()[i];
		}

		//Start loop
		do
		{
			userInput = JOptionPane.showInputDialog("Please enter number (3 ~ 27):");
			int userValue = Integer.parseInt(userInput);	//get user Input

			if(MINIMUM_NUMBER <= userValue && MAXIMUM_NUMBER >= userValue)
			{
				answerCount++;			//adding count which is user answer
				if(lottoSum == userValue)
				{
					finishGame = doesUserWin = true;
				}
				else if(MAX_PLAY_COUNT<= answerCount)
				{
					finishGame = true;
				}
			}
			else
			{
				//if user input the number which is not between 3 and 27, it shows this wrong.
				JOptionPane.showMessageDialog(null,"you wrote wrong number, please write between 3 and 27");
			}

		}while(!finishGame); //finish loop


		//if user lost display lose, or not display win
		if(doesUserWin)
		{
			JOptionPane.showMessageDialog(null,"You are Win");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"You are lose");
		}
	}
}
