package application;

import java.util.Arrays;

public class Painting extends Shape {
	private Shape[] _shapeList = new Shape[3];

	public Painting (Shape[] list)
	{
		this._shapeList = Arrays.copyOf(list, list.length);
	}

	@Override
	public void draw()
	{
		for(int i = 0; i < _shapeList.length; i++)
		{
			_shapeList[i].draw();
		}
	}

}
