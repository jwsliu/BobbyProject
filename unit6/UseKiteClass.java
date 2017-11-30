import hsa.Console;

public class UseKiteClass {
	static Console c;

	public static void main(String[] args) {
		c = new Console();
		KiteClass k = new KiteClass();
		k.draw(c);
	}

}
