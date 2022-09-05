package _17.annotation;

import java.lang.reflect.Method;

public class UserAnnotationCheck {
	public static void main(String[] args) {
		UserAnnotationCheck sample = new UserAnnotationCheck();
		sample.checkAnnotation(UserAnnotationSample.class);
	}

	public void checkAnnotation(Class useClass) {
		Method[] methods = useClass.getDeclaredMethods();
		for (Method tempMethod : methods) {
			UserAnnotation annotation = tempMethod.getAnnotation(UserAnnotation.class);
			if (annotation != null) {
				int number = annotation.number();
				String text = annotation.text();
				System.out.println(tempMethod.getName() + "() : number = " + number + " text = " + text);
			} else {
				System.out.println(tempMethod.getName() + "() : annotation is Null");
			}
		}
	}
}
