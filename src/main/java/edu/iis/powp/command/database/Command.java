package edu.iis.powp.command.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.ICompoundCommand;
import edu.iis.powp.command.IPlotterCommand;

/**
 * Complex command class
 */
public class Command extends CommandDatabaseComponent implements ICompoundCommand {

	private List<IPlotterCommand> plotterCommands;
	
	/**
	 * Class constructor that sets commands list.
	 * @param name	name for command
	 * @param plotterCommands	list of commands
	 */
	public Command(String name, List<IPlotterCommand> plotterCommands)
	{
		this.name = name;
		this.plotterCommands = plotterCommands;
	}
	
	/**
	 * @param name	name for command
	 */
	public Command(String name)
	{
		this.name = name;
		this.plotterCommands = new ArrayList<IPlotterCommand>();
	}
	
	/**
	 * Adds command to list of commands to execute
	 * @param command	command to add
	 * @throws NullPointerException	
	 */

	public void add(IPlotterCommand command) throws NullPointerException
	{
		this.plotterCommands.add(command);
	}
		
	@Override
	public void execute(IPlotter plotter)
	{
		plotterCommands.forEach((command) -> command.execute(plotter));
	}

	@Override
	public Iterator<IPlotterCommand> iterator()
	{
		return plotterCommands.iterator();
	}
	
	/**
	 * Returns list containing commands used in this command.
	 * @return	list with commands
	 */
	public List<IPlotterCommand> getCommandsList()
	{
		return plotterCommands;
	}

}
