package application;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {

	public static void main(String[] args )
	{
		ArrayList<Transaction> arrayList =  new ArrayList<Transaction>();


		Account acc = new Account();
		
		Transaction trans = new Transaction("Deposit", acc, 600);
		Transaction trans1 = new Transaction("Withdraw",acc,  -110);
		Transaction trans2 = new Transaction("Deposit",acc, 10);

		arrayList.add(trans);
		arrayList.add(trans1);
		arrayList.add(trans2);

		ExecutorService threadExecutor = Executors.newCachedThreadPool();

		threadExecutor.execute(arrayList.get(0));
		threadExecutor.execute(arrayList.get(1));
		threadExecutor.execute(arrayList.get(2));
		threadExecutor.shutdown();

		try
		{
			// wait 1 minute for both writers to finish executing
			boolean tasksEnded= threadExecutor.awaitTermination( 1, TimeUnit.MINUTES);
			if( tasksEnded)
			{
				arrayList.get(0).getBalance(); // print contents
				arrayList.get(1).getBalance(); // print contents
				arrayList.get(2).getBalance(); // print contents
			}

			else
				System.out.println(
						"Timed out while waiting for tasks to finish." );
		} // end try
		catch( InterruptedException ex )
		{
			System.out.println(
					"Interrupted while wait for tasks to finish." );
		} // end catch

	}
}
