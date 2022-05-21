import java.util.*;

public class MainChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean biggerPaid = false;

        double price = 0.00, paid = 0.00;

        while (!biggerPaid) {
            price = getMoneyInput("Enter the price in pounds and pence", in);
            paid = getMoneyInput("Enter the amount paid in pounds and pence", in);
            if (price > paid) {
                System.out.println("You haven't paid enough!");
            } else {
                biggerPaid = true;
            }
        }

        System.out.println("price " + price);
        TreeMap<NotesAndCoins, Integer> changeComposition = calcChange(price, paid);
        for (NotesAndCoins n : changeComposition.keySet()) {
            if (changeComposition.get(n) != 0) {
                System.out.println(n.getName() + ": " + changeComposition.get(n));
            }
        }
    }

    //takes input from the user and ensures it is a double and returns a double with 2 decimal places
    //Question(String) is the prompt for user input and (in)scanner is collecting user input
    public static double getMoneyInput(String question, Scanner in) {
        boolean validInput = false;
        double amount = 0.00;
        //do this until the user enters a valid double
        while (!validInput) {
            System.out.println(question);
            try {
                amount = in.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input try again");
                in.next();
            }
        }
        //return the value entered fixed to 2dp
        return (double) ((int) (amount * 100)) / 100;
    }

    public static TreeMap<NotesAndCoins, Integer> calcChange(double price, double paid) {
        TreeMap<NotesAndCoins, Integer> change = new TreeMap<>();
        //value converter section
        int price1 = (int) (price * 100);
        int paid1 = (int) (paid * 100);

        //calculate change result
        int result = paid1 - price1;
        //find change details to give
        for (NotesAndCoins e : NotesAndCoins.values()) {//foreach loop to iterate through al the elements
            if (result >= e.getValueInP()){//if change is greater or equal to notes
                result -= e.getValueInP();//subtract
                change.put(e,1);//insert to treemap
                //while loop to make sure all the larges note is subtracted
                //then it will move on to the next larges not to subtract
                while (result >= e.getValueInP()){//compare the result again
                    result -=e.getValueInP();//subtract
                    change.put(e,change.get(e) + 1);//increase count
                }
            }
        }
        //This method will return a TreeMap where the key is NotesAndCoins and the value is the number of each denomination to make up the change
        return change;
    }

}

