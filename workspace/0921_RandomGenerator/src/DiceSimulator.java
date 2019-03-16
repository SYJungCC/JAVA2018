import java.util.Random;  //used to generate random vaues

public class DiceSimulator {
	public static void main(String []args)
	{
		DiceSimulator self = new DiceSimulator();

		int sum = 0;
		//repeat the for loop
		for(int iRoll = 0 ; iRoll < 20 ; iRoll++)
		{
			sum += self.rollDice();
		}

		System.out.printf("The average of %d rolls is %.2f", 20 , sum/20.0f);

	}

	public int rollDice()
	{
		// Declarations & Initializations
		Random rnd = new Random();
		int randValue; //represents the rand number

		//generate a random value between 1 and 6
		randValue = rnd.nextInt(6) + 1;

		return randValue;

	}

}
