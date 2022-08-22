public class ManageHeight {

	int[][] gradeHeights;

	public static void main(String[] args) {
		ManageHeight manage = new ManageHeight();
		manage.setData();
		/*for (int i = 0; i < 5; i++) {
			manage.printHeight(i);
		}*/
		int classNo = 0;
		while (classNo < 5) {
			System.out.println("Class No.:" + classNo);
			manage.printAverage(classNo);
			classNo++;
		}
	}

	public void setData() {
		gradeHeights = new int[][] {
			{170, 180, 173, 175, 177},
			{160, 165, 167, 186},
			{158, 177, 187, 176},
			{173, 182, 181},
			{170, 180, 165, 177, 172}
		};
	}

	public void printHeight(int classNo) {
		System.out.println("Class No.:" + (classNo + 1));
		for (int height : gradeHeights[classNo]) {
			System.out.println(height);
		}
	}

	public void printAverage(int classNo) {
		double sum = 0.0;
		int studentLength = gradeHeights[classNo].length;
		for (int i = 0; i < studentLength; i++) {
			sum += gradeHeights[classNo][i];
		}
		System.out.println(sum / studentLength);
	}
}
