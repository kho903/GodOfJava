public class SmartPhone {

	String name;
	int battery;
	boolean power;

	public SmartPhone() {

	}

	public void turnOn() {
		power = true;
	}

	public void turnOff() {
		power = false;
	}

	public void runApplication(String appName) {
		System.out.println(appName + "이 켜집니다.");
		battery -= 1;
	}
}
