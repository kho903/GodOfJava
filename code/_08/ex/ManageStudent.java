public class ManageStudent {
	public static void main(String[] args) {
		ManageStudent manage = new ManageStudent();
		Student[] student = null;
		student = manage.addStudent();
		for (Student stu : student) {
			manage.printStudents(stu);
		}
	}

	public Student[] addStudent() {
		Student[] student = new Student[3];
		student[0] = new Student("Lim");
		student[1] = new Student("Min");
		student[2] = new Student("Sook", "Seoul", "010xxxxxxxx", "ask@godofjava.com");
		return student;
	}

	public void printStudents(Student student) {
		System.out.println(student);
	}
}
