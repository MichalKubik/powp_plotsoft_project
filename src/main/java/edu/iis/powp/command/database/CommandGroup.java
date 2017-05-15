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
	}

	/**
	 * Removes component from group.
	 * @param component	component to be removed from group
	 */
	public void removeComponent(CommandDatabaseComponent component)
	{
		this.components.remove(component);
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

}
