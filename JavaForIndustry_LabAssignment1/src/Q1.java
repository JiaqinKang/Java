import java.text.NumberFormat;
import java.util.Locale;

public class Q1 {
    public static void main(String[] args) {
        //write your code here to output the employee details
        //set up variables
        int  ID_Number = 12345;
        String name = "\"Jack Smith\"";
        int age = 52;
        double salary = 27736.80;
        int yearsToRetirement = 66;
        double hourlyRate;
        int workingHourWeekly = 35;
        int weeksOfaYear = 52;

        //calculate how many years to retire
        int retirementYearsLeft = yearsToRetirement - age;

        //calculate how many working hours within a year
        int totalWorkingHourYearly = workingHourWeekly * weeksOfaYear;
        //calculate hourlyRate
        hourlyRate = salary / totalWorkingHourYearly;

        //convert currency format
        Locale uk = new Locale("en","GB");
        //create a variable to get the UK currency instance
        NumberFormat poundFormat = NumberFormat.getCurrencyInstance(uk);
        //create variable to store the correct format value
        String salaryFormatted = poundFormat.format(salary);
        String hourlyRateFormatted = poundFormat.format(hourlyRate);
        //////// currency formatted debug output
        //System.out.println(variable);
        ////////

        //output information
        System.out.println("Employee Reference");
        System.out.println("__________________");
        System.out.println("ID Number: " + ID_Number);
        System.out.println("Name: " + name);
        System.out.println("age: " + age);
        System.out.println("Salary: " + salaryFormatted);
        System.out.println("Years left to retirement: " + retirementYearsLeft);
        System.out.println("Hourly rate: " + hourlyRateFormatted);
    }
}
