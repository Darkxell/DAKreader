package interpreter.memory;

import exceptions.NoBracketsOccurenceException;

/** Everything about memory allocation in dak scripts. */
public class Malloc {

    /** Allocates memory for any variable. */
    public static void malloc(String line) {
	boolean error = false;
	try {
	    String temp = main.StringMatcher.getBracketsContent(line, 1);
	    String[] param = temp.split(",");
	    param[1] = main.StringMatcher.getAbsoluteContent(param[1]);
	    switch (param[1]) {
	    case "var":
		typedmalloc(line, "var");
		break;
	    case "string":
		typedmalloc(line, "string");
		break;
	    default:
		error = true;
		break;
	    }
	} catch (NoBracketsOccurenceException e) {
	    e.printStackTrace();
	    error = true;
	}
	if (error)
	    System.err
		    .println("ERROR : Can't allocate memory for an unknown variable for unknown reasons."
			    + "Make sure your type name is correct.");
    }

    /** Same as malloc(String) , but already specifies the type of the variable. */
    public static void typedmalloc(String codeLine, String type) {
	try {
	    String[] param = main.StringMatcher
		    .getparametters(main.StringMatcher.getBracketsContent(
			    codeLine, 1));
	    String varname = main.StringMatcher.getAbsoluteContent(param[0]);
	    if (varname.startsWith("$")) {
		switch (type) {
		case "var":
		    main.Main.getEMU().variables.addvariable(varname, 0f);
		    break;
		/*
		 * case "string": typedmalloc(line, "string"); break; TODO : add
		 * string memory allocation
		 */
		default:
		    System.err.println("ERROR : Unknown type \"" + type
			    + "\" for the variable \"" + varname
			    + "\". Memory can't be allocated");
		    break;
		}
	    } else {
		System.err
			.println("ERROR : Variable "
				+ varname
				+ " can't be allocated. Variables names must start whith \"$\" .");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}
