public class Q4 {
    public static void main(String[] args) throws java.io.IOException {
        //first display main menu to ask for user input
        System.out.println("Main Menu");
        System.out.println("1. Current accounts");
        System.out.println("2. Credit cards");
        System.out.println("3. Loans");
        System.out.println("4. Savings accounts");
        //then enters
        //while true loop to get user input and response base on the given argument
        char mainMenu;
        do {
            //ask for user input
            mainMenu = (char) System.in.read();
            System.in.read();
            //switch function to check for argument then make response
            switch (mainMenu) {
                //cases where user inputs string , system will output its current selected option
                case '1' -> System.out.println("You have select Current accounts");
                case '2' -> System.out.println("You have select Credit cards");
                case '3' -> System.out.println("You have select Loans");
                case '4' -> System.out.println("You have select Saving accounts");
                //terminate case if h is pressed (for hang up), which will terminate the program.
                case 'h' -> {
                    System.out.println("System exit");
                    System.exit(0);
                    //default case if user enters something invalid
                }
                default -> {
                    System.out.println("Main Menu");
                    System.out.println("1. Current accounts");
                    System.out.println("2. Credit cards");
                    System.out.println("3. Loans");
                    System.out.println("4. Savings accounts");
                }
            }
        } while (mainMenu !=5);
    }
}