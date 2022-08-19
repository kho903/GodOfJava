public class ControlWhile {
	public static void main(String[] args) {
		ControlWhile control = new ControlWhile();
		control.whileLoop();
		System.out.println();
		control.whileBreak();
		System.out.println();
		control.whileContinue();
		control.whileContinueInfinite();
	}
    
	public void whileLoop() {
		ControlOfFlow control = new ControlOfFlow();
		int loop = 0;
		while (loop < 12) {
			loop++;
			control.switchCalendar(loop);
		}
	}
	
	public void whileBreak() {
		ControlOfFlow control = new ControlOfFlow(); 
		int loop = 0; 
		while (loop < 12) { 
			loop++; 
			control.switchCalendar(loop);
			if (loop == 6) break;
		}
	}

	public void whileContinue() {
		ControlOfFlow control = new ControlOfFlow(); 
		int loop = 0; 
		while (loop < 12) { 
			loop++;
			if (loop == 6) continue;
			control.switchCalendar(loop);
		}
	}

	public void whileContinueInfinite() {
		ControlOfFlow control = new ControlOfFlow();
		int loop = 0;
		while (loop < 12) {
			if (loop == 6) continue;
			loop++;
			control.switchCalendar(loop);
		}
	}
}
