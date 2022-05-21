public class Q3 {
    public static void main(String[] args) {

        double salary = 22000;

        //write your code here to calculate the tax of the variable salary, make sure you try multiple values
        // to test your work
        double taxToPay;
        //compare salary to work out taxRate to pay
        if (salary > 50000){
            taxToPay = (salary - 50000) * 0.40 + (15000) * 0.05 + (20000) * 0.20;
        }
        else if (salary > 30000 && salary <= 50000){
            taxToPay = (salary - 30000) * 0.20 + (15000) * 0.05;
        }
        else if (salary > 15000 && salary <= 30000){
            taxToPay = (salary - 15000) * 0.05;
        }
        else {
            taxToPay = 0.00;
        }

        //creating a variable to store the 2 decimal places rounded salary
        String salaryTwoDecimalPlaces = (String.format("%.2f",salary));
        String taxToPayTwoDecimalPlaces = (String.format("%.2f",taxToPay));

        //output information
        //(String.format("%.2f",value))  present to 2 decimal places
        System.out.print("Total tax on £" + salaryTwoDecimalPlaces + " is £" + taxToPayTwoDecimalPlaces );
    }
}
