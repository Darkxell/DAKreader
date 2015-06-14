package emulator;

import interpreter.Interpreter;

import java.io.File;

import javax.swing.JFrame;

import compilator.CompilatedCode;
import emulator.content.DAKgrid;
import emulator.content.vars.VarList;

/** DAKemu is a frame object that can read .dak scripts */
public class DAKemu {

    /** The Jframe object used to display the emulator */
    private JFrame frame;
    /** The emulated variable list */
    public VarList variables;
    /** A File object containing the informations about the uncompiled file. */
    private File file;
    /** A canvas-like object */
    public DAKgrid canvas;
    /** The .dak source code to read */
    private CompilatedCode code;
    /** The integred interpretor. */
    private Interpreter reader;

    /**
     * The next line that needs to be read by the interpretor. (/!\ Starts at 1,
     * not 0.)
     */
    public int nextline;
    /**
     * Is true if the emulator has finished reading the script or has read a
     * STOP statement.
     */
    public boolean ran;

    /** Builds a DAKemu frame. */
    public DAKemu(String filepath) {
	this.file = new File(filepath);
	this.variables = new VarList();
	this.ran = false;
	this.reader = new Interpreter();

	this.frame = new JFrame();
	this.frame.setResizable(false);
	this.frame.setSize(400, 200);
	this.frame.setVisible(true);
	this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.frame.setTitle(this.file.getName());
	this.canvas = new DAKgrid();
	this.frame.add(this.canvas);

    }

    /** Compiles the .dak text code into optimized runnable script */
    public void compile() {
	this.code = new CompilatedCode(this.file);
    }

    /** Starts to read the script of the emuled dak file. */
    public void launch() {
	this.nextline = 1;
	while (!ran) {
	    this.executeline(this.code.getCodeLine(this.nextline));
	    this.nextline++;
	}
	System.out.println("Script finished, closing emulator.");
	String tempname = this.frame.getTitle();
	this.frame.setTitle("(Finished) " + tempname);
    }

    /** Executes a line of .dak script. */
    private void executeline(String codeLine) {
	this.reader.execute(codeLine);
    }

    /** Gets the compilated code of the corrent emulator*/
    public CompilatedCode getcode(){
	return this.code;
    }
}
