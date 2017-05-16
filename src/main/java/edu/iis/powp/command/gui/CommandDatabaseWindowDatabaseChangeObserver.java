package edu.iis.powp.command.gui;

import edu.iis.powp.observer.Subscriber;

public class CommandDatabaseWindowDatabaseChangeObserver implements Subscriber
{
	
	private CommandDatabaseWindow commandDatabaseWindow;
	
	public CommandDatabaseWindowDatabaseChangeObserver(CommandDatabaseWindow window)
	{
		this.commandDatabaseWindow = window;
	}

	@Override
	public void update() 
	{
		this.commandDatabaseWindow.updateTree();
		
	}

}
