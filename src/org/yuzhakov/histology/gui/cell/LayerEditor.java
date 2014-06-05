package org.yuzhakov.histology.gui.cell;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

import net.miginfocom.swing.MigLayout;

public class LayerEditor extends JPanel {
	private JSpinner sizeSpinner;
	protected LayerTableModel tableModel;
	protected JTable table;

	public LayerEditor() {
		super(new MigLayout());
		sizeSpinner = new JSpinner(new SpinnerNumberModel(3, 3, 50, 1));
		sizeSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent event) {
				JSpinner spinner = (JSpinner) event.getSource();
				int size = (int) spinner.getValue();
				tableModel.setRowCount(size);
			}
		});

		tableModel = new LayerTableModel();
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		JScrollPane tablePane = new JScrollPane(table);
		
		this.add(sizeSpinner, "wrap, grow");
		this.add(tablePane);
	}

	public static class LayerTableModel extends AbstractTableModel {
		private int size = 4;

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (columnIndex == 0)
				return false;
			return true;
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public int getRowCount() {
			return size;
		}
		
		public void setRowCount(int s) {
			size = s;
			this.fireTableDataChanged();
		}

		int[][] data = new int[][] { { 11, 12, 13, 14 }, { 21, 22, 23, 24 },
				{ 31, 32, 33, 34 }, { 41, 42, 43, 44 } };

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return "" + rowIndex + " "+ columnIndex;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			data[columnIndex][rowIndex] = Integer.parseInt((String) aValue);
			super.setValueAt(aValue, rowIndex, columnIndex);
		}
		
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "X";
			case 2:
				return "Y";
			case 3:
				return "";
			default:
				return null;
			}
		}

	}
}
