import java.awt.Color;


import hsa.Console;

public class PinClass {
	// global variables for this class
	// encapsulated data
	private int hCentreX = 100;
	private int hCentreY = 100;
	//private int iPinLength = 100;
	private int iSize = 10;
	private int tCentreX;
	private int tCentreY;

	private Color iColor = Color.black;
	private boolean filled = true;

	// communicator methods




	public void sethCenter(int iNewCentreX, int iNewCentreY) {
		hCentreX = iNewCentreX;
		hCentreY = iNewCentreY;
	}
	
	public void settCenter(int iNewCentreX, int iNewCentreY) {
		tCentreX = iNewCentreX;
		tCentreY = iNewCentreY;
	}

	public void setColor(Color cNewColor) {

		iColor = cNewColor;
	}



	public int gethCenterX() {
		return hCentreX;
	}

	public int gethCenterY() {
		return hCentreY;
	}
	
	public int gettCenterX() {
		return tCentreX;
	}

	public int gettCenterY() {
		return tCentreY;
	}

	public Color getColor() {
		return iColor;
	}

	public void setIsFilled(boolean newfilled) {
		filled = newfilled;
	}

	public boolean getIsFilled() {
		return filled;
	}

	public void draw(Console c) {

		int CornerX = hCentreX - iSize / 2; // upper left coordinates
		int CornerY = hCentreY - iSize / 2; // needed to draw the oval

		// draw the diamond using methods available from the Console object (c)
		c.setColour(iColor);
		// c.fillPolygon (iPointsX, iPointsY, 4);
		c.fillOval(CornerX, CornerY, iSize, iSize);
		c.drawLine(hCentreX, hCentreY, tCentreX, tCentreY);
	}

	public void erase(Console c) {
		Color cOldColor = getColor();
		setColor(Color.white);
		draw(c);
		setColor(cOldColor);
	}

	public void delay(int iDelayTime) {
		long lFinalTime = System.currentTimeMillis() + iDelayTime;
		do {
		} while (lFinalTime >= System.currentTimeMillis());
	}

	/**
	 * public void draw (Graphics g) { int CornerX = iCentreX - iWidth / 2; // upper
	 * left coordinates int CornerY = iCentreY - iHeight / 2; // needed to draw the
	 * oval int iTail = iCentreY + iPinLength;
	 * 
	 * // draw the diamond using methods available from the Console object (c)
	 * g.setColor (iColor); // c.fillPolygon (iPointsX, iPointsY, 4); g.fillOval
	 * (CornerX, CornerY, iWidth, iHeight); g.drawLine (iCentreX, iCentreY,
	 * iCentreX, iTail); }
	 * 
	 * 
	 * public void erase (Graphics g) { Color cOldColor = getColor (); setColor
	 * (Color.white); draw (g); setColor (cOldColor); }
	 * 
	 * @param g
	 */

}
