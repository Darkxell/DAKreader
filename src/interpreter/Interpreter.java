package interpreter;

import interpreter.control.I_control;
import interpreter.io.I_io;
import interpreter.memory.I_memory;

/** An integrated interpreter object to a .dak emulator. */
public class Interpreter {

    /** Sub interpreter for control methods. */
    private I_control control;
    /** Sub interpreter for input/output methods. */
    private I_io io;
    /** Sub interpreter for memory gestion methods. */
    private I_memory memory;

    /** Basic Integrated Interpreter constructor. */
    public Interpreter() {
	this.control = new I_control();
	this.io = new I_io();
	this.memory = new I_memory();
    }

    /**
     * Executes an undefined line in the script. The line may be anything,
     * including comments, script or empty lines. Empty lines don't do anything.
     * */
    public void execute(String codeLine) {

	// For debug purposes.
	// System.out.println("---Executing line" + main.Main.getEMU().nextline
	//	+ " :");

	if (main.StringMatcher.stringMatch(codeLine, "//*;")
		| main.StringMatcher.stringMatch(codeLine, "*//*;")) {
	} else if (main.StringMatcher.stringMatch(codeLine, "control:*;")
		| main.StringMatcher.stringMatch(codeLine, "*control:*;")) {
	    this.control.execute(main.StringMatcher.getCode(codeLine));
	} else if (main.StringMatcher.stringMatch(codeLine, "io:*;")
		| main.StringMatcher.stringMatch(codeLine, "*io:*;")) {
	    this.io.execute(main.StringMatcher.getCode(codeLine));
	} else if (main.StringMatcher.stringMatch(codeLine, "memory:*;")
		| main.StringMatcher.stringMatch(codeLine, "*memory:*;")) {
	    this.memory.execute(main.StringMatcher.getCode(codeLine));
	} else if (!codeLine.isEmpty()) {
	    System.err
		    .println("Warning : unreadable line : \""
			    + codeLine
			    + "\"\n Make sure that this line is either comment or is not deadly useful in your script...");
	}

    }
}
