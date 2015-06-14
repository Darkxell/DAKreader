package emulator.launcher;

import java.util.Scanner;

public class Launcher {

    public static String askfile() {
	// TODO : a real launcher in a JFrame
	Scanner sc = new Scanner(System.in);
	System.out
		.println("---------------------------------------------------------------------");
	System.out
		.println("DAK reader launched. Please input the link to your .dak file to open.");
	System.out
		.println("---------------------------------------------------------------------");
	String r = sc.next();
	sc.close();
	return r;
    }

}
