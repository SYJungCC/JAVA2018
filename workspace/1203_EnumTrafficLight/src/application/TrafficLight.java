package application;

public enum TrafficLight {
	GREEN(1,"go"), //ordinal - 0 
	YELLOW(2,"be cautious!"),//ordinal - 1 
	RED(3,"stop");//ordinal - 2 

	private int _index;
	private String _description;

	public String getDescription()
	{
		return _description;
	}
	public int getIndex()
	{
		return _index;
	}
	private TrafficLight(int index , String description)
	{
		_index = index;
		_description = description;
	}

}
