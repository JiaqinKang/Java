public class Q1Main {
    public static void main(String[] args) {
        //        int idC, String descriptionC, int qualityC, double unitPriceC
        Invoice test1 =  new Invoice(11,"test",1,10.00);
        Invoice test2 =  new Invoice(3,"test2",1,11.00);
        //set paid to true
        test1.setPaid(true);
        test2.setPaid(true);
        //test debug output
        System.out.println(test1);
        System.out.println(test2);
    }
}
