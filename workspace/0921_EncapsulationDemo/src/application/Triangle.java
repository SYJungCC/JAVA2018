package application;

public class Triangle {
	private double _base;
	private double _height;
	public static int s_numOfObjects = 0;

	/**
	 * Overloaded method
	 * 	-> Same name, different input parameters
	 * 	-> Same class
	 *  -> similarFuntionlity
	 */


	/**
	 * Triangle is the default constructor of the class
	 *
	 * */
	public Triangle()
	{
		this(1,1);
		/*
		this._base = 0 ;
		this._height = 0;
		*/
	}

	/**
	 * Triangle is the parametized constructor
	 * that inialized
	 * @param newBase
	 * @param newHeight
	 */
	public Triangle(double newBase, double newHeight)
	{
		this._base = newBase;
		this._height = newHeight;
		s_numOfObjects++;
	}
	/**
	 * getBase return the current value of the triangle's base
	 * @return the current base
	 */
	public double getBase()
	{
		return this._base;
	}
	/**
	 * set base change the current base to newBase
	 * @param newBase : represents the value of the base
	 */
	public void setBase(double newBase)
	{
		this._base = newBase;
	}

	public double getHight()
	{
		return this._height;
	}
	public void setHight(double newHight)
	{
		this._height = newHight;
	}
	/**
	 * calcTriArea calculates and returns the area of the triangle
	 * @return the area of the triangle
	 */
	public double calcTriArea()
	{
		return (this._base * this._height) / 2;
	}
}
