public class OperatorComparison {
	public static void main(String[] args) {
		OperatorComparison operator = new OperatorComparison();
		operator.comparison();
		System.out.println("=======================");
		operator.comparison2();
		System.out.println("=======================");
		operator.comparison3();
	}

	public void comparison() {
		int intValue1 = 1;
		int intValue2 = 2;
		int intValue3 = 1;
		System.out.println(intValue1 == intValue2);
		System.out.println(intValue1 == intValue3);
		
		System.out.println(intValue1 != intValue2);
		System.out.println(intValue1 != intValue3);
	}

	public void comparison2() {
		char charValue = 'a';
		System.out.println(97 == charValue);
		int intValue = 1;
		double doubleValue = 1.0;
		System.out.println(intValue == doubleValue);
	}

	public void comparison3() {
		boolean booleanValue1 = true;
		boolean booleanValue2 = false;

		System.out.println(booleanValue1 == booleanValue2);
		System.out.println(booleanValue1 != booleanValue2);
	}
}
