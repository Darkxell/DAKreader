package interpreter.io;

import interpreter.ParentInterpreter;

public class I_io extends ParentInterpreter {

    public I_io() {
    }

    public void execute(String codeLine) {
	// io: setpixel(x,y,0/1) ;
	if (main.StringMatcher.stringMatch(codeLine, "setpixel(*,*,*)")) {
	    Display.setpixel(codeLine);
	}
	// io: setrectangle(x,y,width,height,0/1) ;
	if (main.StringMatcher.stringMatch(codeLine, "setrectangle(*,*,*,*,*)")) {
	    Display.setrectangle(codeLine);
	}

    }

}