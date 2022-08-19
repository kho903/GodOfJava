public class ControlIfElse {

    public static void main(String[] args) {
        ControlIfElse control = new ControlIfElse();
        control.ifElseStatement();
    }

    public void ifElseStatement() {
        // int intValue = 10;
		int intValue = 5;

        if (intValue > 5) System.out.println("It's bigger than 5.");
        else System.out.println("It's smaller than or equal to 5.");
        
        if (intValue <= 5)
            System.out.println("It's smaller than or equal to 5.");
        else 
            System.out.println("It's bigger than 5.");
    }
}

