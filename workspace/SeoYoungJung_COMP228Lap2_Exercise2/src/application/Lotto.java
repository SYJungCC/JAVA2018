package application;
import java.util.Random;


public class Lotto {

	final int maxGameNum = 5;
	int randomThreeValues[] = new int[3];

	Lotto()
	{
		Random rnd = new Random();
		for (int i = 0; i < randomThreeValues.length ; ++i)
		{
			randomThreeValues[i] = rnd.nextInt(9) + 1;
		}

	}

	int [] getAnswer()
	{
		return randomThreeValues;
	}

	void getTestLog()
	{
		System.out.printf("lotto chosen : %d, %d, %d\n", randomThreeValues[0], randomThreeValues[1], randomThreeValues[2]);
	}
}
