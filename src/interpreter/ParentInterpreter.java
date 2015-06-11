package interpreter;

/**
 * Useless yet, might be useful later on. Any sub Interpreter should extends
 * this parent class.
 */
public abstract class ParentInterpreter {

    /**
     * Executes a line of dak code in the current sub interpreter. Note that the
     * code must be readable by this exact sub interpreter.
     */
    public abstract void execute(String codeLine);

}
