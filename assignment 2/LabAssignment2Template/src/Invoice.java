public class Invoice {
    //properties (data)
    int id;
    String description;
    int quality;
    double unitPrice;
    boolean paid;

    //constructor
    public Invoice (int idC, String descriptionC, int qualityC, double unitPriceC){
        id = idC;
        description = descriptionC;
        quality = qualityC;
        unitPrice =unitPriceC;
        //set paid to false
        paid = false;
    }

    //add a toString() method
    public String toString() {
        //creating object
        Object InvoiceItem= "InvoiceItem[" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quality=" + quality +
                ", unitPrice=" + unitPrice +
                ", paid=" + paid +
                ']';
        //return object
        return String.valueOf(InvoicItem);
    }

    //create getter and setter methods for paid
    //getter method
    public boolean getPaid(){
        return paid;
    }

    //setter method
    public void setPaid(boolean paid){
        this.paid = paid;
    }
}


