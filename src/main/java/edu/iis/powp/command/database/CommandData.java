package edu.iis.powp.command.database;

import edu.iis.powp.command.*;

public class CommandData {

	private String type;
	private int x, y;
	
	public CommandData(IPlotterCommand command){
		if (command instanceof DrawToCommand){
			type = "DrawToCommand";
			DrawToCommand cmd = (DrawToCommand)command;
			x = cmd.getPosX();
			y = cmd.getPosY();
		} else if (command instanceof SetPositionCommand){
			type = "SetPositionCommand";
			SetPositionCommand cmd = (SetPositionCommand)command;
			x = cmd.getPosX();
			y = cmd.getPosY();
		}
	}
	
	public IPlotterCommand getCommand(){
		if (type.equals("DrawToCommand"))
			return new DrawToCommand(x, y);
		else if (type.equals("SetPositionCommand"))
			return new SetPositionCommand(x, y);
		else
			return null;
	}
}
