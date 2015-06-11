package interpreter.control;

import interpreter.ParentInterpreter;

public class I_control extends ParentInterpreter {

    public I_control() {
    }

    public void execute(String codeLine) {
	// io: stop() ;
	if (main.StringMatcher.stringMatch(codeLine, "stop()")
		| main.StringMatcher.stringMatch(codeLine, "stop")) {
	    Common.stop();
	}
	// io: setlabel(name) ;
	if (main.StringMatcher.stringMatch(codeLine, "setlabel(*)")) {
	    // Don't do anything if already compiled.
	}
	// io: goto(name) ;
	if (main.StringMatcher.stringMatch(codeLine, "goto(*)")) {
	    Common.gotoLine(codeLine);
	}
	// io: wait(time_s) ;
	if (main.StringMatcher.stringMatch(codeLine, "wait(*)")) {
	    Common.wait(codeLine);
	}

    }

}
