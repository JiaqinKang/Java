import javax.swing.*;
import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.TreeMap;

public class ChangeCalcGUI {
    ChangeCalcGUI () {
        //creating the frame with configurations
        JFrame frame = new JFrame("ChangeCalcGUI");//create the frame
        frame.setSize(400, 250);//declare the frame size
        frame.setLayout(new BorderLayout());//setting the frame layout
        frame.setResizable(false);//set frame resizable to false

        //panel declaring section
        JPanel textPanel = new JPanel();//create textPanel to be wrapped by the frame with different boarder layout
        JPanel gridText = new JPanel();//created a grid text to be wrapped by the text panel
        gridText.setLayout(new GridLayout(4, 2));//declaring grid size

        //label and textField declaring section
        //item Price
        JLabel itemPrice = new JLabel("Item Price", SwingConstants.LEFT);//create text
        JTextField price = new JTextField("0", 8);//create text box to be filled
        //paid Amounts
        JLabel paidAmount = new JLabel("Paid Amount", SwingConstants.LEFT);//create text
        JTextField paid = new JTextField("1", 8);//create text box to be filled
        //empty fill for grid gap
        JLabel empty = new JLabel("");//empty fill
        JButton calculate = new JButton("Calculate");//create calculate button

        //add data text Panel data section
        //order matters from left to right then top to down to fill the grid automatically
        textPanel.add(gridText);//wrapping gridPanel with textPanel
        //gridPanel data inserting
        gridText.add(itemPrice);
        gridText.add(price);
        gridText.add(paidAmount);
        gridText.add(paid);
        gridText.add(empty);//empty fill
        gridText.add(calculate);

        //text output result panel
        JPanel result = new JPanel();
        JLabel output = new JLabel("Given change should be £??");
        result.add(output);

        //change detail result panel
        JPanel resultBox = new JPanel();
        JLabel header = new JLabel("Result:");
        resultBox.add(header);
        resultBox.setLayout(new GridLayout(NotesAndCoins.values().length/3,3,1,1));

        //mapping Panels to the frame by inserting the panels into the right layout
        frame.add(textPanel, BorderLayout.LINE_START);
        frame.add(resultBox, BorderLayout.CENTER);
        frame.add(result, BorderLayout.PAGE_END);

        //set frame to be visible otherwise nothing will show up
        frame.setVisible(true);//set frame visible
        //close frame when frame close button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//terminate program

        //calculate button pressed action listener
        calculate.addActionListener(e -> {
            try{
                //declaring easy accessible variables with value for later calculation
                resultBox.removeAll();
                resultBox.add(new JLabel ("Result:"));
                double s1 = Double.parseDouble(price.getText());
                double s2 = Double.parseDouble(paid.getText());
                //calculate each person fees
                double result1 = (s2-s1);
                DecimalFormat df = new DecimalFormat("#.##");//set to 2 decimal place for the currency display
                df.setRoundingMode(RoundingMode.UP);//set formatting round up for currency
                //calculation section with simple error handling else statement
                if (s2 >s1){
                    //output given change total amount
                    output.setText("Given change should be £" + df.format(result1));//result text
                    //change to give details
                    ArrayList<String> outputSize = calcChange(s1,s2);//get result size for easy access
                    //add result to generate new JLable to display result
                    for (String s : outputSize) {
                        resultBox.add(new JLabel(s));//add result to JPanle
                        resultBox.revalidate();//reset based on the new component list
                        resultBox.repaint();//redraw frame
                    }
                }
                else if (s2 < s1){ //check paid amount is less than item price then display a message
                    output.setText("You haven't paid enough!");//helpful output if paid amount is less than item price
                }
                else if (s2 == s1){
                    output.setText("Exact amount is paid, no changes given!");//message change
                }
                else {
                    //debug
                    output.setText("Invalid input");//error output message
                }
                resultBox.revalidate();//reset based on the new component list
                resultBox.repaint();//redraw frame
            }catch(NumberFormatException a ){ //founded error handling
                //debug
                resultBox.removeAll();//clear result box,also remove previous data
                //reset frame appearance change detail section
                resultBox.add(new JLabel ("Result:"));
                resultBox.revalidate();//reset based on the new component list
                resultBox.repaint();//redraw frame
                //error message output
                output.setText("Invalid input");//error output message
            }
        });
    }

    public ArrayList<String> calcChange(double price, double paid) {
        ArrayList<String> output = new ArrayList<>();
        TreeMap<NotesAndCoins, Integer> change = new TreeMap<>();
        //type size convert
        int price1 = (int) (price * 100);
        int paid1 = (int) (paid * 100);
        //calculate the result
        int result = paid1 - price1;
        //push data to tree map
        for (NotesAndCoins e : NotesAndCoins.values()) {//foreach loop to iterate through al the elements
            if (result >= e.getValueInP()) {//if change is greater or equal to notes
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
        //section to only push the vlaue dose not equal to 0 (useful data) to the array list
        //for later use when creating jlable to the jpanel to frame
        for (NotesAndCoins n : change.keySet()) { //foreach loop to check all the elements
            if (change.get(n) != 0) {//check condition for usefull data
                output.add(n.getName() + "= " + change.get(n));//add to the arraylist
            }
        }
        //This method will return a TreeMap where the key is NotesAndCoins and the value is the number of each denomination to make up the change
        return output;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChangeCalcGUI::new);
    }

}
