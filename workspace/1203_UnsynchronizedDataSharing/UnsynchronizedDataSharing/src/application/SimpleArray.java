package application;

import java.util.Random;

public class SimpleArray
{
	private final int _list[]; // the shared integer array
	private int writeIndex= 0;

	private final static Random s_generator = new Random();

	// construct a SimpleArrayof a given size
	public SimpleArray( int size )
	{
		_list = new int[ size ];
	} // end constructor

	public void add(int value )
	{
		int position = writeIndex; // store the write index
		try
		{
			// put thread to sleep for 0-499 milliseconds
			Thread.sleep( s_generator.nextInt( 500 ) );
		} // end try
		catch( InterruptedException ex )
		{
			ex.printStackTrace();
		} // end catch
		// put value in the appropriate element
		_list[ position ] = value;
		System.out.printf( "%s wrote %2d to element %d.\n",
				Thread.currentThread().getName(), value, position );
		++writeIndex; // increment index of element to be written next
		System.out.printf( "Next write index: %d\n", writeIndex);
	} // end method add


	public String toString()
	{
		String arrayString= "\nContentsof SimpleArray:\n";
		for( int i= 0; i< _list.length; i++ )
			arrayString+= _list[ i] + " ";
		return arrayString;
	} // end method toString


}