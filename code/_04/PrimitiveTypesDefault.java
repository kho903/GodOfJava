public class PrimitiveTypesDefault {
	int intDefault;
	byte byteDefault;
	short shortDefault;
	long longDefault;
	float floatDefault;
	double doubleDefault;
	char charDefault;
	boolean booleanDefault;
	
	public static void main(String[] args) {
		PrimitiveTypesDefault primitive = new PrimitiveTypesDefault();
		primitive.defaultValues();
	}

	public void defaultValues() {

		System.out.println("byteDefault=" + byteDefault);
		System.out.println("shortDefault=" + shortDefault);
		System.out.println("intDefault=" + intDefault);
		System.out.println("longDefault=" + longDefault);
		System.out.println("floatDefault=" + floatDefault);
		System.out.println("doubleDefault=" + doubleDefault);
		System.out.println("charDefault=" + charDefault);
		System.out.println("booleanDefault=" + booleanDefault);
	}
}
