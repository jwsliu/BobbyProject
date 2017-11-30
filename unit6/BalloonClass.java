import java.awt.Color;
import java.awt.Graphics;

import hsa.Console;

public class BalloonClass {
	// global variables for this class
	// encapsulated data
	private int iWidth = 80;
	private int iHeight = 100;
	private int iCentreX = 100;
	private int iCentreY = 100;
	private int iTailLength = 100;
	private int maxHeight = 150;
	private int maxWidth = 150;
	private boolean isGrow = true;
	private boolean isPoped = false;

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

	public int getMaxX() {
		return maxWidth;
	}

	public boolean getgrow() {
		return isGrow;
	}

	public boolean getisPoped() {
		return isPoped;
	}

	// private void setisPoped(boolean NisPoped) {
	// isPoped = NisPoped;
	// }

	public void setMaxY(int iNewMax) {
		maxHeight = iNewMax;
	}

	public void setMaxX(int iNewMax) {
		maxWidth = iNewMax;
	}

	public int getMaxY() {
		return maxHeight;
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
		if ((iCentreX + iWidth / 2) > PointX & PointX > (iCentreX - iWidth / 2) & (iCentreY + iHeight / 2) > PointY & PointY > (iCentreY - iHeight / 2)) {
			return true; 
		}else {
			return false;
		}
	}

	public void draw(Console c) {
		if (isPoped == false) {
			int CornerX = iCentreX - iWidth / 2; // upper left coordinates
			int CornerY = iCentreY - iHeight / 2; // needed to draw the oval
			int iTail = iCentreY + iTailLength;

			// draw the diamond using methods available from the Console object (c)
			c.setColour(iColor);
			// c.fillPolygon (iPointsX, iPointsY, 4);
			if (filled == false) {
				c.drawOval(CornerX, CornerY, iWidth, iHeight);
				c.drawLine(iCentreX, iCentreY + (iHeight / 2), iCentreX, iTail);
			} else {
				c.fillOval(CornerX, CornerY, iWidth, iHeight);
				c.drawLine(iCentreX, iCentreY + (iHeight / 2), iCentreX, iTail);
			}
		}
	}

	public void erase(Console c) {
		Color cOldColor = getColor();
		setColor(Color.white);
		draw(c);
		setColor(cOldColor);
	}

	public void pop(Console c) {
		int CornerX = iCentreX - iWidth / 2;
		int CornerY = iCentreY - iHeight / 2;
		int iTail = iCentreY + iTailLength;
		if (filled == false) {
			erase(c);
			c.setColor(iColor);
			c.drawStar(CornerX, CornerY, iWidth, iHeight);
			c.drawLine(iCentreX, iCentreY + (iHeight / 4), iCentreX, iTail);
			delay(500);
			c.setColor(Color.white);
			c.drawStar(CornerX, CornerY, iWidth, iHeight);
			c.setColor(iColor);
			c.drawLine(iCentreX, iCentreY + (iHeight / 4), iCentreX, iTail);
		} else {
			erase(c);
			c.setColor(iColor);
			c.fillStar(CornerX, CornerY, iWidth, iHeight);
			c.drawLine(iCentreX, iCentreY + (iHeight / 4), iCentreX, iTail);
			delay(500);
			c.setColor(Color.white);
			c.fillStar(CornerX, CornerY, iWidth, iHeight);
			c.setColor(iColor);
			c.drawLine(iCentreX, iCentreY + (iHeight / 4), iCentreX, iTail);
		}
	}

	public void grow(Console c, double Percentage) {

		if (isPoped == false) {
			if (iHeight < maxHeight || iWidth < maxWidth) {
				isGrow = true;
				erase(c);
				iHeight = (int) (iHeight * (1 + Percentage));
				iWidth = (int) (iWidth * (1 + Percentage));
				iTailLength = (int) (iTailLength * (1 + Percentage));
				draw(c);
				delay(500);
			} else {
				isGrow = false;
				pop(c);
				isPoped = true;
			}
		}
	}

	public void delay(int iDelayTime) {
		long lFinalTime = System.currentTimeMillis() + iDelayTime;
		do {
		} while (lFinalTime >= System.currentTimeMillis());
	}

	public BalloonClass(int nWidth, int nHeight, int nTailLength) {
		setWidth(nWidth);
		setHeight(nHeight);
		setiTailLength(nTailLength);
	}

	public BalloonClass(int nWidth, int nHeight, int nCentreX, int nCentreY, int nTailLength, Color nColour,
			boolean nFilling, int nMaxX, int nMaxY) {
		
		
		setWidth(nWidth);
		setHeight(nHeight);
		setCenter(nCentreX, nCentreY);
		setiTailLength(nTailLength);
		setColor(nColour);
		setIsFilled(nFilling);
		setMaxX(nMaxX);
		setMaxY(nMaxY);
	}

	public BalloonClass() {
		iWidth = 60;
		iHeight = 80;
		iCentreX =300;
		iCentreY = 200;
		iTailLength = 50;
		iColor = Color.GREEN;
		filled = true;
		maxHeight = 250;
		maxWidth= 250;
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
