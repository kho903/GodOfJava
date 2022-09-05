package middle;

public class CalculateSalary {

	static final int OWNER = 1;
	static final int MANAGER = 2;
	static final int DESIGNER = 3;
	static final int ARCHITECT = 4;
	static final int DEVELOPER = 5;

	public static void main(String[] args) {
		CalculateSalary calc = new CalculateSalary();
		Employee[] employeeArray = new Employee[5];
		employeeArray[0] = new Employee("LeeDaeRi", 1, 1_000_000_000);
		employeeArray[1] = new Employee("KimManager", 2, 100_000_000);
		employeeArray[2] = new Employee("WhangDesign", 3, 70_000_000);
		employeeArray[3] = new Employee("ParkArchi", 4, 80_000_000);
		employeeArray[4] = new Employee("LeeDevelop", 5, 60_000_000);
		for (Employee employee : employeeArray) {
			long salary = calc.getSalaryIncrease(employee);
			System.out.println(employee.getName() + "=" + salary);
		}
	}

	public long getSalaryIncrease(Employee employee) {
		int type = employee.getType();
		long salary = employee.getSalary();
		switch (type) {
			case OWNER:
				salary *= 0.05;
				break;
			case MANAGER:
				salary *= 1.1;
				break;
			case DESIGNER:
				salary *= 1.2;
				break;
			case ARCHITECT:
				salary *= 1.3;
				break;
			case DEVELOPER:
				salary *= 2;
				break;
		}
		return salary;
	}
}
