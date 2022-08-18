public class SalaryManager {
	public static void main(String[] args) {
		SalaryManager manager = new SalaryManager();
		System.out.println("월급 = " + manager.getMonthlySalary(20000000));
	}

	public double getMonthlySalary(int yearlySalary) {
		double doubleYearlySalary = (double) yearlySalary;
		double monthlySalary = doubleYearlySalary / 12.0;
		double tax = calculateTax(monthlySalary);
		double nationalPension = calculateNationalPension(monthlySalary);
		double healthInsurance = calculateHealthInsurance(monthlySalary);
		double sumOfTax = tax + nationalPension + healthInsurance;
		monthlySalary -= sumOfTax;
		return monthlySalary;
	}

	public double calculateTax(double monthSalary) {
		double tax = monthSalary * 0.125;
		System.out.println("근로 소득세 = " + tax);
		return tax;
	}

	public double calculateNationalPension(double monthSalary) {
		double nationalPension = monthSalary * 0.081;
		System.out.println("국민 연금 = " + nationalPension);
		return nationalPension;
	}

	public double calculateHealthInsurance(double monthSalary) {
		double healthInsurance = monthSalary * 0.135;
		System.out.println("건강 보험료 = " + healthInsurance);
		return healthInsurance;
	}
}
