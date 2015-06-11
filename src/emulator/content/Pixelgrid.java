package emulator.content;

import exceptions.PixelOutOfWindowException;

/** A grid of 400*200 pixels used in .dak files emulators */
public class Pixelgrid {

	/** the array of ON/OFF pixels */
	boolean[][] pixels;

	/** empty grid constructor */
	public Pixelgrid() {
		this.pixels = new boolean[400][200];
	}

	/** Returns the pixel state of the selected pixel */
	public boolean getpixelstate(int x, int y) throws PixelOutOfWindowException{
		return this.pixels[x][y];
	}

	/** Set the selected pixel to a desired value */
	public void setpixelstate(int x, int y, boolean state) throws PixelOutOfWindowException{
		this.pixels[x][y] = state;
	}
}
