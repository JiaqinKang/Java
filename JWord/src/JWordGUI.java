import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class JWordGUI {
    //declare a new arraylist
    static ArrayList<String> targetChars = new ArrayList<>();

    //declare variables to store target word
    public static String target;

    //a list of all possible 5-letter words in English
    public static HashSet<String> dictionary = new HashSet<>();

    //a smaller list of words for selecting the target word from (i.e. the word the player needs to guess)
    public static ArrayList<String> targetWords = new ArrayList<>();

    JWordGUI() {
        //starting message to user for basic instructions
        JOptionPane.showMessageDialog(null, """
                Guess the WORDLE in six tries.

                Each guess must be a valid five-letter word. Hit the tick button row accordingly to submit.

                After each guess, the color of the tiles will change to show how close your guess was to the word.

                ---------------------------------------------------------------------------------------------------
                Examples:

                (W) | E | A | R | Y
                The letter W is in the word and is in the correct spot, will be paint with green background

                P | (I) | L | L | S
                The letter I is in the word but in the wrong spot, will be paint with yellow background

                (V) | A | G | U | E
                The letter V is not in the word in any spot, will be paint with gray background
                ---------------------------------------------------------------------------------------------------
                """
        );

        // Create a new JFrame container.
        JFrame frame = new JFrame("Wordle");//create a new JFrame container
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set the default close operation to exit the program
        frame.setSize(400, 600);//set the size of the frame
        frame.setLayout(new BorderLayout());//set layout to border layout
        frame.setVisible(true);//make the frame visible
        frame.setResizable(false);//make the frame non-resizable
        
        // create JLabels
        JLabel AnswerHeader = new JLabel("Guess the word: ", SwingConstants.CENTER);//used to display the header
        AnswerHeader.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));//set the border

        // Create a new JPanel container.
        JPanel textPanel = new JPanel();//used to display the word
        textPanel.setLayout(new GridLayout(6, 1));//set the layout of the panel
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 0));//set the border

        // Create a new JPanel container wrapped by textPanel.
        JPanel[] textSubPanel = new JPanel[6];//create a new JPanel array for textFields
        JTextField[][] textField = new JTextField[6][5];//create a new JTextField array for textFields

        //create 2d array 6x5 jTextField to textSubPanel and textField to store the textFields
        for (int i = 0; i < 6; i++) {//row
            textSubPanel[i] = new JPanel();//create new panel in each row
            textSubPanel[i].setLayout(new GridLayout(0, 5));//set layout to 5 columns in each row
            textPanel.add(textSubPanel[i]); //add panel to textPanel
            //create 5x1 jTextField to textField
            for (int j = 0; j < 5; j++) { //column
                textField[i][j] = new JTextField(); //create new jTextField
                //set font size
                textField[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                //set alignment middle
                textField[i][j].setHorizontalAlignment(JTextField.CENTER);
                //add to textSubPanel
                textSubPanel[i].add(textField[i][j]);

                //if not first row disable textField for user input only for first row is enabled and the rest is disabled at the beginning
                if (i > 0) {//if not first row
                    textField[i][j].setEditable(false);//set textField to not editable
                }
            }
        }

        // Create a new JPanel container for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));
        //create gap between buttons on the right
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));

        //create 6 buttons with tick regex and add them to the button panel
        JButton[] buttons = new JButton[6];

        //visual representation of the buttons:
            /////textPanel///////  //////buttonPanel///////
            ////5 textFields/////  ////// 0 button  ///////   <- first row
            ////5 textFields/////  ////// 1 button  ///////   <- second row
            ////5 textFields/////  ////// 2 button  ///////   <- third row
            ////5 textFields/////  ////// 3 button  ///////   <- fourth row
            ////5 textFields/////  ////// 4 button  ///////   <- fifth row
            ////5 textFields/////  ////// 5 button  ///////   <- sixth row
            ////endTextPanel/////  //////endButtonPanel////

        for (int i = 0; i < buttons.length; i++) { // use a loop to create 6 buttons along with their same actionListener
            int finalI = i;//create a final variable to use in the actionListener

            buttons[i] = new JButton("\u2713"); //tick regex
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));

            //disable button action after first row to prevent user from entering data
            if (i > 0) {
                buttons[i].setEnabled(false);//disable button
                //set button to invisible
                buttons[i].setVisible(false);//set button to invisible
            }

            //create an actionListener for each button
            buttons[i].addActionListener(e -> { //when the button is pressed
                int checkWordLength = 5; //set the length of the word to 5
                //check if the button is pressed according to the button number
                if (e.getSource() == buttons[finalI]) { //if the button is pressed

                    StringBuilder checkWord = new StringBuilder(); //create a string to store the word
                    int count = 0; // check if all guesses are correct and filled green if number increases to 5 then the word is correct and the game is won

                    //first form the word from the textField
                    for (int i1 = 0; i1 < checkWordLength; i1++) { //use a loop to form the word
                        if (textField[finalI][i1].getText().length() > 1) {//check if the textField is filled with more than 1 character
                            //if the text field is more than one letter then show an error message
                            JOptionPane.showMessageDialog(frame, "Please enter a single letter in the text field");
                            break; //break the loop
                        } //else the text field is filled with one letter then add it to the string
                        checkWord.append(textField[finalI][i1].getText()); //add the letter to the word
                    }

                    System.out.println("Row "+ finalI +" input word = "+ checkWord.toString().toLowerCase()); //print the word to the console for debugging

                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    /////////////////////////error handling to ensure correct user input/////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if (checkWord.length() == 0) {
                        //if the word is empty then show an error message
                        JOptionPane.showMessageDialog(null, "invalid input, please fill all the fields");
                    }
                    else if (!checkWord.toString().matches("[a-zA-Z]+")) {
                        //if the word is not a letter then show an error message
                        JOptionPane.showMessageDialog(null, "invalid input, only alphabet allowed");
                    }
                    else if (checkWord.length()!=checkWordLength){
                        //if the word is not 5 letters then show an error message
                        JOptionPane.showMessageDialog(null, "can't proceed, only 5 letters allowed");
                    }
                    else {//if all the textFields are filled then proceed for further checks
                        //then check if the word is in the dictionary
                        if (!dictionary.contains(checkWord.toString().toLowerCase())) {//if the word is not in the dictionary then show an error message
                            JOptionPane.showMessageDialog(null, "word not found in dictionary, please try again");
                        } else {
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            ///////////////////////////////else proceed to check only after found in the dictionary /////////////////////////
                            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                            //if the char is contained in the target word &
                            //the position of that char is at correct position in arraylist targetChars &
                            //checkWordExists is true, then change the button to green
                            for (int j = 0 ; j < checkWordLength ; j++) { //loop through the target char
                                //when is checked then disable the textField
                                textField[finalI][j].setEditable(false); //disable the textField

                                //check if char contains in the target arraylist
                                //then set the textField background to yellow if the position is correct will be overwritten by green
                                //colouring process
                                //if the char exists in the target word first paint with yellow
                                //then check if the position is correct
                                //if the position is correct then paint with green
                                //if none of the conditions are true paint with grey
                                //colouring process:  yellow -> green -> grey

                                //if the char is contained in the target word
                                if (targetChars.contains(textField[finalI][j].getText())) {
                                    textField[finalI][j].setBackground(Color.yellow);//paint the textField with yellow
                                }

                                //if the char is contained in the target word & if the char is in the target word
                                if (j == targetChars.indexOf(textField[finalI][j].getText()) ||//if the char index is same as the position of the char in the target word
                                        textField[finalI][j].getText().equals(targetChars.get(j))) { //or if the char is same as the char in the target word
                                    textField[finalI][j].setBackground(Color.GREEN);//paint the textField with green
                                    count++;//increase count to verify if all the chars are correct

                                    //if count is equal to the length of targetChars arraylist and all chars are at the correct position
                                    //pop up a message that you have won the game
                                    if (count == targetChars.size()) {
                                        System.out.println("Word matched successfully: " + checkWord + " == " + target); //for testing
                                        //pop up a message that you have won the game
                                        JOptionPane.showMessageDialog(null, "You have won the game");

                                        /////////////disable all the textFields///////////////
                                        for (int i1 = 0; i1 < buttons.length; i1++) {//loop through the buttons
                                            buttons[i1].setEnabled(false);//disable all the buttons
                                            for (int k = 0; k < checkWordLength; k++) {//loop through the textFields
                                                textField[i1][k].setEditable(false);//disable all the textFields
                                            }
                                        }
                                    }
                                }

                                //if the char is not contained in the targetChars arraylist
                                //change the background to light gray
                                else if (!targetChars.contains(textField[finalI][j].getText())) {
                                    textField[finalI][j].setBackground(Color.LIGHT_GRAY);
                                }

                                ////////////////////////////////////////////////////////////////////////////////////////////////////
                                //////////////////////if the current row attempt is not equal to the target word////////////////////
                                ////////////////////////////////////////////////////////////////////////////////////////////////////
                                //then enable next row textFields to be editable disable current tick button
                                try{//try to catch an exception
                                    if (count != targetChars.size()) {
                                        //disable current row textFields and button
                                        buttons[finalI].setEnabled(false); //disable current tick button
                                        buttons[finalI].setVisible(false); //hide current tick button
                                        //enable next row textFields and button
                                        textField[finalI + 1][j].setEditable(true);//enable next row textFields to be editable
                                        buttons[finalI + 1].setEnabled(true);//enable next row tick button
                                        buttons[finalI + 1].setVisible(true);//show next row tick button
                                    }
                                }//catch an exception
                                catch (ArrayIndexOutOfBoundsException x){
                                    //do nothing
                                    System.out.println("ArrayIndexOutOfBoundsException");//print out the exception
                                }
                            }
                        }
                    }
                }
            });
            buttonPanel.add(buttons[i]);//add button to buttonPanel
        }

        JPanel menuPanel= new JPanel();//create a new JPanel
        menuPanel.setLayout(new GridLayout(1, 2));//set the layout of the buttonPanel to GridLayout

        //create restart button
        JButton restartButton = new JButton("Restart");//create restart button
        restartButton.setPreferredSize(new Dimension(100, 50));//set the size of the restart button
        restartButton.setFont(new Font("Arial", Font.PLAIN, 20));//set the font of the restart button
        menuPanel.add(restartButton);//add restart button to menuPanel
        restartButton.addActionListener(e -> {//add action listener to restart button
            //reset target word
            targetChars.clear();//clear arraylists
            target  = getTarget();//get a random target word
            pushTarget(target);//push target to arraylist

            //reset textFields
            //set all the textFields to empty string
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(true); //enable tick button
                buttons[i].setVisible(true); //show tick button
                if (i > 0) { //disable tick button again if it is not the first row
                    buttons[i].setEnabled(false);
                    buttons[i].setVisible(false);
                }
                for (int j = 0; j < textField[i].length; j++) {
                    textField[i][j].setText("");//set textField to empty string
                    textField[i][j].setEditable(true);//set textFields to be editable
                    textField[i][j].setBackground(Color.WHITE);//refresh the textFields background colour to white
                    if (i>0){//if it is not the first row
                        textField[i][j].setEditable(false);//set textFields to be uneditable
                    }
                }
            }
        });

        //create quit button next to restart button
        JButton quitButton = new JButton("Quit");//create quit button
        quitButton.setPreferredSize(new Dimension(100, 50));//set the size of the quit button
        quitButton.setFont(new Font("Arial", Font.PLAIN, 20));//set the font of the quit button
        menuPanel.add(quitButton);//add quit button to menuPanel
        quitButton.addActionListener(e -> {//add action listener to quit button
            System.exit(0);//exit the game
        });

        //add to the frame
        frame.add(AnswerHeader, BorderLayout.PAGE_START);
        frame.add(textPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.LINE_END);
        frame.add(menuPanel, BorderLayout.PAGE_END);
    }


    //import words from file
    public static void importWords(){//import words from file
        try{//try to catch an exception
            Scanner in_dict  = new Scanner(new File("gameDictionary.txt"));//create a scanner to read the file
            while(in_dict.hasNext()){//while there is a next line in the file
                dictionary.add(in_dict.next());//add the next line to the dictionary
            }
            Scanner in_targets = new Scanner(new File("targetWords.txt"));//create a scanner to read the file
            while(in_targets.hasNext()){//while there is a next line in the file
                targetWords.add(in_targets.next());//add the next line to the targetWords
            }
            in_dict.close();//close the scanner
            in_targets.close();//close the scanner
        } catch (//catch an exception
                FileNotFoundException e) {//if the file is not found
            e.printStackTrace();//print the stack trace
        }
    }

    //use this method for selecting a word. It's important for marking that the word you have selected is printed out to the console!
    private static String getTarget(){
        Random r = new Random();
        String target = targetWords.get(r.nextInt(targetWords.size()));
        //don't delete this line.
        System.out.println("Target word = "+ target);
        return target;
    }

    //push target to arraylist
    public static void pushTarget(String target) {//push target to arraylist
        for (int i = 0; i < target.length(); i++) {//push each letter of the target to the arraylist
            targetChars.add(String.valueOf(target.charAt(i)));//push each letter of the target to the arraylist
        }
        System.out.println("char arraylist = "+ targetChars);//print out the target to the console for testing
    }

    public static void main(String[] args) {
        importWords();//import words from file
        target  = getTarget();//get a random target word
        pushTarget(target);//push target to arraylist
        SwingUtilities.invokeLater(JWordGUI::new);//create a new JWordGUI
    }
}
