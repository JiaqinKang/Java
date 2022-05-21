public abstract class Person {
    //Create a person class in the project. Person should have the following private instance variables.
    private String name;
    private int passportNumber;
    //create a constructor for the class with arguments for name and passportNumber
    public Person(String name, int passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public Person() {

    }

    public abstract double calculatePersonWeight();

    //Create a getter and setter method for each variable.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
