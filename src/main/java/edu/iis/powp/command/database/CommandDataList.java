package edu.iis.powp.command.database;

import java.util.*;
import edu.iis.powp.command.IPlotterCommand;

public class CommandDataList {

	private ArrayList<CommandData> list;

	public CommandDataList(){
		list = new ArrayList<>();
	}
	
	public boolean add(CommandData e) {
		return list.add(e);
	}

	public List<IPlotterCommand> getCommandList(){
		ArrayList<IPlotterCommand> commandList = new ArrayList<>();
		list.forEach(data -> commandList.add(data.getCommand()));
		return commandList;
	}
}
