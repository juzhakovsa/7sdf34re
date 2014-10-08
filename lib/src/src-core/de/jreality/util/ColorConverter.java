package de.jreality.util;

public class ColorConverter {
	public static java.awt.Color toAwt(de.jreality.shader.Color source){
		return new java.awt.Color(source.getRGBComponents(null)[0], source.getRGBComponents(null)[1], source.getRGBComponents(null)[2], source.getRGBComponents(null)[3]);
	}
	
	public static de.jreality.shader.Color toJR(java.awt.Color source){
		return new de.jreality.shader.Color(source.getRGBComponents(null)[0], source.getRGBComponents(null)[1], source.getRGBComponents(null)[2], source.getRGBComponents(null)[3]);
	}
}
