package interpreter.memory;

import interpreter.ParentInterpreter;

public class I_memory extends ParentInterpreter {

    public I_memory() {
    }

    public void execute(String codeLine) {
	// memory : malloc($name,type) ; malloc($name) ;
	// Allocating using just a name will allocate a float.
	if (main.StringMatcher.stringMatch(codeLine, "malloc(*,*)")) {
	    Malloc.malloc(codeLine);
	} else if (main.StringMatcher.stringMatch(codeLine, "malloc(*)")) {
	    Malloc.typedmalloc(codeLine, "var");
	}
	// memory: setvar($name,value) ;
	if (main.StringMatcher.stringMatch(codeLine, "setvar(*,*)")) {
	    VarChanges.changeFloat(codeLine);
	}
    }
}
