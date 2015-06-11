package interpreter.io;

import emulator.content.Variable;
import exceptions.NoBracketsOccurenceException;

public class Display {

    /** sets a pixel in the integrated emulator. Uses the dak codeline syntax. */
    public static void setpixel(String codeLine) {
	try {
	    String[] param = main.StringMatcher
		    .getparametters(main.StringMatcher.getBracketsContent(
			    codeLine, 1));
	    int color = (int) Variable.getValueOf(param[2]);
	    boolean col = false;
	    if (color == 1)
		col = true;
	    main.Main.getEMU().canvas.setpixel(
		    (int) Variable.getValueOf(param[0]),
		    (int) Variable.getValueOf(param[1]), col);
	} catch (NoBracketsOccurenceException e) {
	    e.printStackTrace();
	}
    }

    /** Draws a rectangle of the specified color. */
    public static void setrectangle(String codeLine) {
	try {
	    String[] param = main.StringMatcher
		    .getparametters(main.StringMatcher.getBracketsContent(
			    codeLine, 1));
	    int color = (int) Variable.getValueOf(param[4]);
	    boolean col = false;
	    if (color == 1)
		col = true;
	    main.Main.getEMU().canvas.setrectangle(
		    (int) Variable.getValueOf(param[0]),
		    (int) Variable.getValueOf(param[1]),
		    (int) Variable.getValueOf(param[2]),
		    (int) Variable.getValueOf(param[3]), col);
	} catch (NoBracketsOccurenceException e) {
	    e.printStackTrace();
	}

    }

}
