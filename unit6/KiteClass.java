import java.awt.Color;
import java.awt.Graphics;

import hsa.Console;

public class KiteClass {
	// global variables for this class
	// encapsulated data
	private int iWidth = 80;
	private int iHeight = 100;
	private int iCentreX = 100;
	private int iCentreY = 100;
	private int iTailLength = 100;

	private Color iColor = Color.red;
	private boolean filled = true;

	// communicator methods
	public void setWidth(int iNewWidth) {
		iWidth = iNewWidth;
	}

	public void setHeight(int iNewHeight) {
		iHeight = iNewHeight;
	}

	public void setCenter(int iNewCentreX, int iNewCentreY) {
		iCentreX = iNewCentreX;
		iCentreY = iNewCentreY;
	}

	public void setColor(Color cNewColor) {

		iColor = cNewColor;
	}

	public int getWidth() {
		return iWidth;
	}

	public int getHeight() {
		return iHeight;
	}

	public int getCenterX() {
		return iCentreX;
	}

	public int getCenterY() {
		return iCentreY;
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

	public int getiTailLength() {
		return iTailLength;
	}

	public void setiTailLength(int iTailLength) {
		this.iTailLength = iTailLength;
	}

	public boolean isPoint(int PointX, int PointY) {
		if ((iCentreX + iWidth / 2) > PointX & PointX > (iCentreX - iWidth / 2) & (iCentreY + iHeight / 2) > PointY
				& PointY > (iCentreY - iHeight / 2)) {
			return true;
		} else {
			return false;
		}
	}

	public void draw(Console c) 
	    {
	    	// declare two arrays for X & Y coordinates of Diamond
	    	int iPointsX[] = new int [4];
	    	int iPointsY[] = new int [4];
	    	int iTail = iCentreY + iTailLength;
	    	
	    	// calculate points on diamond & store in the arrays
	    	iPointsX [0] = iCentreX - iWidth / 2;
	    	iPointsY [0] = iCentreY;
	    	iPointsX [1] = iCentreX;
	    	iPointsY [1] = iCentreY - iHeight / 2;
	    	iPointsX [2] = iCentreX + iWidth / 2;
	    	iPointsY [2] = iCentreY;
	    	iPointsX [3] = iCentreX;
	    	iPointsY [3] = iCentreY + iHeight / 2;

	    	// draw the diamond using methods available from the Console object (c)
	    	c.setColor (iColor);
	    	if (filled)
	    	{
	    	    c.fillPolygon (iPointsX, iPointsY, 4);
	    	    c.drawLine(iCentreX, iCentreY + (iHeight / 2), iCentreX, iTail);
	    	}
	    	else
	    	{
	    	    c.drawPolygon (iPointsX, iPointsY, 4);
	    	    c.drawLine(iCentreX, iCentreY + (iHeight / 2), iCentreX, iTail);
	    	}
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

	public KiteClass(int nWidth, int nHeight, int nTailLength) {
		setWidth(nWidth);
		setHeight(nHeight);
		setiTailLength(nTailLength);
	}

	public KiteClass(int nWidth, int nHeight, int nCentreX, int nCentreY, int nTailLength, Color nColour,
			boolean nFilling) {

		setWidth(nWidth);
		setHeight(nHeight);
		setCenter(nCentreX, nCentreY);
		setiTailLength(nTailLength);
		setColor(nColour);
		setIsFilled(nFilling);
	}

	public KiteClass() {
		iWidth = 60;
		iHeight = 80;
		iCentreX = 300;
		iCentreY = 200;
		iTailLength = 100;
		iColor = Color.GREEN;
		filled = true;
	}

	public void draw(Graphics g) {
		int CornerX = iCentreX - iWidth / 2; // upper left coordinates
		int CornerY = iCentreY - iHeight / 2; // needed to draw the oval
		int iTail = iCentreY + iTailLength;

		// draw the diamond using methods available from the Console object (c)
		g.setColor(iColor);
		// c.fillPolygon (iPointsX, iPointsY, 4);
		g.fillOval(CornerX, CornerY, iWidth, iHeight);
		g.drawLine(iCentreX, iCentreY, iCentreX, iTail);
	}

	public void erase(Graphics g) {
		Color cOldColor = getColor();
		setColor(Color.white);
		draw(g);
		setColor(cOldColor);
	}
}
