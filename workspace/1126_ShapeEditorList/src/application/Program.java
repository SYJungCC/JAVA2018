package application;

public class Program {
	public static void main(String[] arg)
	{
		//Declarations & Initializations
		Circle c1 = new Circle();
		Circle c2 = new Circle(7.65, new Point(5,5));
		Line line1 = new Line(new Point(0,0), new Point(0,8));
		Shape sh = null;

		c1.setName("Circle 1");
		c1.setColor("Blue");
		c1.setRadius(5.5);

		//set the value
		c2.setName("Circle 2");
		c2.setColor("Red");

		//set the values for line 1
		line1.setName("Line 1");
		line1.setColor("White");

		//assign line 1 to shpae (assign the object of the subclass to the superclass)
		//up-cast :

		sh = line1;

		c1.draw();
		c2.draw();
		sh.draw();


		//an array of type of Shape
		Shape[] shapeList = {c1, line1, c2};

		Painting p1 = new Painting(shapeList);
		System.out.println("*** Drawing the Painting! ***");
		p1.draw();

	}
}
