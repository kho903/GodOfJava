package _14.exception.practice;

public class Calculator {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.printDivide(1, 2);
		calc.printDivide(1, 0);
	}

	public void printDivide(double d1, double d2) {
		double result = d1 / d2;
		try {
			if (d2 == 0) {
				throw new Exception();
			}
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Second value can't be Zero");
		}
	}
}

/*
0.5
Infinity
- 나누는 값이 0이기 때문에 Infinity 라고 출력됨
- 예외 발생시켜 변경해본다.

*/
