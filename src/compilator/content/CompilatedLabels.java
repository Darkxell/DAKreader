package compilator.content;

import exceptions.NoBracketsOccurenceException;

public class CompilatedLabels {

    /** the variables, stored in a resizable array */
    private Label[] labels;

    /** Initialize the list (builds the object) */
    public CompilatedLabels() {
	this.labels = new Label[0];
    }

    /**
     * Gets the lines of a file and Compiles the labels in a CompilatedLabels
     * list object.
     * 
     * @param fullfile
     *            the lines of the file you want to compile the labels of, in an
     *            array. Each line should be a pointer in the array.
     */
    public CompilatedLabels(String[] fullfile) {
	this.labels = new Label[0];
	String currentline;
	for (int i = 0; i < fullfile.length; i++) {
	    currentline = fullfile[i];
	    if (main.StringMatcher.stringMatch(currentline, "control:*;")
		    | main.StringMatcher
			    .stringMatch(currentline, "*control:*;"))
		if (main.StringMatcher.stringMatch(currentline,
			"*setlabel(*)*;")
			| main.StringMatcher.stringMatch(currentline,
				"*setlabel(*);")) {
		    try {
			this.addlabel(new Label(main.StringMatcher
				.getAbsoluteContent(main.StringMatcher
					.getBracketsContent(currentline, 1)),
				(i + 1)));
		    } catch (NoBracketsOccurenceException e) {
			System.err.println("ERROR :");
			System.err.println("Unable to add a Label at line "
				+ (i + 1));
		    }
		}
	}

    }

    /** adds a label to the list. */
    public void addlabel(Label lbl) {
	Label[] temp = this.labels;
	int prevlength = temp.length;
	Label[] newarray = new Label[prevlength + 1];
	for (int i = 0; i < prevlength; i++) {
	    newarray[i] = temp[i];
	}
	newarray[prevlength] = lbl;
	this.labels = newarray;
    }

    /** adds a label to the list. */
    public void addlabel(String name, int line) {
	Label[] temp = this.labels;
	int prevlength = temp.length;
	Label[] newarray = new Label[prevlength + 1];
	for (int i = 0; i < prevlength; i++) {
	    newarray[i] = temp[i];
	}
	newarray[prevlength] = new Label(name, line);
	this.labels = newarray;
    }

    /** get the line of the asked label name */
    public int getvariable(String name) {
	for (int i = 0; i < labels.length; i++) {
	    if (labels[i].name == name)
		return labels[i].line;
	}
	return 0;
    }

    /** Gets the ammount of labels in the list */
    public int getlabelammount() {
	return this.labels.length;
    }
}
