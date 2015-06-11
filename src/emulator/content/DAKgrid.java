package emulator.content;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import exceptions.PixelOutOfWindowException;

/**
 * A special canvas where you can get the states of pixels. Also is only black
 * and white.
 */
public class DAKgrid extends Canvas {

    private static final long serialVersionUID = 1L;
    private Color WHITE = new Color(255, 255, 255);
    private Color BLACK = new Color(0, 0, 0);

    /** the pixels array of the frame */
    public Pixelgrid pixels;

    public DAKgrid() {
	this.pixels = new Pixelgrid();
	this.setSize(400, 200);
    }

    /**
     * the default paint method. Sets the whole canvas acorded to the Pixelgrid
     * object.
     */
    public void paint(Graphics g) {
	for (int i = 0; i < this.getWidth(); i++) {
	    for (int j = 0; j < this.getHeight(); j++) {
		try {
		    if (this.pixels.getpixelstate(i, j)) {
			g.setColor(BLACK);
			g.fillRect(i, j, 1, 1);
		    } else {
			g.setColor(WHITE);
			g.fillRect(i, j, 1, 1);
		    }
		} catch (PixelOutOfWindowException e) {
		    System.err
			    .println("PixelOutOfWindowException : Automatic repaint method tried to set an out of bound pixel at x="
				    + i + " y=" + j);

		}
	    }
	}
    }

    /**
     * Sets one pixel to the desired value
     * 
     * @param state
     *            true for black and false for white
     * */
    public void setpixel(int x, int y, boolean state) {
	try {
	    pixels.setpixelstate(x, y, state);
	    Graphics g = this.getGraphics();
	    if (state)
		g.setColor(BLACK);
	    else
		g.setColor(WHITE);
	    g.fillRect(x, y, 1, 1);
	} catch (PixelOutOfWindowException e) {
	    System.err
		    .println("PixelOutOfWindowException : You tried to set an out of bound pixel at x="
			    + x + " y=" + y);

	}
    }

    /** Gets the value of the desired pixel */
    public boolean getpixelstate(int x, int y) {
	try {
	    return this.pixels.getpixelstate(x, y);
	} catch (PixelOutOfWindowException e) {
	    System.err
		    .println("PixelOutOfWindowException : You tried to get an out of bound pixel at x="
			    + x + " y=" + y);
	}
	return false;
    }

    /**
     * Sets a rectangle of the specified color. more optimized than a for loop
     * to set each pixel one by one, using the graphics items only once.
     * 
     * @param color
     *            true for black and false for white.
     * */
    public void setrectangle(int x, int y, int widthF, int heightF,
	    boolean color) {
	for (int i = x; i < widthF + x; i++) {
	    for (int j = y; j < heightF + y; j++) {
		try {
		    this.pixels.setpixelstate(i, j, color);
		} catch (PixelOutOfWindowException e) {
		    System.err
		    .println("PixelOutOfWindowException : You tried to set an out of bound pixel at x="
			    + i + " y=" + j);
		}
	    }
	}
	Graphics g = this.getGraphics();
	if(color)
	    g.setColor(BLACK);
	else
	    g.setColor(WHITE);
	g.fillRect(x, y, widthF, heightF);
    }
}
