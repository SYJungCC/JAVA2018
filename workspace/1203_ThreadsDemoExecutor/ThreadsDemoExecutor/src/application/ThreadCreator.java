package application;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadCreator
{
	public static void main( String[] args )
	{
		System.out.println( "Creating threads" );
		// create each thread with a new targeted runnable
		PrintTask task1 =  new PrintTask( "task1" ) ;
		PrintTask task2 = new PrintTask( "task2" ) ;
		PrintTask task3 = new PrintTask( "task3" ) ;
		System.out.println( "Starting Exercutor" );
												//used the cached method
												//to avoid the consecutive exec.
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		// start threads and place in runnable state
		threadExecutor.execute(task1); // invokes task1’s run method
		threadExecutor.execute(task2); // invokes task2’s run method
		threadExecutor.execute(task3);// invokes task3’s run method
		System.out.println( "Tasks started, main ends.\n" );
	} //
}