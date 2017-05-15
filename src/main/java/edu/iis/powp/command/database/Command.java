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
public class Command implements ICompoundCommand {

	private List<IPlotterCommand> plotterCommands;
	
	public Command(List<IPlotterCommand> plotterCommands)
	{
		this.plotterCommands = plotterCommands;
	}
	
	public Command()
	{
		this.plotterCommands = new ArrayList<IPlotterCommand>();
	}
	
	/**
	 * Adds command to list of commands to execute
	 * @param command	command to add
	 */
	public void add(IPlotterCommand command)
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

}
