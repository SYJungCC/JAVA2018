package application;

public class TriangleTest {
	public static void main(String[] arg)
	{
		//Declarations & Initializations
		Triangle tri1 = new Triangle();
		Triangle tri2 = new Triangle(20,20);

		//Change the properties of tri1
		tri1.setBase(6.5);
		tri1.setHight(4);

		System.out.println("The area of the triangle1" +
							" with base " + tri1.getBase() +
							" with height " + tri1.getHight() +
							" is " + tri1.calcTriArea() +
							".");

		System.out.println("The area of the triangle2" +
				" with base " + tri2.getBase() +
				" with height " + tri2.getHight() +
				" is " + tri2.calcTriArea() +
				".");

		System.out.println("The number of triangle objects: " + Triangle.s_numOfObjects);

		/**
		 * Random / java uuil package
		 */
	}
}
