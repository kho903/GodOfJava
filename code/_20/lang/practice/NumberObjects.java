package _20.lang.practice;

public class NumberObjects {
	public static void main(String[] args) {
		NumberObjects sample = new NumberObjects();
		System.out.println(sample.parseLong("200"));
		System.out.println(sample.parseLong("100000000"));
		System.out.println(sample.parseLong("r1024"));
		System.out.println("------------------------------");
		sample.printOtherBase(1024);
	}

	public long parseLong(String data) {
		try {
			return Long.parseLong(data);
		} catch (NumberFormatException e) {
			System.out.println(data + " is not a number");
			return -1;
		}
	}

	public void printOtherBase(long value) {
		System.out.println("Original:" + value);
		System.out.println("Binary  :" + Long.toBinaryString(value));
		System.out.println("Hex     :" + Long.toHexString(value));
		System.out.println("Octal   :" + Long.toOctalString(value));
	}
}
