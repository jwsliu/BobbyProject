import java.awt.Color;

import hsa.Console;

public class UseBalloonClass {
	static Console c;

	static int iWidth = 80;
	static int iHeight = 100;
	static int iCentreX = 100;
	static int iCentreY = 100;
	static int iTailLength = 100;

	static Color iColor = Color.blue;

	public static void main(String[] args) {
		c = new Console();
		BalloonClass p = new BalloonClass ();
		BalloonClass b = new BalloonClass(60, 80, 300, 200, 50, Color.GREEN, true, 330, 330);
		BalloonClass l = new BalloonClass(30, 40, 100, 200, 50, Color.black, true, 300, 300);
		//l.BalloonClass(30, 40, 300, 200, 50, Color.black, true, 300, 300);
		//b.BalloonClass(60, 80, 100, 200, 50, Color.GREEN, true, 3000, 3000);
		l.draw(c);
		b.draw(c);
		p.draw(c);
		c.print(b.isPoint(300, 200));
		while (b.getgrow() == true || l.getgrow() == true) {
			b.grow(c, 0.3);
			l.grow(c, 0.1);
		}
		b.draw(c);
		c.setCursor(12, 30);
		c.print("Program Over");
		
		

	}
}
