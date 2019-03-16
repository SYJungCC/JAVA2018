package application;

public class Circle extends Shape{

	private double _radius;
	private Point _centre;

	public Circle()
	{
		this._radius = 5.5;
		this._centre = new Point(0,0);

	}
	public Circle(double newRad, Point newCentre)
	{
		this._radius = newRad;
		this._centre = newCentre;
	}

	public double getRadius()
	{
		return _radius;
	}

	public void setRadius(double radius)
	{
		_radius = radius;
	}

	@Override
	public void draw()
	{
		System.out.println("Name: " + this._name + " \n"  + "radius :" + this._radius + " center : (" + this._centre.getX() + "," + this._centre.getY() +")");

	}
}
