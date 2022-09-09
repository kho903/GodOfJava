package _20.lang;

public class JavaLangSystemPrint {
	public static void main(String[] args) {
		JavaLangSystemPrint sample = new JavaLangSystemPrint();
		// sample.printStreamCheck();
		sample.printNull();
		// sample.printNullToString();
	}

	public void printStreamCheck() {
		byte b = 127;
		short s = 32767;
		System.out.println(b);
		System.out.println(s);
		printInt(b);
		printInt(s);
	}

	public void printInt(int value) {
		System.out.println(value);
	}

	public void printNull() {
		Object obj = null;
		//System.out.println(obj);
		System.out.println(obj + " is object's value");
	}

	/*public void printNullToString() {
		Object obj = null;
		System.out.println(obj.toString());
	}*/
}
