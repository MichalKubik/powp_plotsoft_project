package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.database.Command;
import edu.iis.powp.command.database.CommandDatabase;
import edu.iis.powp.command.database.CommandGroup;

public class SelectGenerateDatabase implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e)
	{
	CommandDatabase db = FeaturesManager.getCommandDatabase();
		
		CommandGroup basicCommands = new CommandGroup("Basic commands");
			CommandGroup triangleCommands = new CommandGroup("Triangles");
				Command acuteAngledTriangle = new Command("Acute-angled triangle");
					acuteAngledTriangle.add(new SetPositionCommand(0,0));
					acuteAngledTriangle.add(new DrawToCommand(-150, 20));
					acuteAngledTriangle.add(new DrawToCommand(-75, 200));
					acuteAngledTriangle.add(new DrawToCommand(0,0));
				triangleCommands.addComponent(acuteAngledTriangle);
				Command rightAngledTriangle = new Command("Right-angled triangle");
					rightAngledTriangle.add(new SetPositionCommand(0, 0));
					rightAngledTriangle.add(new DrawToCommand(150, 0));
					rightAngledTriangle.add(new DrawToCommand(0, 150));
					rightAngledTriangle.add(new DrawToCommand(0, 0));
				triangleCommands.addComponent(rightAngledTriangle);
			basicCommands.addComponent(triangleCommands);
			Command square = new Command("Square");
				square.add(new SetPositionCommand(-50,-50));
				square.add(new DrawToCommand(50,-50));
				square.add(new DrawToCommand(50,50));
				square.add(new DrawToCommand(-50,50));
				square.add(new DrawToCommand(-50,-50));
			basicCommands.addComponent(square);
			Command rectangle = new Command("Rectangle");
				rectangle.add(new SetPositionCommand(-75,-100));
				rectangle.add(new DrawToCommand(75,-100));
				rectangle.add(new DrawToCommand(75,100));
				rectangle.add(new DrawToCommand(-75,100));
				rectangle.add(new DrawToCommand(-75,-100));
			basicCommands.addComponent(rectangle);
		db.addComponent(basicCommands);
		
		CommandGroup randomLines = new CommandGroup("Random lines");
			Command lines1 = new Command("Random lines 1");
				lines1.add(new SetPositionCommand(-250,190));
				lines1.add(new DrawToCommand(-250, -190));
				lines1.add(new SetPositionCommand(-180,190));
				lines1.add(new DrawToCommand(-180, -190));
				lines1.add(new SetPositionCommand(-110,190));
				lines1.add(new DrawToCommand(-110, -190));
				lines1.add(new SetPositionCommand(-40,190));
				lines1.add(new DrawToCommand(-40, -190));
			randomLines.addComponent(lines1);
			Command lines2 = new Command("Random lines 2");
				lines2.add(new SetPositionCommand(34, -132));
				lines2.add(new DrawToCommand(-34, 45));
				lines2.add(new DrawToCommand(53, 66));
				lines2.add(new DrawToCommand(50, -74));
				lines2.add(new DrawToCommand(94, 56));
				lines2.add(new DrawToCommand(156, -250));
			randomLines.addComponent(lines2);
			Command lines3 = new Command("Random lines 3");
				lines3.add(new SetPositionCommand(34, 55));
				lines3.add(new DrawToCommand(-150, -150));
				lines3.add(new SetPositionCommand(130, 130));
				lines3.add(new DrawToCommand(70,70));
				lines3.add(new SetPositionCommand(36, 53));
				lines3.add(new DrawToCommand(90, -56));
			randomLines.addComponent(lines3);
			Command lines4 = new Command("Random lines 4");
				lines4.add(new SetPositionCommand(30, -220));
				lines4.add(new DrawToCommand(30, 0));
				lines4.add(new SetPositionCommand(180, -70));
				lines4.add(new DrawToCommand(180, 190));
				lines4.add(new SetPositionCommand(-110, -50));
				lines4.add(new DrawToCommand(-110, 70));
			randomLines.addComponent(lines4);
		db.addComponent(randomLines);
		
		CommandGroup advancedCommands = new CommandGroup("Advanced commands");
			Command linesCommand = new Command("Lines");
				linesCommand.add(lines1);
				linesCommand.add(lines2);
				linesCommand.add(lines3);
			advancedCommands.addComponent(linesCommand);
			Command trianglesCommand = new Command("Triangles");
				trianglesCommand.add(acuteAngledTriangle);
				trianglesCommand.add(rightAngledTriangle);
			advancedCommands.addComponent(trianglesCommand);
			Command rectangleAndSquare = new Command("Rectangle and square");
				rectangleAndSquare.add(rectangle);
				rectangleAndSquare.add(square);
			advancedCommands.addComponent(rectangleAndSquare);
		db.addComponent(advancedCommands);
	}
}
