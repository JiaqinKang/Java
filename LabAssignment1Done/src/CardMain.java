import java.util.Arrays;

public class CardMain {
    public static void main(String[] args) {
        Deck d = new Deck(true);
        System.out.println(d);

        Hand h = new Hand();
        for(int i = 0; i<5; i++) {
            h.addCard(d.deal());
        }

        //deal specific card check
//        for(int i = 0; i<5; i++) {
//            h.addCard(d.dealSpecificCard("10","Diamonds"));
//            h.addCard(d.dealSpecificCard("J","Diamonds"));
//            h.addCard(d.dealSpecificCard("Q","Diamonds"));
//            h.addCard(d.dealSpecificCard("K","Diamonds"));
//            h.addCard(d.dealSpecificCard("A","Diamonds"));
//        }

        System.out.println("Card in the hand = " + h);

//        //check order
        System.out.println("Is card in order? = "+(h.checkAscendingRowOrder()));
//
//        //finding suits frequencies
        System.out.println("card Value frequencies = "+h.sortValues());
//
//        //finding suits frequencies
        System.out.println("suits frequencies = "+h.sortSuits());

        System.out.println("HandRank = " + h.getHandRank());



















    }
}
