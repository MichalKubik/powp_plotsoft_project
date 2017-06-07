package edu.iis.powp.command.database;

import java.io.IOException;

/**
 *	Abstract class for database components.
 */
public abstract class CommandDatabaseComponent 
{
	String name;
	
	/**
	 * Returns name of the component.
	 * @return	name of the component
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Changes name of the component.
	 * @param name	new name for the component
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	public abstract void saveToFile() throws IOException;

}
