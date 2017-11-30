import java.awt.Color;
import hsa.Console;

public class UsePinBalloon {
	static Console c;
	static int iWidth = 80;
	static int iHeight = 100;
	static int iCentreX = 100;
	static int iCentreY = 100;
	static int iTailLength = 100;
	static int iPinLength = 100;
	static int iSize = 100;
	static Color iColor = Color.blue;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		c = new Console();
		// TODO Auto-generated method stub
		int randInt = (int) ((Math.random() * 350) + 1);
		int randIntt = (int) ((Math.random() * 350) + 1);
		/**
		 * int randInttt = (int) ((Math.random() * 350) + 1); int randIntttt = (int)
		 * ((Math.random() * 350) + 1); int randInttttt = (int) ((Math.random() * 350) +
		 * 1); int randIntttttt = (int) ((Math.random() * 350) + 1); int randInttttttt =
		 * (int) ((Math.random() * 350) + 1); int randIntttttttt = (int) ((Math.random()
		 * * 350) + 1);

		BalloonClass b = new BalloonClass();
		b.setCenter(randInt, randIntt);
		b.draw(c);
		randInt = (int) ((Math.random() * 350) + 1);
		randIntt = (int) ((Math.random() * 350) + 1);
		b.setCenter(randInt, randIntt);
		b.draw(c);
		b.delay(300);
		PinClass a = new PinClass();
		randInt = (int) ((Math.random() * 350) + 1);
		randIntt = (int) ((Math.random() * 350) + 1);
		a.sethCenter(randInt, randIntt);
		randInt = (int) ((Math.random() * 350) + 1);
		randIntt = (int) ((Math.random() * 350) + 1);
		a.settCenter(randInt, randIntt);
		a.draw(c);
		randInt = (int) ((Math.random() * 350) + 1);
		randIntt = (int) ((Math.random() * 350) + 1);
		a.settCenter(randInt, randIntt);
		randInt = (int) ((Math.random() * 350) + 1);
		randIntt = (int) ((Math.random() * 350) + 1);
		a.sethCenter(randInt, randIntt);
		a.draw(c);*/

		BalloonClass b = new BalloonClass(100, 120, 300, 200, 500, Color.GREEN, true, 330, 330);
		b.draw(c);
		PinClass a = new PinClass();

		while (b.isPoint(randInt, randIntt) == false)
		{
		randInt = (int) ((Math.random() * 652) + 1);
		randIntt = (int) ((Math.random() * 532) + 1);
		a.sethCenter(randInt, randIntt);
		randInt = (int) ((Math.random() * 650) + 1);
		randIntt = (int) ((Math.random() * 650) + 1);
		a.settCenter(randInt, randIntt);
		a.draw(c);
		a.delay(300);
		a.erase(c);
		b.draw(c);

		}
		b.draw(c);
		a.draw(c);
		b.pop(c);
		a.draw(c);
		c.setCursor(12, 30);
		c.print("Program Over");

	}

}
