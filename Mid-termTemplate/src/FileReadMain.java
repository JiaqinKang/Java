import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadMain {
    private static String words;
    public static void main(String[] args) {
        readFile();
        getNumberOfWords();
        getNumberSentence();
        getNumberParagraphs();
    }

    //Read in the file that has provided for you in the template using the Scanner class
    public static void readFile(){
        //declare file type named file with correct pathname
        File file = new File("Metamorphosis.txt");
        Scanner sc = null;
        //error handing if file can't fine
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //scanner scans line by line with nextLine while loop
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            words = str + "\n";
            //print to screen
            System.out.println(str);
        }
        //stop scanner
        sc.close();
    }

    //Length in characters
    public static void getLengthInChar(){
        //I don't get this question length in characters
    }

    //Number of words
    public static void getNumberOfWords(){
        //find word with split by spaces and store in the array
        String[] numberWords = words.split(" ");
        //System print out the total number words which is equal to the length of the numberWords array
        System.out.println("Number of word is: "+numberWords.length);

    }

    //Number of sentences

    public static void getNumberSentence(){
        //declare count to track . ! ?
        int SentenceCount = 0;
        //a for loop to loop through the file
        for (int i = 0; i < words.length();i ++){
            String sentence = Character.toString(words.charAt(i));
            //if statement to check for .!? as sentence are end with these marks
            // so by calculating number of .!? will terming number of sentence
            if (sentence.equals(".") || sentence.equals("!") || sentence.equals("?")){
                //increase sentence count if sentence is found
                SentenceCount++;
            }
        }
        //System print the result
        System.out.println("Number of sentences is: "+SentenceCount);
    }

    //Number of paragraphs
    public static void getNumberParagraphs(){
        //declare count for paragraphs
        int paragraphsCount = 0;
        String Paragraph = "";
        //a for loop works the same way to loop through the words to find \n
        for (int i = 0; i < words.length(); i++) {
            //loop through every char in words to find "\n"
            Paragraph = Character.toString(words.charAt(i));
            //when Paragraph is
            if (Paragraph.equals("\n")) {
                //paragraphs count increase by 1 when every paragraph is found when "\n" is found
                paragraphsCount++;
            }
        }
        //System print the result
        System.out.println("paragraph number is " + paragraphsCount);
    }
}
