package _17.annotation;

public class AnnotationOverride extends Parent {
	@Override
	public void printName(String args) {
		System.out.println("AnnotationOverride");
	}
}
