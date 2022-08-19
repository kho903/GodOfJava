public class InterestManager {
	public static void main(String[] args) {
		InterestManager manager = new InterestManager();
		for (int day = 1; day <= 365; day+=10) {
			System.out.println(day + " : " + manager.calculateAmount(day, 1000000L));
		}
	}

	public double getInterestRate(int day) {
		if (1 <= day && day <= 90) {
			return 0.5;
		} else if (91 <= day && day <= 180) {
			return 1.0;
		} else if (181 <= day && day <= 364) {
			return 2.0;
		} else {
			return 5.6;
		}
	}

	public double calculateAmount(int day, long amount) {
		InterestManager manager = new InterestManager();
		double interest = manager.getInterestRate(day);
		return amount * (100 + interest) / 100;
	}
}
