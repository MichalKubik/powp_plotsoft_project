package edu.iis.powp.command.database;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

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
	 * Returns new Command object based on another ICompoundCommand object.
	 * @param compoundCommand	ICompoundCommand object used to build new Command
	 * @return new Command object
	 */
	public static Command getCommandFromICompoundCommand(ICompoundCommand compoundCommand)
	{
		final Command C = new Command(compoundCommand.toString());

		Iterator<IPlotterCommand> iterator = compoundCommand.iterator();
		while(iterator.hasNext())
		{
			Object plotterCommand = iterator.next();
			C.add((IPlotterCommand)plotterCommand);		
		}
		
		return C;
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
	
	@Override
	public void saveToFile() throws IOException {
		FileWriter writer = new FileWriter("data/" + name + ".json");
		CommandDataList cdl = getCommandData();
		writer.append(new Gson().toJson(cdl));
		writer.close();
	}
	
	public static Command readFromFile(String path) throws IOException {
		File file = new File(path);
		FileReader reader = new FileReader(file);
		String name = file.getName();
		name = name.substring(0, name.length() - 5);
		CommandDataList cdl = new Gson().fromJson(reader, CommandDataList.class);
		return new Command(name, cdl.getCommandList());
	}
	
	private CommandDataList getCommandData(){
		CommandDataList cdl = new CommandDataList();
		plotterCommands.forEach(cmd -> {
			if (cmd instanceof ICompoundCommand){
				Iterator<IPlotterCommand> it = ((ICompoundCommand) cmd).iterator();
				while(it.hasNext()){
					cdl.add(new CommandData(it.next()));
				}
			}
			else {
				cdl.add(new CommandData(cmd));
			}
			
		});
		return cdl;
	}
}
