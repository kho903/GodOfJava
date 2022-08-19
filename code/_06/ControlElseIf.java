public class ControlElseIf {
    public static void main(String[] args) {
        ControlElseIf control = new ControlElseIf();
        control.elseIf(85);
		control.elseIf2(75);
    }
 
    public void elseIf(int point) {
        if (point > 90) {               // 90점 초과일 경우
            System.out.println("A");
        } else if (point > 80) {        // 80점 초과일 경우 90점 이하일 경우
            System.out.println("B");
        } else if (point > 70) {        // 70점 초과일 경우 80점 이하일 경우
            System.out.println("C");
        } else if (point > 60) {        // 60점 초과일 경우 70점 이하일 경우
            System.out.println("D");
        } else {                        // 60점 이하일 경우
            System.out.println("F");
        }
    }

	public void elseIf2(int point) {
    	System.out.println(point > 90 ? "A" : point > 80 ? "B" : point > 70 ? "C" : point > 60 ? "D" : "F");
	}
}
