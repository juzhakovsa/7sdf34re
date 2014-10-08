
package de.jreality.shader;

import java.io.Serializable;

public class Color implements Serializable {
	
	private float r,g,b,a;
	
	public float[] getRGBComponents(float[] dest){
		if(dest != null && dest.length != 4){
			System.err.println("wrong dimension of color array");
			return null;
		}
		if(dest != null){
			dest[0] = r;
			dest[1] = g;
			dest[2] = b;
			dest[3] = a;
		}
		float[] ret = new float[4];
		ret[0] = r;
		ret[1] = g;
		ret[2] = b;
		ret[3] = a;
		return ret;
	}
	public float[] getComponents(float[] dest){
		return getRGBComponents(dest);
	}
	public static Color yellow = new Color(255, 255, 0, 1);
	public static Color cyan = new Color(0, 255, 255, 1);
	public static Color magenta = new Color(255, 0, 255, 1);
	public static Color red = new Color(255, 0, 0, 1);
	public static Color blue = new Color(0, 0, 255, 1);
	public static Color green = new Color(0, 128, 0, 1);
	public static Color white = new Color(255, 255, 255, 1);
	public static Color black = new Color(0, 0, 0, 1);
	public static Color gray = new Color(128, 128, 128, 1);
	public static Color light_gray = new Color(211, 211, 211, 1);
	public static Color pink = new Color(255, 192, 203, 1);
	public static Color orange = new Color(255, 165, 0, 1);
	
	public static Color ORANGE = orange;
	public static Color PINK = pink;
	public static Color LIGHT_GRAY = light_gray;
	public static Color YELLOW = yellow;
	public static Color CYAN = cyan;
	public static Color MAGENTA = magenta;
	public static Color RED = red;
	public static Color BLUE = blue;
	public static Color GREEN = green;
	public static Color WHITE = white;
	public static Color BLACK = black;
	public static Color GRAY = gray;
	
//	public Color(){
//		r = 1;
//		b = 1;
//		g = 1;
//		a = 1;
//	}
	
	public static Color toColor(Object o){
		if(o.getClass().equals(Color.class)){
			System.out.println("Info: simply copying the jReality Color object");
			return (Color) o;
		}else{
			if(o.getClass().getName().equals("java.awt.Color")){
				System.out.println("Info: found old java.awt.Color object. Converting to jReality Color object");
				Class parameterTypes[] = new Class[1];
				parameterTypes[0] = float[].class;
				try {
					java.lang.reflect.Method m = o.getClass().getMethod("getRGBComponents", parameterTypes);
					float[] colors = new float[4];
					m.invoke(o, colors);
					return new Color(colors[0], colors[1], colors[2], colors[3]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}else{
				System.err.println("Trying to convert something that is not a Color to Color");
				return null;
			}
		}
	}
	
	public Color(int r, int g, int b){
		if (r > 255) r = 255;
		if(r < 0) r = 0;
		if (g > 255) g = 255;
		if(g < 0) g = 0;
		if (b > 255) b = 255;
		if(b < 0) b = 0;
		this.r = r/255f;
		this.g = g/255f;
		this.b = b/255f;
		this.a = 1;
	}
	public Color(float r, float g, float b){
		if (r > 1f) r = 1f;
		if(r < 0f) r = 0f;
		if (g > 1f) g = 1f;
		if(g < 0f) g = 0f;
		if (b > 1f) b = 1f;
		if(b < 0f) b = 0f;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1;
	}
	public Color(float r, float g, float b, float a){
		if (r > 1f) r = 1f;
		if(r < 0f) r = 0f;
		if (g > 1f) g = 1f;
		if(g < 0f) g = 0f;
		if (b > 1f) b = 1f;
		if(b < 0f) b = 0f;
		if (a > 1f) a = 1f;
		if(a < 0f) a = 0f;
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}
	public Color(int rgb) {
		// TODO Auto-generated constructor stub
	}
	public int getGreen() {
		return Math.round(g*255);
	}
	public int getBlue() {
		return Math.round(b*255);
	}
	public int getRed() {
		return Math.round(r*255);
	}
	public int getAlpha() {
		return Math.round(a*255);
	}
	public float[] getRGBColorComponents(float[] dest) {
		if(dest != null && dest.length != 3){
			System.err.println("wrong dimension of color array");
			return null;
		}
		if(dest != null){
			dest[0] = r;
			dest[1] = g;
			dest[2] = b;
		}
		float[] ret = new float[3];
		ret[0] = r;
		ret[1] = g;
		ret[2] = b;
		return ret;
	}
	public float[] getColorComponents(float[] dest) {
		return getRGBComponents(dest);
	}
	public Color brighter(){
		return new Color(1.1f*r, 1.1f*g, 1.1f*b, a);
	}
	public Color darker(){
		return new Color(0.9f*r, 0.9f*g, 0.9f*b, a);
	}
	public static Color getHSBColor(float h, float s, float b) {
		//java.awt.Color javadoc says that hueAngle is found as follows
		float hueAngle = 360*(h-(float)Math.floor(h));
		//calculation according to English wikipedia article on HSL and HSV
		float hP = hueAngle/60;
		float Chroma = s*b;
		float X = Chroma*(1-Math.abs(hP%2-1));
		float m = b-Chroma;
		if(hP < 1)
			return new Color(Chroma+m, X+m, 0+m);
		if(hP < 2)
			return new Color(X+m, Chroma+m, 0+m);
		if(hP < 2)
			return new Color(0+m, Chroma+m, X+m);
		if(hP < 2)
			return new Color(0+m, X+m, Chroma+m);
		if(hP < 2)
			return new Color(X+m, 0+m, Chroma+m);
		return new Color(Chroma+m, 0+m, X+m);
	}
	public int getRGB() {
		return Math.round(b*255)+Math.round(g)*256+Math.round(r)*256*256+Math.round(a)*256*256*256;
	}
	
}
