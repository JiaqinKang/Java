import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight {
    //The flight class brings together all the components and completes the system.
    //Flight should have the following private members
    private int flightNumber; //• an integer flightNumber
    private Aircraft craft; //• an Aircraft craft
    private String startLocation; //• a String startLocation
    private String endLocation; //• a String endLocation
    private double distance; //• a double distance

    //Create getters and setters for each variable
    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Aircraft getCraft() {
        return craft;
    }

    public void setCraft(Aircraft craft) {
        this.craft = craft;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    //The class should also include the following
    //public members:
    public ArrayList<Seat> seats; //• An arrayList seats that stores elements of type Seat
    public ArrayList<CrewMember> crew;//• An arrayList crew that stores elements of the type Crew

    //constructor for Flight. that takes as arguments. flightNumber, craft, startLocation,
    //endLocation and distance. It should use these values to initialise the private members.
    public Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance) {
        this.flightNumber = flightNumber;
        this.craft = craft;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        //It should also initialise the 2 ArrayLists.
        seats = new ArrayList<>();
        crew = new ArrayList<>();
        //call populate the seats Arraylist method
        populateSeats();
    }

    //Crate a populateSeats method for easy access to be called in constructor
    //for populate seats
    private void populateSeats(){
        //exception handle
        try{
            //Using the layoutFile from the craft as input create a new scanner.
            Scanner sc= new Scanner(craft.getLayoutFile());
            //declare variables for line and its index position
            String line;
            int lineIndex = 1; //row index start from 1
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                //split the strings with String.split()
                String[] flyingClass = line.split(",");
                for (int i = 0; i < flyingClass.length; i++) {
                    //add seats a
                    if (flyingClass[i].equals("E")){
                        seats.add(new Seat(lineIndex, i + 1, "economy"));
                    }
                    if (flyingClass[i].equals("F")){
                        seats.add(new Seat(lineIndex, i + 1, "first"));
                    }
                }
                //increment lineIndex
                lineIndex++;
            }
        } catch (FileNotFoundException e) { //handle the file not found exception with catch
            System.out.println("layout file not found");
        }
    }

    //CalculateTakeOffWeight should take no arguments and return a double.
    public double calculateTakeOffWeight(){
        double takeOffWeight = 0;
        //for each all passenger add every passenger's weight according to their allocation
        for (Seat seat : seats){
            if (seat.getAllocatedTo() != null){
                takeOffWeight  += seat.getAllocatedTo().calculatePersonWeight();
            }
        }
        //for each crew add all crew's weight
        for (CrewMember crewMember : crew){
            takeOffWeight += crewMember.calculatePersonWeight();
        }
        //lastly add craft weight too
        takeOffWeight += craft.getCraftWeight();

        //return the weight unless it is larger than the maximum takeoff weight, return -1
        if (takeOffWeight > craft.getMaximumTakeoffWeight()){
            return -1;
        }
        //return takeoffWeight
        return takeOffWeight;
    }

    //BookSeat should take a Passenger as the only argument and return an int.
    public int bookSeat(Passenger passenger) {
        //Find the next available seat that matches the passengers flightClass
        // and allocate the passenger to it by setting the allocatedTo variable
        // of the available seat.
        /////////////////////////////
        //return value outcome     //
        //1 booking completed      //
        //2 passenger upgraded     //
        //3 passenger downgraded   //
        //-1 plane full            //
        /////////////////////////////
        String targetBookFlightClass = passenger.getFlightClass();
        Seat seatChoice = null;
        //check all available seats
        for (Seat seat : seats) {
            //if seat is null meaning available seat
            if (seat.getAllocatedTo() == null) {
                // if seats is available
                if (seat.getFlyingClass().equals(targetBookFlightClass)) {
                    //allocate seats for the passenger i.e. booking success
                    seat.setAllocatedTo(passenger);
                    //booking completed return value 1
                    return 1;
                }else {
                    if (seatChoice == null) {
                        seatChoice = seat;
                    }
                }
            }
        }
        //If no seats are available in the class you can upgrade or downgrade the passenger
        if (seatChoice != null) {
            seatChoice.setAllocatedTo(passenger);
            //if passenger seat choice is first class return 2 for upgrade
            if (seatChoice.getFlyingClass().equals("first")) {
                return 2;
            }
            //if passenger seat choice is first class return 2 for upgrade
            if (seatChoice.getFlyingClass().equals("economy")) {
                return 3;
            }
        }
        //plane full
        return -1;
    }

    //•How many first class passengers are booked on
    int totalFirstClassPassengersAreBookedOn=0;
    //• How many economy passengers
    int totalEconomyClassPassengersAreBookedOn=0;
    //• How many seats are unallocated
    int totalSeatsThatAreUnallocated = 0;

    //toString:
    //Override the toString method of Flight to display the flight information.
    @Override
    public String toString() {

        //check all seat for their seats
        for (Seat seat : seats){
            if (seat.getAllocatedTo() != null) {
                // if seats == first class
                if (seat.getFlyingClass().equals("first")) {                    //increment total first class passenger count +1
                    totalFirstClassPassengersAreBookedOn++;
                } else {
                    //increment total economy seats count +1
                    totalEconomyClassPassengersAreBookedOn++;
                }
            } else {
                //increment total unallocated seats count +1
                totalSeatsThatAreUnallocated++;
            }
        }



        //declare new string arraylist for all crew members
        ArrayList<String> crewMembersNames = new ArrayList <>();
        //iterate all crewMember class's crew members name
        for (CrewMember crewMember : crew){
            //add crew member names to the arraylist
            crewMembersNames.add(crewMember.getName());
        }

        return "-------------\n"+
                "* Flight #"+flightNumber+" *\n"+
                "-------------\n"+
                "From: " + startLocation + "\n" +
                "To: " + endLocation + "\n" +
                "Distance: " + distance + "\n" +
                "First class passengers: " + totalFirstClassPassengersAreBookedOn + "\n" +
                "Economy passengers: " + totalEconomyClassPassengersAreBookedOn + "\n" +
                "Unallocated seats: " + totalSeatsThatAreUnallocated + "\n" +
                "crew: " + crewMembersNames.toString().replace("[", "").replace("]", "") +"\n"+
                craft.toString();
    }
}
