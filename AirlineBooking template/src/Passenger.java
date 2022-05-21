public class Passenger extends Person{
    //2 additional private instance variables
    private int holdBags;//to store the number of hold bags they have booked
    private String flightClass;//whether they are travelling economy or first class


    //a constructor that takes a string name and a passport
    //number. It should call the super constructor you created in person
    public Passenger(String name, int passportNumber,int holdBags, String flightClass) {
        super(name, passportNumber);
        this.flightClass = flightClass;
        this.holdBags = holdBags;
    }

    public Passenger(String name, int passportNumber,String flightClass,int holdBags) {
        super(name, passportNumber);
        this.holdBags = holdBags;
        this.flightClass = flightClass;
    }

    //getters and setters
    public int getHoldBags() {
        return holdBags;
    }

    public void setHoldBags(int holdBags) {
        this.holdBags = holdBags;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    //first 87.5 plus 25 for each bag
    //economy 80 plus 25 for each bag
    @Override
    public double calculatePersonWeight() {
        double personWeight = 0;
        //default weights for diff flight classes
        if (flightClass.equals("first")){
            personWeight += 87.5;
        }
        if (flightClass.equals("economy")){
            personWeight += 80;
        }
        // 25 for each (*) bag
        personWeight += 25 * holdBags;
        return personWeight;
    }
}
