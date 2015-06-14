package interpreter.control;

import interpreter.ParentInterpreter;

public class I_control extends ParentInterpreter {

    public I_control() {
    }

    public void execute(String codeLine) {
	// control: stop() ;
	if (main.StringMatcher.stringMatch(codeLine, "stop()")
		| main.StringMatcher.stringMatch(codeLine, "stop")) {
	    Common.stop();
	}
	// control: setlabel(name) ;
	if (main.StringMatcher.stringMatch(codeLine, "setlabel(*)")) {
	    // Don't do anything if already compiled.
	}
	// control: goto(name) ;
	if (main.StringMatcher.stringMatch(codeLine, "goto(*)")) {
	    Common.gotoLine(codeLine);
	}
	// control: wait(time_s) ;
	if (main.StringMatcher.stringMatch(codeLine, "wait(*)")) {
	    Common.wait(codeLine);
	}
	// control: if() ;
	// TODO : implement if, then and end functions. Needs to be compiled.

    }

}
