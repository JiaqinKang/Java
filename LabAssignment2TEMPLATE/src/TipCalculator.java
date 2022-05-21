import javax.swing.*;
import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TipCalculator {
    TipCalculator () {
        //creating the frame with configurations
        JFrame frame = new JFrame("Meal splitter");//create the frame
        frame.setSize(300, 180);//declare the frame size
        frame.setLayout(new BorderLayout());//setting the frame layout
        frame.setResizable(false);//set frame resizable to false

        //panel declaring section
        JPanel textPanel = new JPanel();//create textPanel to be wrapped by the frame with different boarder layout
        JPanel gridText = new JPanel();//created a grid text to be wrapped by the text panel
        gridText.setLayout(new GridLayout(4, 2));//declaring grid size

        //label and textField declaring section
        //Price
        JLabel labelPrice = new JLabel("Price", SwingConstants.LEFT);//create text
        JTextField price = new JTextField("0", 8);//create text box to be filled
        //Tip
        JLabel labelTip = new JLabel("Tip(%)", SwingConstants.LEFT);//create text
        JTextField tip = new JTextField("0", 8);//create text box to be filled
        //People
        JLabel labelPeople = new JLabel("People(%)", SwingConstants.LEFT);//create text
        JTextField people = new JTextField("1", 8);//create text box to be filled

        //http://www.fredosaurus.com/notes-java/GUI/layouts/30gridlayout.html
        //according to this site there s no way to skip a cell, therefore an empty cell is created to fill the gap
        JLabel empty = new JLabel("");//empty fill
        JButton calculate = new JButton("Calculate");//create calculate button

        //Add data text Panel data section
        //order matters from left to right then top to down to fill the grid automatically
        textPanel.add(gridText);//wrapping gridPanel with textPanel
        //gridPanel data inserting
        gridText.add(labelPrice);
        gridText.add(price);
        gridText.add(labelTip);
        gridText.add(tip);
        gridText.add(labelPeople);
        gridText.add(people);
        gridText.add(empty);//empty fill
        gridText.add(calculate);

        //text output result panel
        JPanel result = new JPanel();
        JLabel output = new JLabel("Each person should pay £0");
        result.add(output);

        //mapping textPanel to the frame by inserting the panels into the right layout
        frame.add(textPanel, BorderLayout.CENTER);
        frame.add(result, BorderLayout.PAGE_END);

        //set frame to be visible otherwise nothing will show up
        frame.setVisible(true);//set frame visible
        //close frame when frame close button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//terminate program

        //calculate button pressed action listener
        calculate.addActionListener(e -> {
            try{
                //declaring easy accessible variables with value for later calculation
                double s1 = Double.parseDouble(price.getText());
                double s2 = 1 +Double.parseDouble(tip.getText()) / 100;
                int s3 = Integer.parseInt(people.getText());

                //calculation section with simple error handling else statement
                if (s3 >0){
                    //calculate each person fees
                    double result1 = (s1 * (s2) / s3);
                    //decimal formatter because currency is displayed in 2 decimal places
                    //source reference https://java2blog.com/format-double-to-2-decimal-places-java/
                    DecimalFormat df = new DecimalFormat("#.##");//set to 2 decimal place for the currency display
                    df.setRoundingMode(RoundingMode.UP);//set formatting round up for currency
                    //output the result to the frame
                    output.setText("Each person should pay £" + df.format(result1) );
                } else{ //error handling as people can not be anything but type int and greater than 0
                    output.setText("Invalid input");//helpful error output
                }
            }catch(NumberFormatException a ){ //founded error handling
                output.setText("Invalid input");//error output
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TipCalculator::new);
        }
}
