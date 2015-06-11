package compilator.content;

/** The label Object is a label in DAK scripts. Has public attributes. */
public class Label {

	public int line;
	public String name;

	/** Constructs a label object */
	public Label(String name, int line) {
		this.line = line;
		this.name = name;
	}

}
