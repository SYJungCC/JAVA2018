package application;

public class Circle extends Shape {

	private double _radius;
	private Point _centre;

	public Circle(){
          this._radius = 0;
          this._centre = new Point(0,0);
	}

	public Circle (double newRad, Point newCentre){
		this._radius = newRad;
		this._centre = newCentre;
	}


	public double getRadius() {
		return _radius;
	}

	public void setRadius(double radius) {
		this._radius = radius;
	}

	@Override
	public void draw(){
		System.out.println("name: " + this._name + ", " +
				           "radius : " + this._radius + ", " +
				           "center :("  + this._centre.getX() +","+
				                        this._centre.getY() + ")");


	}


}
