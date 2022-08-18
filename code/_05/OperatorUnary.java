public class OperatorUnary {
	public static void main(String[] args) {
		OperatorUnary sample = new OperatorUnary();
		sample.unary();
	}

    public void unary() {
        int intValue = -10;
        int result = +intValue;
        System.out.println(result);
        result = -intValue;
        System.out.println(result);
    }
}
