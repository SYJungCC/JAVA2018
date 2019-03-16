package application;

public enum Directions {
	NORTH("north"),
	EAST("east"),
	SOUTH("south"),
	WEST("west"); // The semi-colon is optional

	private String _displayName;

	/**
	 * Constrot to initionalze the enum ytpe
	 * @param name
	 */

	public String getDisplayName(){
		return _displayName;
	}
	//I should make private // must .
	private Directions(String name)
	{
		_displayName = name;
	}
}//end of the Driection
