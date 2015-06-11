package compilator.content;

/** A text file in an array. Thanks cap'tain obvious. */
public class FileArray {

    private String[] lines;

    /** Unique constructor */
    public FileArray(String[] lines) {
	this.lines = lines;
    }

    /**
     * Shouldn't be used, Very high RAM uasge
     * 
     * @deprecated
     * */
    public String[] getfullarray() {
	return this.lines;
    }

    /** Gets the line you want in the file. */
    public String getline(int line) {
	try {
	    return this.lines[line - 1];
	} catch (Exception e) {
	    System.err
		    .println("Warning : your file has ended unexpectedly. please specify the end of scripts using the control:Stop statement.");
	    main.Main.getEMU().ran = true;
	    return "";
	    // Returns an empty string, because empty Strings are interpreted as
	    // blank lines by the emulator.
	}

    }
}
