package edu.iis.powp.command.gui.events;

import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import edu.iis.powp.command.database.Command;
import edu.iis.powp.command.database.CommandGroup;
import edu.iis.powp.command.gui.CommandDatabaseTreeNode;
import edu.iis.powp.command.gui.CommandDatabaseWindow;

public class SearchTextFieldChangeListener implements DocumentListener
{

	private CommandDatabaseWindow window;
	
	public SearchTextFieldChangeListener(CommandDatabaseWindow window) {
		this.window = window;
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		handleChange(e);		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		handleChange(e);		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		handleChange(e);		
	}
	
	private void handleChange(DocumentEvent e)
	{
		String query = window.getSearchTextField().getText();
		
		if(query.isEmpty())
			window.updateTree();
		else
		{
			ArrayList<Command> commandsFoundBySearch = window.getDatabase().getMainGroup().filterCommandsByName(query);
			
			window.getTree().setModel(null);
			DefaultMutableTreeNode top = new CommandDatabaseTreeNode(new CommandGroup("Search results"));
			window.getTree().setModel(new DefaultTreeModel(top));
			
			for(int i=0;i<commandsFoundBySearch.size();i++)
			{
				CommandDatabaseTreeNode node = new CommandDatabaseTreeNode(commandsFoundBySearch.get(i));
				top.add(node);			
			}
			
			window.getTree().expandRow(0);
		}
	}

}
