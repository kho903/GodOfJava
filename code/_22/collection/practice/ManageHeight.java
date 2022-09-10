package _22.collection.practice;

import java.util.ArrayList;

public class ManageHeight {
	ArrayList<ArrayList<Integer>> gradeHeights = new ArrayList<>();

	public static void main(String[] args) {
		ManageHeight manage = new ManageHeight();
		manage.setData();
		for (int i = 1; i <= 5; i++) {
			manage.printHeight(i);
		}

		int classNo = 1;
		while (classNo <= 5) {
			manage.printAverage(classNo++);
		}
	}

	public void setData() {
		ArrayList<Integer> one = new ArrayList<>();
		ArrayList<Integer> two = new ArrayList<>();
		ArrayList<Integer> three = new ArrayList<>();
		ArrayList<Integer> four = new ArrayList<>();
		ArrayList<Integer> five = new ArrayList<>();

		one.add(170);
		one.add(180);
		one.add(173);
		one.add(175);
		one.add(177);

		two.add(160);
		two.add(165);
		two.add(167);
		two.add(186);

		three.add(158);
		three.add(177);
		three.add(187);
		three.add(176);

		four.add(173);
		four.add(182);
		four.add(181);

		five.add(170);
		five.add(180);
		five.add(165);
		five.add(170);
		five.add(172);

		gradeHeights.add(one);
		gradeHeights.add(two);
		gradeHeights.add(three);
		gradeHeights.add(four);
		gradeHeights.add(five);
	}

	public void printHeight(int classNo) {
		ArrayList<Integer> heightArray = gradeHeights.get(classNo - 1);
		System.out.println("Class No. : " + classNo);
		for (Integer height : heightArray) {
			System.out.println(height);
		}
	}

	public void printAverage(int classNo) {
		double sum = 0;
		ArrayList<Integer> gradeArr = gradeHeights.get(classNo - 1);
		for (int grade : gradeArr) {
			sum += grade;
		}
		System.out.println("Class No.:" + classNo);
		System.out.println("Height average:" + sum / (gradeArr.size()));
	}
}
