public class ControlLabel {

	public static void main(String[] args) {
		ControlLabel control = new ControlLabel();
		control.printTimesTable();
		System.out.println();
		control.printTimesTableSkip4Case1();
		System.out.println();
		control.printTimesTableSkip4Case2();
		System.out.println();
		control.printTimesTableSkip4Case3();
		System.out.println();
		control.printTimesTableSkip4Case4();
	}

	public void printTimesTable() {
		for (int level = 2; level < 10; level++) {
			for (int unit = 1; unit < 10; unit++) {
				System.out.print(level + "*" + unit + "=" + level * unit + " ");
			}
			System.out.println();
		}
	}

	public void printTimesTableSkip4Case1() {
		for (int level = 2; level < 10; level++) {
			for (int unit = 1; unit < 10; unit++) {
				if (level == 4 || unit == 4) continue;
				System.out.print(level + "*" + unit + "=" + level * unit + " ");
			}
			System.out.println();
		}
	}

	public void printTimesTableSkip4Case2() {
		for (int level = 2; level < 10; level++) {
			if (level == 4) continue;
			for (int unit = 1; unit < 10; unit++) {
				if (unit == 4) continue;
				System.out.print(level + "*" + unit + "=" + level * unit + " ");
			}
			System.out.println();
		}
	}

	public void printTimesTableSkip4Case3() {
		for (int level = 2; level < 10; level++) {
			if (level == 4) continue;
			for (int unit = 1; unit < 10; unit++) {
				if (unit == 4) break;
				System.out.print(level + "*" + unit + "=" + level * unit + " ");
			}
			System.out.println();
		}
	}

	public void printTimesTableSkip4Case4() {
		startLabel:
		for (int level = 2; level < 10; level++) {
			if (level == 4) continue;
			for (int unit = 1; unit < 10; unit++) {
				if (unit == 4) continue startLabel;
				System.out.print(level + "*" + unit + "=" + level * unit + " ");
			}
			System.out.println();
		}
	}
}
