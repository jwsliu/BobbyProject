import java.awt.Color;


import hsa.Console;

public class UsePinClass {
	static Console c;

	static int iSize = 100;
	static int iCentreX = 100;
	static int iCentreY = 100;
	static int iPinLength = 100;

	static Color iColor = Color.blue;

	public static void main(String[] args) {
		c = new Console();
		// TODO Auto-generated method stub
		PinClass b = new PinClass();
		b.settCenter(250, 380);
		b.draw(c);
		c.setCursor (12, 30);
		c.print("Program Over");

	}
}
