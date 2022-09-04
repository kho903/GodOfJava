package _15.string;

public class StringCheck {
	public static void main(String[] args) {
		StringCheck sample = new StringCheck();
		String[] addresses = new String[] {
			"서울시 구로구 신도림동",
			"경기도 성남시 분당구 정자동 개발 공장",
			"서울시 구로구 개봉동",
		};
		// sample.checkAddress(addresses);
		// sample.containsAddress(addresses);
		// sample.checkMatch();
		// sample.checkIndexOf();
		// sample.checkLastIndexOf();
		// sample.checkCopyValueOf();
		// sample.checkToCharArray();
		// sample.checkSubstring();
		// sample.checkSplit();
		// sample.checkTrim();
		// sample.checkTrim2("   a ");
		// sample.checkTrim2(" ");
		// sample.checkReplace();
		// sample.checkFormat();
		sample.internCheck();
	}

	public void checkAddress(String[] addresses) {
		int startCount = 0, endCount = 0;
		String startText = "서울시";
		String endText = "동";
		for (String address : addresses) {
			if (address.startsWith(startText)) {
				startCount++;
			}
			if (address.endsWith(endText)) {
				endCount++;
			}
		}
		System.out.println("Starts with " + startText + " count is " + startCount);
		System.out.println("Ends with " + endText + " count is " + endCount);
	}

	public void containsAddress(String[] addresses) {
		int containCount = 0;
		String containText = "구로";
		for (String address : addresses) {
			if (address.contains(containText)) {
				containCount++;
			}
		}
		System.out.println("Contains " + containText + " count is " + containCount);
	}

	public void checkMatch() {
		String text = "This is a text";
		String compare1 = "is";
		String compare2 = "this";
		System.out.println(text.regionMatches(2, compare1, 0, 1)); // 매개 변수가 4개인 메소드
		System.out.println(text.regionMatches(5, compare1, 0, 2)); // 매개 변수가 4개인 메소드
		System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
	}

	public void checkIndexOf() {
		String text = "Java technology is both a programming language and a platform.";
		System.out.println(text.indexOf('a'));
		System.out.println(text.indexOf("a "));
		System.out.println(text.indexOf('a', 20));
		System.out.println(text.indexOf("a ", 20));
		System.out.println(text.indexOf('z'));
	}

	public void checkLastIndexOf() {
		String text = "Java technology is both a programming language and a platform.";
		System.out.println(text.lastIndexOf('a'));
		System.out.println(text.lastIndexOf("a "));
		System.out.println(text.lastIndexOf('a', 20));
		System.out.println(text.lastIndexOf("a ", 20));
		System.out.println(text.lastIndexOf('z'));
	}

	public void checkCopyValueOf() {
		char values[] = new char[] {'J', 'a', 'v', 'a'};
		String javaText = String.copyValueOf(values);
		System.out.println("value array");
		for (int i = 0; i < values.length; i++ ) {
			System.out.println("value[" + i + "] = " + values[i]);
		}
		System.out.println("use copyValueOf");
		System.out.println(javaText);
	}

	public void checkToCharArray() {
		String javaStr = "Java";
		char[] values = javaStr.toCharArray();
		for (int i = 0; i < values.length; i++ ) {
			System.out.println("value[" + i + "] = " + values[i]);
		}
	}

	public void checkSubstring() {
		String text = "Java technology";
		String technology = text.substring(5);
		System.out.println(technology);
		//String tech = text.substring(5, 4);
		String tech = text.substring(5, 9);
		System.out.println(tech);
	}

	public void checkSplit() {
		String text = "Java technology is both a programming language and a platform.";
		String[] splitArray = text.split(" ");
		for (String temp : splitArray) {
			System.out.println(temp);
		}
	}

	public void checkTrim() {
		String[] strings = new String[] {
			" a", " b ", "     c", "d     ", "e   f", "   "
		};
		for (String string : strings) {
			System.out.println("[" + string + "]");
			System.out.println("[" + string.trim() + "]");
		}
	}

	public void checkTrim2(String text) {
		if (text != null && text.trim().length() > 0) {
			System.out.println("text OK");
		} else {
			System.out.println("text NO");
		}
	}

	public void checkReplace() {
		String text = "The String class represents character strings.";
		System.out.println(text.replace('s', 'z'));
		System.out.println(text);
		System.out.println(text.replace("tring", "trike"));
		System.out.println(text.replaceAll(" ", "|"));
		System.out.println(text.replaceFirst(" ", "|"));
	}

	public void checkFormat() {
		String text = "제 이름은 %s입니다. 지금까지 %d권의 책을 썼고, "
			+ "하루에 %f %%의 시간을 책을 쓰는데 할애하고 있습니다.";
		String realText = String.format(text, "이상민", 7, 10.5);
		// String realText = String.format(text, "이상민", 7);
		System.out.println(realText);
	}

	public void internCheck() {
		String text1 = "Java Basic";
		String text2 = "Java Basic";
		String text3 = new String("Java Basic");
		text3 = text3.intern();
		System.out.println(text1 == text2);
		System.out.println(text1 == text3);
		System.out.println(text1.equals(text3));
	}
}
