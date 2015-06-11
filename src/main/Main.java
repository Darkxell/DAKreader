/**Main package.*/
package main;

import java.io.FileInputStream;
import java.util.Scanner;

import emulator.DAKemu;

/** Main is a static class and MUST NOT be instancied as an object in any case. */
public class Main {

    /** A pointer to the emulator object */
    private static DAKemu content;

    /** Gets the current emulator running from anywhere. */
    public static DAKemu getEMU() {
	return content;
    }

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	System.out
		.println("---------------------------------------------------------------------");
	System.out
		.println("DAK reader launched. Please input the link to your .dak file to open.");
	System.out
		.println("---------------------------------------------------------------------");

	// C:\Users\Darkxell_mc\Desktop\file.dak
	boolean canlaunch = true;
	try {
	    String filepath = sc.next();
	    try {
		FileInputStream fis = new FileInputStream(filepath);
		fis.close();
	    } catch (Exception e) {
		System.err
			.println("Error : The specified file can't be accessed.\n This thread will be terminated.");
		canlaunch = false;
	    }
	    if (canlaunch) {
		DAKemu emulator = new DAKemu(filepath);
		emulator.compile();
		content = emulator;
		System.out
			.println("Compilation Finished. Launching your file!");
		content.launch();
	    }
	} catch (Exception e) {
	    System.err.println("FATAL ERROR");
	    System.err
		    .println("Sorry, something weird happenned and the emulator was forced to close.");
	    System.err.println(e);
	}
	sc.close();
	// END OF SCRIPT
    }

    /** Waits for the specified ammount of time, in seconds. */
    public static void wait(float time) {
	 int militime = (int) (time*1000) ;
	 long start = System.currentTimeMillis();
	 long release = start + militime;
	 for (; release > System.currentTimeMillis(););
    }
}
