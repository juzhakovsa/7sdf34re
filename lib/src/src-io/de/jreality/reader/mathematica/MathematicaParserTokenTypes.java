// $ANTLR 2.7.7 (2006-11-01): "mathematica.g" -> "MathematicaLexer.java"$

/**
* this code is generated by ANTLR from the 'mathematica.g'-file
* @author Bernd Gonska
* @version 1.0
*/
package de.jreality.reader.mathematica;
import java.util.*;
import java.util.List;
import de.jreality.geometry.*;
import de.jreality.math.*;
import de.jreality.scene.data.*;
import de.jreality.scene.*;
import de.jreality.scene.SceneGraphComponent;
import de.jreality.shader.*;
import de.jreality.util.LoggingSystem;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;

public interface MathematicaParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int OPEN_BRACE = 4;
	int CLOSE_BRACE = 5;
	int COLON = 6;
	// "Graphics3D" = 7
	int OPEN_BRACKET = 8;
	int CLOSE_BRACKET = 9;
	int LITERAL_Cuboid = 10;
	int LITERAL_Sphere = 11;
	int LITERAL_Cylinder = 12;
	int LITERAL_Text = 13;
	int STRING = 14;
	int LITERAL_Point = 15;
	int LITERAL_Line = 16;
	int LITERAL_Polygon = 17;
	int LITERAL_EdgeForm = 18;
	int LITERAL_SurfaceColor = 19;
	int LITERAL_RGBColor = 20;
	int LITERAL_Hue = 21;
	int LITERAL_GrayLevel = 22;
	int LITERAL_CMYKColor = 23;
	int LITERAL_AbsolutePointSize = 24;
	int LITERAL_AbsoluteThickness = 25;
	int LITERAL_Dashing = 26;
	int LITERAL_FaceForm = 27;
	int LITERAL_PointSize = 28;
	int LITERAL_Thickness = 29;
	int LITERAL_AbsoluteDashing = 30;
	int LITERAL_Boxed = 31;
	int DDOT = 32;
	int LARGER = 33;
	int MINUS = 34;
	int LITERAL_Axes = 35;
	int LITERAL_AxesLabel = 36;
	int LITERAL_Prolog = 37;
	int LITERAL_Epilog = 38;
	int LITERAL_ViewPoint = 39;
	int LITERAL_ViewCenter = 40;
	int LITERAL_FaceGrids = 41;
	int LITERAL_Ticks = 42;
	int LITERAL_TextStyle = 43;
	int LITERAL_BoxRatios = 44;
	int LITERAL_Lighting = 45;
	int LITERAL_LightSources = 46;
	int LITERAL_AmbientLight = 47;
	int LITERAL_AxesEdge = 48;
	int LITERAL_PlotRange = 49;
	int LITERAL_DefaultColor = 50;
	int LITERAL_Background = 51;
	int LITERAL_ColorOutput = 52;
	int LITERAL_AxesStyle = 53;
	int LITERAL_BoxStyle = 54;
	int LITERAL_PlotLabel = 55;
	int LITERAL_AspectRatio = 56;
	int LITERAL_DefaultFont = 57;
	int LITERAL_PlotRegion = 58;
	int LITERAL_ViewVertical = 59;
	int LITERAL_SphericalRegion = 60;
	int LITERAL_Shading = 61;
	int LITERAL_RenderAll = 62;
	int LITERAL_PolygonIntersections = 63;
	int LITERAL_DisplayFunction = 64;
	// "Plot3Matrix" = 65
	int LITERAL_ImageSize = 66;
	int LITERAL_FormatType = 67;
	int LPAREN = 68;
	int RPAREN = 69;
	int PLUS = 70;
	int INTEGER_THING = 71;
	int STAR = 72;
	int LITERAL_I = 73;
	int DOT = 74;
	int HAT = 75;
	int BACKS = 76;
	int SLASH = 77;
	int DOLLAR = 78;
	int SMALER = 79;
	int T1 = 80;
	int T2 = 81;
	int T3 = 82;
	int T4 = 83;
	int T5 = 84;
	int T6 = 85;
	int T7 = 86;
	int T8 = 87;
	int T9 = 88;
	int ID = 89;
	int ID_LETTER = 90;
	int DIGIT = 91;
	int ESC = 92;
	int WS_ = 93;
}
