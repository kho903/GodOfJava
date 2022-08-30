package _12.inheritance.ex;

public class ManageStudent {
	public static void main(String[] args) {
		ManageStudent manage = new ManageStudent();
		manage.checkEquals();		
	}

	public void checkEquals() {
		Student student1 = new Student("Min", "Seoul", "01012345678", "ask@godOfJava.com");
		Student student2 = new Student("Min", "Seoul", "01012345678", "ask@godOfJava.com");
		if (student1.equals(student2)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not Equal");
		}
	}
}
