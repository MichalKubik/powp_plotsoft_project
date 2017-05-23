package edu.iis.powp.command.database;

import java.util.*;
import edu.iis.powp.command.IPlotterCommand;

public class CommandDataList extends ArrayList<CommandData> {

	private static final long serialVersionUID = 1L;

	public List<IPlotterCommand> getCommandList(){
		ArrayList<IPlotterCommand> commandList = new ArrayList<>();
		this.forEach(data -> commandList.add(data.getCommand()));
		return commandList;
	}
}
