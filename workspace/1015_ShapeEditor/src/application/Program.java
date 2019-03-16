package application;

public class Program {
	public static void main(String[] arg)
	{
		//Declarations & Initializations
		Shape shape1 = new Shape();
		Circle c1 = new Circle();

		//set the
		shape1.setName("Undefined");	
		shape1.setColor("Blank");

		c1.setName("Circle 1");
		c1.setColor("Blue");
		c1.setRadius(5);

		shape1.draw();
		c1.draw();


	}
}
