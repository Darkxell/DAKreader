package emulator.content.vars;


public class VarList {

    /** the variables, stored in a resizable array */
    private Variable[] variables;

    /** Initialize the list (builds the object) */
    public VarList() {
	this.variables = new Variable[0];
    }

    /** adds a variable to the list. */
    public void addvariable(Variable var) {
	Variable[] temp = this.variables;
	int prevlength = temp.length;
	Variable[] newarray = new Variable[prevlength + 1];
	for (int i = 0; i < prevlength; i++) {
	    newarray[i] = temp[i];
	}
	newarray[prevlength] = var;
	this.variables = newarray;
    }

    /** adds a variable to the list. */
    public void addvariable(String name, float value) {
	Variable[] temp = this.variables;
	int prevlength = temp.length;
	Variable[] newarray = new Variable[prevlength + 1];
	for (int i = 0; i < prevlength; i++) {
	    newarray[i] = temp[i];
	}
	Variable var = new Variable(name, value);
	newarray[prevlength] = var;
	this.variables = newarray;

    }

    /** return if a variable of this name exists in the list */
    public boolean testvariable(String varname) {
	for (int i = 0; i < variables.length; i++) {
	    if (variables[i].name.contentEquals(varname))
		return true;
	}
	return false;
    }

    /** get the value of the variable name */
    public float getvariable(String varname) {
	for (int i = 0; i < variables.length; i++) {
	    if (variables[i].name.contentEquals(varname))
		return variables[i].value;
	}
	System.err.println("ERROR : Unknown variable \"" + varname
		+ "\" value asked, returned 0.");
	return 0;
    }

    /** Sets a variable to the desired value in the list. */
    public void setvariable(String name, float value) {
	for (int i = 0; i < variables.length; i++) {
	    if (variables[i].name.contentEquals(name)) {
		this.variables[i].value = value ;
		return;
	    }
	}
	System.err.println("ERROR : Tried to set unknown variable \"" + name
		+ "\" to value = " + value + ". Action cancelled.");
	return;
    }
}
