package edu.iis.powp.command.database;

import edu.iis.powp.observer.Publisher;

/**
 * Main class for database
 */
public class CommandDatabase
{
	private CommandGroup mainGroup;
	private static Publisher changePublisher = new Publisher(); 

	/**
	 * Main class constructor
	 */
	public CommandDatabase()
	{
		this.mainGroup = new CommandGroup("Command Database");
	}
	
	/**
	 * Adds component to main list.
	 * @param component	component to be added to main list
	 * @throws NullPointerExpection if component is null
	 */
	public void addComponent(CommandDatabaseComponent component) throws NullPointerException
	{
		mainGroup.addComponent(component);
		changePublisher.notifyObservers();
	}

	/**
	 * Removes component from main list.
	 * @param component	component to be removed from main list
	 */
	public void removeComponent(CommandDatabaseComponent component)
	{
		mainGroup.removeComponent(component);
		changePublisher.notifyObservers();
	}
	
	
	/**
	 * Returns size of main list.
	 * @return	size of main list
	 */
	public int size()
	{
		return mainGroup.size();
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
	
	/** Returns change publisher.
	 * @return	change publisher
	 */
	public static Publisher getChangePublisher() {
		return changePublisher;
	}
	
	/** Returns main group.
	 * @return	main group
	 */
	public CommandGroup getMainGroup(){
		return mainGroup;
	}

}
