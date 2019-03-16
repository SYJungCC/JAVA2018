package application;
/**
 * 300981742 SeoYoung Jung
 * COMP228 Lab2
 */

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	private int _randomThreeValues[] = new int[3];

	Lotto()
	{
		//lotto has three random values
		Random rnd = new Random();
		for (int i = 0; i < this._randomThreeValues.length ; ++i)
		{
			this._randomThreeValues[i] = rnd.nextInt(9) + 1;
		}
	}

	/**
	 * for Getting Lotto Array
	 * @return arrays
	 */
	int [] getLottoArray()
	{
		return this._randomThreeValues;
	}

	/**
	 *  for Testing, I made it.
	 */
	void getTestLog()
	{
		int sumNum = 0 ;
		for(int i = 0 ; i < this._randomThreeValues.length; ++i)
		{
			sumNum+=this._randomThreeValues[i];
		}
		System.out.println("lotto chosen " + Arrays.toString(this._randomThreeValues) + " lotto Sum is " + sumNum);
	}
}
