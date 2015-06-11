package emulator.content;

/** the DAK default variable type. */
public class Variable {

    public String name;
    public float value;

    public Variable(String name, float value) {
	this.name = name;
	this.value = value;
    }

    /** Gets the value of a variable or a number in String form. */
    public static float getValueOf(String value) {
	value = main.StringMatcher.getAbsoluteContent(value);
	if (!isoperation(value)) {
	    if (value.startsWith("$")) {
		return main.Main.getEMU().variables.getvariable(value);
	    } else {
		return Float.parseFloat(value);
	    }
	} else {
	    return getarithmeticresult(value);
	}
    }

    /**
     * Recursive method to calculate mathematical operations on numbers stored
     * in strings. Fully handles addition, substraction, multiplication,
     * division of set values and variables.
     */
    private static float getarithmeticresult(String s) {
	String[] parts;
	float result = 0;
	if (main.StringMatcher.contains(s, '-')) {
	    parts = main.StringMatcher.split(s, '-');
	    result = getValueOf(parts[0]);
	    for (int i = 1; i < parts.length; i++)
		result -= getValueOf(parts[i]);
	    return result;
	} else if (main.StringMatcher.contains(s, '+')) {
	    parts = main.StringMatcher.split(s, '+');
	    result = getValueOf(parts[0]);
	    for (int i = 1; i < parts.length; i++)
		result += getValueOf(parts[i]);
	    return result;
	} else if (main.StringMatcher.contains(s, '*')) {
	    parts = main.StringMatcher.split(s, '*');
	    result = getValueOf(parts[0]);
	    for (int i = 1; i < parts.length; i++)
		result *= getValueOf(parts[i]);
	    return result;
	} else if (main.StringMatcher.contains(s, '/')) {
	    parts = main.StringMatcher.split(s, '/');
	    result = getValueOf(parts[0]);
	    for (int i = 1; i < parts.length; i++)
		result /= getValueOf(parts[i]);
	    return result;
	} else {
	    System.err
		    .println("ERROR : Unable to make arithmetic operation for this :\""
			    + s + "\"");
	    return result;
	}
    }

    /**
     * Predicate that returns true if the string in parametters contains an
     * aritmethic symbol. Included symbols : (*,-,/,+).
     */
    private static boolean isoperation(String s) {
	return (main.StringMatcher.contains(s, '+')
		| main.StringMatcher.contains(s, '*')
		| main.StringMatcher.contains(s, '/') | main.StringMatcher
		    .contains(s, '-'));
    }

}
