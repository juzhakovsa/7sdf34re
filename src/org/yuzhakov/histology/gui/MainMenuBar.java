package org.yuzhakov.histology.gui;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenuBar extends JMenuBar{
	private JMenu fileMenu;
	private JMenuItem open;
	private JMenuItem exit;
	
	
	public MainMenuBar() {
		super();
		buildFileMenu();
	}
	
	private void buildFileMenu(){
		fileMenu = new JMenu("����");
		this.add(fileMenu);
		
		open = new JMenuItem("�������");
		fileMenu.add(open);
		
		exit = new JMenuItem("�����");
		fileMenu.add(exit);
	}
}
