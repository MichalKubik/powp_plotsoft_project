package edu.iis.powp.command.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.ICompoundCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.database.Command;
import edu.iis.powp.command.database.CommandDatabase;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class ImportFromCommandManagerButtonListener implements ActionListener {

	private CommandDatabase database;
	
	public ImportFromCommandManagerButtonListener(CommandDatabase database)
	{
		this.database = database;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		
		IPlotterCommand command = manager.getCurrentCommand();
		
		if(command instanceof ICompoundCommand)
			database.addComponent(Command.getCommandFromICompoundCommand((ICompoundCommand) manager.getCurrentCommand()));
		else
		{
			Command c = new Command(command.toString());
			c.add(command);
			database.addComponent(c);
		}
		
	}

}
