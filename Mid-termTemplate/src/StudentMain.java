import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    //declare arraylist
    private  static ArrayList <Student>students;
    //import Scanner for user inputs
    private static Scanner scanner = new Scanner(System.in);

    //register students with given examples
    private static void registerStudents(){
        students = new ArrayList();
        Student example;
        example = new Student("Bert Smith","computing", 21,12345,true);
        example.grades.add(new Grade("programming", 52));
        example.grades.add(new Grade("web dev", 63));
        example.grades.add(new Grade("maths", 72));
        example.grades.add(new Grade("algorithms", 68));
        students.add(example);

        example = new Student("Olivia Green","computing", 19, 23464 ,true);
        example.grades.add(new Grade("programming", 73));
        example.grades.add(new Grade("web dev", 82));
        example.grades.add(new Grade("maths", 72));
        example.grades.add(new Grade("algorithms", 66));
        students.add(example);

        example = new Student("Eloise Jones","computing", 18, 34744, true);
        example.grades.add(new Grade("programming", 65));
        example.grades.add(new Grade("web dev", 63));
        example.grades.add(new Grade("maths", 37));
        example.grades.add(new Grade("algorithms", 40));
        students.add(example);

        example = new Student("Ben Bird","computing", 42, 34834, false);
        example.grades.add(new Grade("programming", 55));
        example.grades.add(new Grade("web dev", 29));
        example.grades.add(new Grade("maths", 56));
        example.grades.add(new Grade("algorithms", 38));
        students.add(example);

        example = new Student("Karen Brown" ,"computing", 25, 45632, false);
        example.grades.add(new Grade("programming", 62));
        example.grades.add(new Grade("web dev", 51));
        example.grades.add(new Grade("maths", 43));
        example.grades.add(new Grade("algorithms", 43));
        students.add(example);
    }

    //declare main for executions
    public static void main(String[] args) {
        //register the example students along with their info
        registerStudents();
        //start/run to show the main menu option to the console
        mainMenu();
    }

    //menu page
    private static void mainMenu(){
        //declare a menu string variable for easy access
        String menu = (
                """
                        1.Print out a report of all students including lettered grades for each module score
                        2.Print the name of all students with a failed module
                        3.print out average grade for each student
                        4.Add a new student to the system taking in name,surname, department, age, student number and a grade for each of the four modules
                        5.Quit the program"""
        );
        // print the menu options with the menu String variable
        System.out.println(menu);
        //scan for user input with while true function
        while (true){
            String userInput = scanner.nextLine();
            // check for user inputs and when correct option is picked trigger valid methods
            switch (userInput) {
                case "1" -> //"1."+"Print out a report of all students including lettered grades for each module score\n" +
                        allReport();
                case "2" -> //"2."+"Print the name of all students with a failed module\n" +
                        failedStudentWithModule();
                case "3" -> //"3."+"print out average grade for each student\n" +
                        averageScore();
                case "4" -> //"4."+"Add a new student to the system taking in name,surname, department, age, student number and a grade for each of the four modules\n" +
                        addNewStudent();
                case "5" -> //5. exit
                        System.exit(0);
                //debugging when user input invalid key option
                default -> {
                    //error message print
                    System.out.println("invalid input, please select accordingly");
                    //clare the console
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    //show menu options again
                    System.out.println(menu);
                }
            }
        }
    }

      ////////////////////////////////
     //Declare menu option methods///
    ////////////////////////////////

    //"1."+"Print out a report of all students including lettered grades for each module score\n" +
    private static void allReport(){
        //print the students array list report
        System.out.println(students);
    }

    //"2."+"Print the name of all students with a failed module\n" +
    private static void failedStudentWithModule(){
        ArrayList<String> failedStudent = new ArrayList<>();
        //check every student in students array list
        for (Student student : students) {
            //check every grade in the student's grade array list
            for (Grade grade : student.grades) {
                //check for any failed module by their scores
                if (grade.getScore() >= 0 && grade.getScore() < 40) {
                    //add failed student name when a failed module is found
                    failedStudent.add(student.getName());
                    //break when any of their first failed result of the student is found
                    break;
                }
            }
        }
        //print out result
        System.out.println("These are the students with a failed module"+failedStudent);
    }

    //"3."+"print out average grade for each student\n" +
    private static void averageScore(){
        double avs;
        for (Student student :students){
            double totalScore = 0;//declare double average score
            for (Grade grade : student.grades){
                //add all the score together
                totalScore += grade.getScore();
            }
            //total score / the total number of subjects(grades.size) = average score
            avs = totalScore / student.grades.size();
            System.out.println(student.getName()+ "'s average score is "+ avs + '.');
        }
    }

    //"4."+"Add a new student to the system taking in name,surname, department, age, student number and a grade for each of the four modules\n" +
    private static void addNewStudent() {
        //print out question and store user input with scanner.nextLine variable
        System.out.println("Please enter the student name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the student department: ");
        String department = scanner.nextLine();
        System.out.println("Please enter the student's age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the student's student number: ");
        int studentNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the student's grade for programming: ");
        double programming = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the student's grade for web dev: ");
        double webDev = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the student's grade for maths：");
        double maths = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the student's grade for algorithms: ");
        double algorithms = Double.parseDouble(scanner.nextLine());

        //initialise the variables and add new student
        Student newStudent = new Student(name,department,age,studentNumber,true);
        newStudent.grades.add(new Grade("programming", programming));
        newStudent.grades.add(new Grade("web dev",webDev));
        newStudent.grades.add(new Grade("maths",maths));
        newStudent.grades.add(new Grade("algorithms",algorithms));
        students.add(newStudent);
    }
}
