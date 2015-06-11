package compilator;

import java.io.File;

import compilator.content.CompilatedLabels;
import compilator.content.FileArray;
import compilator.content.FileInitializer;

public class CompilatedCode {

	/**
	 * Uncompiled lines. Hum. Yes. Perhaps I should code a real compiler. But
	 * don't foreget i'm lazy, and this do the most a real compiler would do,
	 * so... Yeah. I'm not feeling the mood to code thousends of lines...
	 * */
	private FileArray sourcecode;
	/** Compilated Labels of the .dak source code */
	private CompilatedLabels labels;

	/** Compilated Code constructor, using a File object. */
	@SuppressWarnings("deprecation")
	public CompilatedCode(File file) {
		FileInitializer fiz = new FileInitializer(file);
		this.sourcecode = fiz.getfilearray();
		this.labels = new CompilatedLabels(
				this.sourcecode.getfullarray());
	}

	/** Gets the specified (uncompiled) line of .dak code */
	public String getCodeLine(int line) {
		return this.sourcecode.getline(line);
	}
	
	/** Get the line reference of the specified Label name */
	public int getLabelReference(String name){
		return this.labels.getvariable(name);
	}

}
