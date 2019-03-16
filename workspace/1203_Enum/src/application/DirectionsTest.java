package application;

public class DirectionsTest {

	public static void main(String[] args) {
		//Directions & Initializations
		Directions dir = Directions.SOUTH;


		//print the information regarding dir
		System.out.println("Dir ordinal : " + dir);
		System.out.println("Dir ordinal : " + dir.ordinal());
		System.out.println("Dir name : " + dir.name());

		//print the information for any member of the enum
		System.out.println("Direction.West : " + Directions.WEST);
		System.out.println("Direction.West ordinal : " + Directions.WEST.ordinal());
		System.out.println("Direction.West name : " + Directions.WEST.name());

		System.out.println("\n** The display name for each enum type **");

		for(Directions d : Directions.values())
		{
			System.out.println(d.getDisplayName());
		}
	}

}
