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
		//Arrays.Sort();
		//        бщ
		//       CompareTo();
		//
		Arrays.sort(this._shapeList);
		//repeat for each object in the list;
		for(Shape shape : this._shapeList)
		{
			shape.draw();
		}

		/*for(int i = 0; i < _shapeList.length; i++)
		{
			_shapeList[i].draw();
		}
		*/
	}



}
