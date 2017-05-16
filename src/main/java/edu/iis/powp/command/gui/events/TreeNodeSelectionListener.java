package edu.iis.powp.command.gui.events;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.database.Command;
import edu.iis.powp.command.gui.CommandDatabaseTreeNode;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class TreeNodeSelectionListener implements TreeSelectionListener
{

	@Override
	public void valueChanged(TreeSelectionEvent e) 
	{
		if(((JTree) (e.getSource())).getLastSelectedPathComponent()!=null)
		{
			CommandDatabaseTreeNode node = (CommandDatabaseTreeNode) ((JTree) (e.getSource())).getLastSelectedPathComponent();
		    
			if(node.getDatabaseComponent() instanceof Command)
			{
				PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
			    manager.setCurrentCommand(((Command) node.getDatabaseComponent()).getCommandsList(), node.getDatabaseComponent().getName());
			}	
		}
	}

}
