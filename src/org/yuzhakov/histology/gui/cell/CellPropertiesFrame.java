package org.yuzhakov.histology.gui.cell;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;

public class CellPropertiesFrame extends JFrame{
	private JPanel mainPanel;
	
	
	public CellPropertiesFrame() {
	
	super("Histology 3D");
	
		mainPanel = new JPanel(new BorderLayout());
		add(mainPanel);
		setSize(1000, 600);
		
		mainPanel.add(new LayerEditor());
		
		validate();
		pack();
		setVisible(true);
	}
}
