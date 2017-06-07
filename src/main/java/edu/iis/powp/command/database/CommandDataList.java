package edu.iis.powp.command.database;

import java.util.*;
import edu.iis.powp.command.IPlotterCommand;

public class CommandDataList {

	private ArrayList<CommandData> commandDataList;

	public CommandDataList(){
		commandDataList = new ArrayList<>();
	}
	
	public boolean add(CommandData e) {
		return commandDataList.add(e);
	}

	public List<IPlotterCommand> getCommandList(){
		ArrayList<IPlotterCommand> commandList = new ArrayList<>();
		commandDataList.forEach(data -> commandList.add(data.getCommand()));
		return commandList;
	}
}
