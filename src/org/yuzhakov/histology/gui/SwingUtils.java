package org.yuzhakov.histology.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SwingUtils {
	public static JButton makeNavigationButton(String imageName, String actionCommand,
			String toolTipText) {
		// Look for the image.
		String imgLocation = "res/icons/"
				+ imageName + ".gif";

		// Create and initialize the button.
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.setSize(24, 24);

		ImageIcon icon = new ImageIcon(imgLocation);
		button.setIcon(icon);

		return button;
	}
}
