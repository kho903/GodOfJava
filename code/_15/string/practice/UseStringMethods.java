package _15.string.practice;

public class UseStringMethods {

	public static void main(String[] args) {
		UseStringMethods use = new UseStringMethods();
		String str = "The String class represents character strings.";
		use.printWords(str);
		use.findString(str, "string");
		use.findAnyCaseString(str, "string");
		use.countChar(str, 's');
		use.printContainWords(str, "ss");
	}

	public void printWords(String str) {
		String[] splitStr = str.split(" ");
		for (String value : splitStr) {
			System.out.println(value);
		}
	}

	public void findString(String str, String findStr) {
		int idx = str.indexOf(findStr);
		System.out.println("string is appeared at " + idx);
	}

	public void findAnyCaseString(String str, String findStr) {
		str = str.toLowerCase();
		int idx = str.indexOf(findStr);
		System.out.println("string is appeared at " + idx);
	}

	public void countChar(String str, char c) {
		int cnt = 0;
		for (char ch : str.toCharArray()) {
			if (ch == c)
				cnt++;
		}
		System.out.printf("char '%c' count is %d\n", c, cnt);
	}

	public void printContainWords(String str, String findStr) {
		String[] strArr = str.split(" ");
		for (String value : strArr) {
			if (value.contains(findStr))
				System.out.printf("%s contains %s\n", value, findStr);
		}
	}
}
