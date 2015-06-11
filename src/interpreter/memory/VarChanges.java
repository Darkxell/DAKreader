package interpreter.memory;

import emulator.content.Variable;

public class VarChanges {

    /** Changes a variable value. */
    public static void changeFloat(String codeLine) {
	try {
	    String[] param = main.StringMatcher
		    .getparametters(main.StringMatcher.getBracketsContent(
			    codeLine, 1));
	    float value = Variable.getValueOf(param[1]);
	    System.out.println(value);
	    main.Main.getEMU().variables.setvariable(param[0], value );
	} catch (Exception e) {
	    System.err.println("Warning : Unable to set a variable to it's desired value.");
	}

    }

}
