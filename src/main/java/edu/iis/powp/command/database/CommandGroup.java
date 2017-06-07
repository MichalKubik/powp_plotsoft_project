package edu.iis.powp.command.database;

import java.util.ArrayList;
import java.util.List;

/**
 *	Class for group of commands
 */
public class CommandGroup extends CommandDatabaseComponent
{
	private List<CommandDatabaseComponent> components;
	
	/**
	 * Main constructor
	 */
	public CommandGroup()
	{
		this.components = new ArrayList<CommandDatabaseComponent>();
	}
	
	/**
	 * Constructor with name
	 */
	public CommandGroup(String name)
	{
		this();
		this.name = name;
	}
	
	/**
	 * Adds component to group.
	 * @param component	component to be added to group
	 * @throws NullPointerExpection if component is null
	 */
	public void addComponent(CommandDatabaseComponent component) throws NullPointerException
	{
		this.components.add(component);
		CommandDatabase.getChangePublisher().notifyObservers();
	}

	/**
	 * Removes component from group.
	 * @param component	component to be removed from group
	 */
	public void removeComponent(CommandDatabaseComponent component)
	{
		this.components.remove(component);
		CommandDatabase.getChangePublisher().notifyObservers();
	}
	
	/**
	 * Returns size of group.
	 * @return	size of group
	 */
	public int size()
	{
		return this.components.size();
	}
	
	/**
	 * Returns component from main list.
	 * @param index	index of component to return
	 * @return	component at specific position on main list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public CommandDatabaseComponent getComponent(int index) throws IndexOutOfBoundsException
	{
		return this.components.get(index);
	}
	
	/**
	 * Returns list of commands matching the name.
	 * @param query	name being searched
	 * @return	ArrayList of commands
	 */
	public ArrayList<Command> filterCommandsByName(String query)
	{
		ArrayList<Command> returnList = new ArrayList<Command>();
		
		int n = components.size();
		for(int i=0; i<n; i++)
		{
			CommandDatabaseComponent c = components.get(i);
			if(c instanceof CommandGroup)
			{
				returnList.addAll(((CommandGroup) c).filterCommandsByName(query));
			} else if(c instanceof Command)
			{
				if(c.getName().toLowerCase().contains(query.toLowerCase()))
					returnList.add((Command)c);
			}
		}		
		
		return returnList;
	}
	
}
