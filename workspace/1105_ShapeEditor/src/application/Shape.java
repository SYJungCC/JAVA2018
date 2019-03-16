package application;

public class Shape implements Comparable<Shape>{

	protected String _name;
	protected String _color;

	public void draw()
	{
		System.out.println(this._name + ", " + this._color);
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		_name = name;
	}

	public String getColor()
	{
		return _color;
	}

	public void setColor(String color)
	{
		_color = color;
	}

	@Override
	public int compareTo(Shape other)
	{

		//sort two shapes based on their name ** reversed.(anti-alphabetical order)
		return other._name.compareTo(this._name);
	}
}
