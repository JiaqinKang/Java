import java.io.File;
public class Aircraft {
    //Create an aircraft class that has the following private members
    private String make; //• A string make
    private String model; //• A string model
    private String tailNumber; //• A String tailNumber
    private double craftWeight; //• A double craftWeight
    private double maximumTakeoffWeight; //• A double maximumTakeoffWeight
    private File layoutFile; //• A File layoutFile

    //create getters and setters for each one.
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public double getCraftWeight() {
        return craftWeight;
    }

    public void setCraftWeight(double craftWeight) {
        this.craftWeight = craftWeight;
    }

    public double getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(double maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    public File getLayoutFile() {
        return layoutFile;
    }

    public void setLayoutFile(File layoutFile) {
        this.layoutFile = layoutFile;
    }

    //a constructor for the class that populates the above variables in the order shown above.
    public Aircraft(String make, String model, String tailNumber, double craftWeight, double maximumTakeoffWeight, File layoutFile) {
        this.make = make;
        this.model = model;
        this.tailNumber = tailNumber;
        this.craftWeight = craftWeight;
        this.maximumTakeoffWeight = maximumTakeoffWeight;
        this.layoutFile = layoutFile;
    }

    //Override the toString method for the class printing out the aircraft, make, model, tail
    //number, weight and maximum takeoff weight.
    @Override
    public String toString() {
        return "Make: " + make + " " +
                "Model: " + model + " " +
                "tailNumber: " + tailNumber + " "+
                "weight: " + craftWeight +" "+
                "maximum takeoff weight: " + maximumTakeoffWeight;
    }
}
