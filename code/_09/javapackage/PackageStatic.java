package _09.javapackage;

// import _09.javapackage.sub.SubStatic;
import static _09.javapackage.sub.SubStatic.subStaticMethod;
import static _09.javapackage.sub.SubStatic.CLASS_NAME;

public class PackageStatic {
	public static void main(String[] args) {
		// SubStatic.subStaticMethod();
		// System.out.println(SubStatic.CLASS_NAME);
		subStaticMethod();
		System.out.println(CLASS_NAME);
	}
}
