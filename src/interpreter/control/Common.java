package interpreter.control;

import emulator.content.Variable;
import exceptions.NoBracketsOccurenceException;

public class Common {

    /** Stops the emulator from running. */
    public static void stop() {
	main.Main.getEMU().ran = true;
    }

    /** GOTO method. Changes the running pointer to a compiled label. */
    public static void gotoLine(String line) {
	try {
	    String[] param = main.StringMatcher
		    .getparametters(main.StringMatcher.getBracketsContent(line,
			    1));
	    int to = main.Main.getEMU().getcode().getLabelReference(param[0]);
	    main.Main.getEMU().nextline = to;
	} catch (NoBracketsOccurenceException e) {
	    System.err.println("Error : GOTO can't be read.");
	    e.printStackTrace();
	}
    }

    /** Wait for the specified ammount of time in seconds. */
    public static void wait(String codeLine) {
	try {
	    String[] param = main.StringMatcher
		    .getparametters(main.StringMatcher.getBracketsContent(
			    codeLine, 1));
	    float time = Variable.getValueOf(param[0]);
	    main.Main.wait(time);
	} catch (Exception e) {
	    System.err.println("Error : Can't wait for the specified time.");
	    e.printStackTrace();
	}
    }
}
