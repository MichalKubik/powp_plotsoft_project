package edu.iis.powp.command.gui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;
import edu.iis.powp.command.database.Command;
import edu.iis.powp.command.database.CommandDatabase;

public class ImportButtonListener implements ActionListener {

	private CommandDatabase db;
	
	public ImportButtonListener(CommandDatabase db){
		this.db = db;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get("data"));
			Iterator<Path> it = dir.iterator();
			while(it.hasNext()){
				Path path = it.next();
				Command cmd = Command.readFromFile(path.toString());
				db.addComponent(cmd);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
