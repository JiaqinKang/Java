import java.util.ArrayList;
import java.util.List;
public class Q2 {
    public static void main(String[] args) {
        int numbers = -1; //set to -1 to debug the while loop as 0 is even number too
        //creating arraylist to store outputs
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> fourMultiples = new ArrayList<>();
        List<String> threeFiveMultiples = new ArrayList<>();
        while ( numbers < 1000){
            //each loop i increase 1
            numbers ++;

            //part 1: display even numbers between 0 and 1000
            //check if number is even then if is true add number to the list
            if ( numbers % 2 == 0){
                even.add(numbers);
            }

            //part 2: display odd numbers between 0 and 1000
            //check if number is odd then if is true add number to the list
            if ( numbers % 2 != 0 ){
                odd.add(numbers);
            }

            //part 3: display all the multiples of 4 between 0 and 1000
            //check multiples of 4 and exclude number 0
            if ( numbers % 4 == 0 && numbers> 0){
                fourMultiples.add(numbers);
            }

            //part 4: display all the numbers between 1 and 1000 replacing multiples of 3 with Java
            //multiples of 5 with Script and multiples of 3 and 5 with JavaScript
            if ( numbers ==0){
                //do nothing to debug when numbers ==0
            }
            else if ( numbers !=0 && (numbers % 5 == 0 && numbers % 3 == 0 )){
                //push word to arraylist not the value
                threeFiveMultiples.add("JavaScript");
            }
            else if (numbers % 3 == 0){
                //push word to arraylist not the value
                threeFiveMultiples.add("Java");
            }
            else if (numbers % 5 == 0){
                //push word to arraylist not the value
                threeFiveMultiples.add("Script");
            }
            else {
                //push to arraylist
                threeFiveMultiples.add(String.valueOf(numbers));
            }
        }
        //output results for all the questions
        System.out.println("Even numbers between 0-1000:" + even);
        System.out.println("Odd numbers between 0-1000:" + odd);
        System.out.println("Multiples of 4 between 0-1000:" + fourMultiples);
        System.out.println(" replacing words between 0-1000 for multiples of 3,5 and 3 and 5:" + threeFiveMultiples);
    }
}
