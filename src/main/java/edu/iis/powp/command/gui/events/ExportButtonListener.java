package edu.iis.powp.command.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import edu.iis.powp.command.database.CommandDatabase;

public class ExportButtonListener implements ActionListener {

	private CommandDatabase db;
	
	public ExportButtonListener(CommandDatabase db){
		this.db = db;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			db.getMainGroup().saveToFile();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
