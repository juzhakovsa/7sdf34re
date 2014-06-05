package org.yuzhakov.histology;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {
	public static double round(double d){
		BigDecimal decimal = new BigDecimal(d);
		return decimal.setScale(Settings.DEFAULT_PRECISION_SCALE, RoundingMode.HALF_UP).doubleValue();
	}
}
