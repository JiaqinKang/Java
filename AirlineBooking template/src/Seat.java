public class Seat {
    //Create a new class called seat. This is going to represent the seats available on the plane
    private int row; //• an integer row
    private int seat; //• an integer seat (location in the row)
    private String flyingClass; //• a String flyingClass
    private Passenger allocatedTo; //• a Passenger allocatedTo

    //Create the private members with a getters and setters:
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getFlyingClass() {
        return flyingClass;
    }

    public void setFlyingClass(String flyingClass) {
        this.flyingClass = flyingClass;
    }

    public Passenger getAllocatedTo() {
        return allocatedTo;
    }

    public void setAllocatedTo(Passenger allocatedTo) {
        this.allocatedTo = allocatedTo;
    }

    //Create a constructor that sets the row the seat and the flyingClass.
    public Seat(int row, int seat, String flyingClass) {
        this.row = row;
        this.seat = seat;
        this.flyingClass = flyingClass;
    }
}
