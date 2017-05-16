package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.database.Command;
import edu.iis.powp.command.database.CommandDatabase;
import edu.iis.powp.command.database.CommandGroup;

public class SelectGenerateDatabase implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		CommandDatabase db = FeaturesManager.getCommandDatabase();
		
		CommandGroup group1 = new CommandGroup("Group1");
		db.addComponent(group1);
		group1.addComponent(new CommandGroup("Group in group"));
		group1.addComponent(new Command("Command1"));
		group1.addComponent(new Command("Command2"));
		db.addComponent(new CommandGroup("Group2"));
		db.addComponent(new Command("Command3"));
		
		

	}
}
