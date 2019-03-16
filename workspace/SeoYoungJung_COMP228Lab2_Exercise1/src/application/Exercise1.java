package application;
/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab2
 */
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Exercise1 {

	public static final int NUM_OF_QUESTIONS= 6;

	//Array for random congratulation message for User
	private String [] _congratulatoryMsgList = { "Excellent!",
												"Good!",
												"Nice work!",
												"Excellent!"};


	//Array for random appropiate message for User
	private String [] _appropiateMsgList = {  "No. Please, try again.",
												"Wrong. Try once more.",
												"Don't give up",
												"No. Keep trying.."};

	//Array for Questions and Correct answer
	private String [][] _questionList =
		{
				{"[Q1] What is the overloaded? (1~4)", "1"}, //"Methods with same name , diffent parameterlist, Similar functionality"
				{"[Q2] What is the correct syntax for java main method(1~4)","2"}, //	public static void main(String [] args)
				{"[Q3] Can void function return value?(1~4)","3"},//No
				{"[Q4] If you want to call math method, which class should you import?(1~4)","3"}, //Math
				{"[Q5] If you want to develop JAVA application, which pakage should you download?(1~4)","4"}, //JDK
				{"[Q6] What is the JVM?(1~4)","2"} //JVM is Java Virtual Machine
		};


	public static void main(String [] args)
	{

		Exercise1 self = new Exercise1();
		int userInput = 0;			//get result of userInput
		int countRightAnswer = 0;	//count right user answer;
		boolean [] userAnswer = new boolean[NUM_OF_QUESTIONS]; //initialize the elements that user answers are correct or not

		for(int i = 0 ; i < NUM_OF_QUESTIONS ; ++i)
		{
			//input user Answer
			userInput = self.inputAnswer(i);

			//check user Answer
			userAnswer[i]  = self.checkAnswer(i,userInput);

			//if userAnsewr is right, counting how many time user correct
			if(userAnswer[i]) countRightAnswer++;

			//Display Random Message depend on user answer
			JOptionPane.showMessageDialog(null, self.generateMessage(userAnswer[i]));
		}

		//for printing correct answer
		String result = "Number of correct :";
		int numberOfQuestion = 0;
		for(int i = 0; i <userAnswer.length; ++i)
		{
			if(userAnswer[i])
			{
				numberOfQuestion = i + 1;
				result += "  ["+ numberOfQuestion+"]";
			}
		}
		result+= "\n";


		//for printing incorrect answer
		result += "Number of incorrect :";
		for(int i = 0; i <userAnswer.length; ++i)
		{
			if(!userAnswer[i])
			{
				numberOfQuestion = i + 1;
				result += "  ["+ numberOfQuestion+"]";
			}
		}
		result+= "\n";

		//for printing percentage
		result += "Percentage of the correct answers : " + (double)((double)countRightAnswer / (double)NUM_OF_QUESTIONS) * 100 +"%";

		//Display result
		JOptionPane.showMessageDialog(null, result);
	}


	/**
	 * method for simulate the questions
	 * @param questionNumber
	 * @return the qustion
	 */
	String simulateQuestion(int questionNumber)
	{
		return _questionList[questionNumber][0];
	}

	/**
	 * user input their answer.
	 *  method to interact with the user
	 * @param qauestionNum : Question Number
	 * @return user input
	 */
	int inputAnswer(int qauestionNum)
	{
		//simulate Question
		String message = JOptionPane.showInputDialog(simulateQuestion(qauestionNum));
		return Integer.parseInt(message);
	}

	/**
	 * @param questionNumber : question number for checking user answer
	 * @param userInput : user Answer
	 * @return if user answer is true, it returns true, or not, returns fals
	 */
	boolean checkAnswer(int questionNumber, int userInput)
	{
		//System.out.printf("User answer : %d\n", Integer.parseInt(_questionList[questionNumber][1]));
		if(Integer.parseInt(_questionList[questionNumber][1]) == userInput )
		{
			return true;
		}
		return false;
	}


	/**
	 * I don't need to use Swtich Case Statement, but the assginment told me using Switch case State.
	 * @param isAnswerTrue : if it is true, return congratulatoryMsg. it is false, return appropiateMsg
	 * @return return random message which is depends on user answer.
	 */
	String generateMessage(boolean isAnswerTrue)
	{
		Random randomObject = new Random();

		if(isAnswerTrue)
		{
			switch(randomObject.nextInt(4))
			{
			case 0 :
				return _congratulatoryMsgList[0];
			case 1:
				return _congratulatoryMsgList[1];
			case 2:
				return _congratulatoryMsgList[2];
			case 3:
				return _congratulatoryMsgList[3];
			}

		}
		else
		{
			switch(randomObject.nextInt(4))
			{
			case 0 :
				return _appropiateMsgList[0];
			case 1:
				return _appropiateMsgList[1];
			case 2:
				return _appropiateMsgList[2];
			case 3:
				return _appropiateMsgList[3];
			}
		}

		return "Wrong Answer";
	}



}
