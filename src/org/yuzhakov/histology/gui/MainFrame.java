package org.yuzhakov.histology.gui;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private JPanel mainPanel;
	public MainFrame() {
		super("Histology 3D");
		
		setJMenuBar(new MainMenuBar());
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(new NodeToolBar(), BorderLayout.PAGE_START);
		mainPanel.add(new JRealityComponent(), BorderLayout.CENTER);
		
		add(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	validate();
    	pack();
    	setVisible(true);
	}
}
