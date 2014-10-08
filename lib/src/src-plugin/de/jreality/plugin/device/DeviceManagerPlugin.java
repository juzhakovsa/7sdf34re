package de.jreality.plugin.device;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import de.jreality.device.jinput.component.JInputAnalog;
import de.jreality.device.jinput.component.JInputButton;
import de.jreality.plugin.basic.Scene;
import de.jreality.plugin.icon.ImageHook;
import de.jreality.plugin.scene.VRPanel;
import de.jreality.scene.tool.InputSlot;
import de.jreality.toolsystem.raw.DeviceMouse;
import de.jreality.util.NativePathUtility;
import de.jtem.jrworkspace.plugin.Plugin;
import de.jtem.jrworkspace.plugin.PluginInfo;
import de.jtem.jrworkspace.plugin.sidecontainer.widget.ShrinkPanel;
import de.jtem.jrworkspace.plugin.sidecontainer.widget.ShrinkPanel.MinSizeGridBagLayout;

public class DeviceManagerPlugin extends Plugin implements ChangeListener{

	private ShrinkPanel panel;
	JTabbedPane tabbedPane;
	
	public DeviceManagerPlugin(){
		panel = new ShrinkPanel("Device Manager");
		panel.setShrinked(false);
		panel.setIcon(getPluginInfo().icon);
		panel.add(Box.createHorizontalStrut(5));
		panel.setLayout(new MinSizeGridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(2,2,2,2);
		c.gridx = 0;
		
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Mouse", addMouse());
		tabbedPane.add("Keyboard", new JTable(2,2));
		NativePathUtility.set("jni");
		ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
		Controller[] controllers = env.getControllers();
		for (Controller ctrl : controllers) {
			tabbedPane.add(ctrl.getName(),addControllerTable(ctrl));
		}
		
		panel.add(tabbedPane,c);
		
	}
	
	private JScrollPane addMouse() {
		DeviceMouse mouse = new DeviceMouse();
		
		String[]titles = new String[]{"Identifier", "Pressed", "InputSlot"};
		//model sets title and can add rows afterwards
		DefaultTableModel model = new DefaultTableModel( titles, 0 );
		JTable table = new JTable(model);
		table.setEnabled(false);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200,200));
		jsp.setMinimumSize(jsp.getPreferredSize());
		return jsp;
	}

	private JScrollPane addControllerTable(Controller ctrl) {
		Component[] comp = ctrl.getComponents();
		String[]titles = new String[]{"Identifier", "Pressed", "InputSlot"};
		//model sets title and can add rows afterwards
		DefaultTableModel model = new DefaultTableModel( titles, 0 );
		JTable table = new JTable(model);
		table.setEnabled(false);
		
		for(int i=0;i<comp.length;i++){
			String name = comp[i].getIdentifier().getName();
			InputSlot slot = InputSlot.LEFT_BUTTON;
			Vector v = new Vector();
			v.add(name);
			if(comp[i].isAnalog()){
				double value = 0.0;
				JInputAnalog analog = new JInputAnalog(name, value, slot);
				v.add(value);
			} else {
				boolean pressed = false;
				JInputButton button = new JInputButton(name, pressed, slot);
				v.add(pressed);
			}
			v.add(slot);
			model.addRow(v);
		}

		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200,200));
		jsp.setMinimumSize(jsp.getPreferredSize());
		return jsp;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public PluginInfo getPluginInfo() {
		PluginInfo info = new PluginInfo();
		info.name = "Device Manager";
		info.vendorName = "Andre Heydt"; 
		info.icon = ImageHook.getIcon("hausgruen.png");
		info.isDynamic = false;
		return info;
	}
	
	@Override
	public void install(de.jtem.jrworkspace.plugin.Controller c) throws Exception {
		super.install(c);
		Scene scene = c.getPlugin(Scene.class);
		scene.addChangeListener(this);
		VRPanel vp = c.getPlugin(VRPanel.class);
		vp.addComponent(getClass(), panel, 4.0, "VR");
	
	}
}
