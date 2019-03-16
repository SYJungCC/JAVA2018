package application;

import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		// Declarations & Initializations

		Circle c1 = new Circle();
		Circle c2 = new Circle(7.65, new Point(5,5));
		Line line1 = new Line(new Point (0,0), new Point(0,8));
        Shape sh = null;
		// set the values c1
		c1.setName("Circle 1");
        c1.setColor("Blue");
        c1.setRadius(5.5);

        // set the values for c2
        c2.setName("Circle 2");
        c2.setColor("Red");

       // set the values for line 1
        line1.setName("Line 1");
        line1.setColor("White");

        // assign line1 to shape
        // up-cast: (assign the object of the subclass to the superclass)
        sh = c1;

        // draw the shapes
          c1.draw();
          c2.draw();
          sh.draw();

          // an array of type Shape
          ArrayList<Shape> shapeList = new ArrayList<Shape>();
          shapeList.add(c1);
          shapeList.add(line1);
          shapeList.add(c2);

          System.out.println("**Drawing the Painting!***");
          Painting p1 = new Painting(shapeList);

          p1.draw();

	}

}
