import java.util.ArrayList;

public class Student {

    //create private variables
    private String name;
    private final int idxSpace;//index position of the space
    private String department;
    private int age;
    private String userName;
    private int studentNumber;
    boolean fullTime;//if true == fullTime // if false == part-time
    ArrayList <Grade> grades = new ArrayList<>();

    //constructor
    public Student(String C_name,String C_department, int C_age, int C_studentNumber, boolean C_fullTime){
        name = C_name;
        department = C_department;
        age = C_age;
        studentNumber = C_studentNumber;
        fullTime = C_fullTime;

        //split name to fist and last
        //Reference:
        //https://stackoverflow.com/questions/36096484/splitting-full-name
        idxSpace = name.lastIndexOf(' ');//find the index position of "Space"
        //declare first and last with substring ()
        // to store first name from name
        String firstName = name.substring(0, idxSpace); //store string value from index 0 to idxSpace
        //to store last name from name
        String lastName = name.substring(idxSpace + 1);//store string value beyond indexSpace +1

        //declare username = 1st initial + 4 letter last name + student number
        //declare userName and convert the result to lowercase()
        this.userName= (firstName.charAt(0) + lastName.substring(0,4) + studentNumber).toLowerCase();
    }

    //getter method
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
    public int getAge(){
        return age;
    }
    public int getStudentNumber(){
        return studentNumber;
    }
    public String getUserName(){
        return userName;
    }
    public boolean getFullTime(){
        return fullTime;
    }

    //setter method
    public void setMethod(String name, String department,int age, String userName, int studentNumber, boolean fullTime){
        this.name= name;
        this.department= department;
        this.age= age;
        this.userName= userName;
        this.studentNumber= studentNumber;
        this.fullTime= fullTime;
    }

    //toString method
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", idxSpace=" + idxSpace +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                ", studentNumber=" + studentNumber +
                ", fullTime=" + fullTime +
                ", grades=" + grades +
                "}\n";
    }
}
