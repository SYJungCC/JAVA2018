package application;

public class Shape {

	private String _name;
	private String _color;

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

}
