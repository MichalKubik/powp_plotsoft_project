package edu.iis.powp.command.database;

/**
 * Main class for database
 */
public class CommandDatabase
{
	private CommandGroup mainGroup;

	/**
	 * Main class constructor
	 */
	public CommandDatabase()
	{
		this.mainGroup = new CommandGroup();
	}
	
	/**
	 * Adds component to main list.
	 * @param component	component to be added to main list
	 * @throws NullPointerExpection if component is null
	 */
	public void addComponent(CommandDatabaseComponent component) throws NullPointerException
	{
		mainGroup.addComponent(component);
	}

	/**
	 * Removes component from main list.
	 * @param component	component to be removed from main list
	 */
	public void removeComponent(CommandDatabaseComponent component)
	{
		mainGroup.removeComponent(component);
	}
	
	/**
	 * Returns component from main list.
	 * @param index	index of component to return
	 * @return	component at specific position on main list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public CommandDatabaseComponent getComponent(int index) throws IndexOutOfBoundsException
	{
		return mainGroup.getComponent(index);
	}

}
