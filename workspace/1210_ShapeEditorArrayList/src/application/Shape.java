package application;

public abstract class Shape implements Comparable<Shape> {

	protected String _name;
	protected String _color;


	public String getName() {
		return _name;
	}


	public void setName(String name) {
		this._name = name;
	}


	public String getColor() {
		return _color;
	}


	public void setColor(String color) {
		this._color = color;
	}


	public abstract void draw();

	@Override
	public int compareTo(Shape other){

		// sort two shapes based on their name (anti-alphabetical order)
		return other._name.compareTo(this._name);
	}


}
