package application;

import java.util.Random;

public class SimpleThread extends Thread{
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
*/
	//a random object variable
	Random _rnd = new Random();

	public SimpleThread(String name)
	{
		super(name);
	}

	//each Thread will have a run method
	//determines how the thread (task is executed)
	public void run()
	{
		//repeat
		for(int iteration = 0; iteration < 10  ; iteration++)
		{
			System.out.println(iteration + "" + getName());
			try {
				sleep(this._rnd.nextInt(1000));	//sleep random from 0 -1000
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("Done Trhead");
	}
}
