package application;

import java.util.ArrayList;
import java.util.Collections;

public class Painting extends Shape{

	private ArrayList<Shape> _shapeList = new ArrayList<Shape>();

	public Painting (ArrayList<Shape> list){
		// copy the array parameter
	    _shapeList.clear(); // empty the array list
		_shapeList.addAll(list); // add the elements of list to array list

	}
	@Override
	public void draw(){

	  // sort the list of arraylist of shapes
		Collections.sort(this._shapeList);

	  // repeat for each object in the list
      for(Shape shape: this._shapeList)
      {
    	  shape.draw();
      }
	}

}
