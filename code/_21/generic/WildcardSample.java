package _21.generic;

public class WildcardSample {
	public static void main(String[] args) {
		WildcardSample sample = new WildcardSample();
		sample.callWildcardMethod();
	}

	public void callWildcardMethod() {
		WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
		// WildcardGeneric<?> wildcard = new WildcardGeneric<String>();
		wildcard.setWildcard("A");
		wildcardStringMethod(wildcard);
	}

	/*public void wildcardStringMethod(WildcardGeneric<String> c) {
		String value = c.getWildcard();
		System.out.println(value);
	}*/

	public void wildcardStringMethod(WildcardGeneric<?> c) {
		Object value = c.getWildcard();
		System.out.println(value);
	}
}
