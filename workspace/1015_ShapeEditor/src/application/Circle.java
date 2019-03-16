package application;

public class Circle extends Shape{

	private double _radius;

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
		super.draw();
		System.out.println(this._radius);
	}
}
