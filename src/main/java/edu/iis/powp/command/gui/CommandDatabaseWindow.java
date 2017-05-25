package edu.iis.powp.command.gui;

import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import edu.iis.powp.command.database.CommandDatabase;
import edu.iis.powp.command.database.CommandGroup;
import edu.iis.powp.command.gui.events.ImportFromCommandManagerButtonListener;
import edu.iis.powp.command.gui.events.SearchTextFieldChangeListener;
import edu.iis.powp.command.gui.events.TreeNodeSelectionListener;
import edu.iis.powp.window.WindowComponent;

public class CommandDatabaseWindow extends JFrame implements WindowComponent {

	private CommandDatabase database;
	
	private JTree tree;
	private JTextField searchTextField;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3390064675949588490L;
	
	public CommandDatabaseWindow(CommandDatabase database)
	{
		this.setTitle("Command database");
		this.setSize(400,400);
		Container content = this.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
		
		this.database = database;
		
		JPanel searchPanel = new JPanel();
		//BoxLayout searchLayout = new BoxLayout(searchPanel, BoxLayout.LINE_AXIS);
		searchPanel.add(new JLabel("Search: "));
		searchTextField = new JTextField("", 20);
		searchTextField.getDocument().addDocumentListener(new SearchTextFieldChangeListener(this));
		searchPanel.add(searchTextField);
		content.add(searchPanel);
		
		tree = new JTree();	
		updateTree();
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeNodeSelectionListener());
		JScrollPane treeView = new JScrollPane(tree);
		treeView.setMinimumSize(new Dimension(400,300));
		content.add(treeView);
		
		JPanel bottomPanel = new JPanel();
		//BoxLayout bottomLayout = new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS);
		Button importFromCommandManagerButton = new Button("Import from CommandManager");
		importFromCommandManagerButton.addActionListener(new ImportFromCommandManagerButtonListener(database));
		bottomPanel.add(importFromCommandManagerButton);
		Button exportButton = new Button("Export");
		bottomPanel.add(exportButton);
		Button importButton = new Button("Import");
		bottomPanel.add(importButton);
		content.add(bottomPanel);
		
	}
	
	/**
	 * Updates tree view.
	 */
	public void updateTree()
	{
		tree.setModel(null);
		DefaultMutableTreeNode top = new CommandDatabaseTreeNode(database.getMainGroup());
		tree.setModel(new DefaultTreeModel(top));
		
		for(int i=0;i<database.size();i++)
		{
			CommandDatabaseTreeNode node = new CommandDatabaseTreeNode(database.getComponent(i));
			addNode(top, node);			
		}
		
		tree.expandRow(0);
	}
	
	private void addNode(DefaultMutableTreeNode parent, CommandDatabaseTreeNode child)
	{
		parent.add(child);
		if(child.getDatabaseComponent() instanceof CommandGroup)
		{
			CommandGroup c = (CommandGroup)child.getDatabaseComponent();
			for(int i=0;i<c.size();i++)
			{
				CommandDatabaseTreeNode node = new CommandDatabaseTreeNode(c.getComponent(i));
				addNode(child, node);
			}
		}
	}

	@Override
	public void HideIfVisibleAndShowIfHidden() {
		if (this.isVisible()) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}		
	}
	
	public JTree getTree(){
		return this.tree;
	}
	
	public JTextField getSearchTextField(){
		return this.searchTextField;
	}
	
	public CommandDatabase getDatabase(){
		return this.database;
	}

}
