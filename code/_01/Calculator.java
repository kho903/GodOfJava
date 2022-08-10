public class Calculator {

    public int add(int num1, int num2) {
	int sum;
	sum = num1 + num2;
	return sum;
    }

    public int subtract(int num1, int num2) {
	int sub;
	sub = num1 - num2;
	return sub;
    }

    public int multiply(int num1, int num2) {
	int multi;
	multi = num1 * num2;
	return multi;
    }

    public int divide(int num1, int num2) {
	int div;
	div = num1 / num2;
	return div;
    }

    public static void main(String[] args) {

	Calculator calc = new Calculator();
	System.out.println(calc.add(1, 2));
	System.out.println(calc.subtract(3, 2));
	System.out.println(calc.multiply(2, 3));
	System.out.println(calc.divide(4, 2));
    }
}
