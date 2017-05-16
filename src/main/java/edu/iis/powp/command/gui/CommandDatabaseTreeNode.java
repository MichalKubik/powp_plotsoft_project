package edu.iis.powp.command.gui;

import javax.swing.tree.DefaultMutableTreeNode;

import edu.iis.powp.command.database.CommandDatabaseComponent;

public class CommandDatabaseTreeNode extends DefaultMutableTreeNode
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CommandDatabaseComponent databaseComponent;

	public CommandDatabaseTreeNode(CommandDatabaseComponent component)
	{
		super(component.getName());
		this.databaseComponent = component;
	}
	
	public CommandDatabaseComponent getDatabaseComponent()
	{
		return databaseComponent;
	}
}
