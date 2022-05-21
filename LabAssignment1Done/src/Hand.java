import java.util.ArrayList;
import java.util.TreeMap;

public class Hand {
    private final ArrayList<Card> hand = new ArrayList<>();
    private final String[] ranks = {"Royal Flush", "Straight Flush", "4-of-a-kind", "Full House", "Flush", "Straight",
            "3-of-a-kind", "2 Pair", "1 Pair", "High Card"};

    public void addCard(Card c){
        if(hand.size() < 5){
            hand.add(c);
        }
    }


    //check cards suits in hand with frequencies
    public TreeMap<String, Integer> sortSuits(){
        TreeMap<String,Integer> suits = new TreeMap<>();
        //iterate the cards in hand to find frequency of each suit
        for (Card card : hand) {
            //position
            String nextSuit = String.valueOf(card.getSuit());
            //checking if statement to find frequency and when found +1 to the frequency
            if (suits.containsKey(String.valueOf(card.getSuit()))) {
                suits.put(nextSuit, suits.get(nextSuit) + 1);
            } else {
                //number that appeared once will have a frequency to 1
                suits.put(String.valueOf(card.getSuit()), 1);
            }
        }
        //return the treemap with all the suits frequencies
        return suits;
    }
    
    //check cards suits in hand with frequencies
    public TreeMap<Integer, Integer> sortValues(){
        TreeMap<Integer, Integer> Values = new TreeMap<>();
        //iterate the cards in hand to find frequency of each suit
        for (Card card : hand) {
            //position
            int nextValue = card.getNumericValue();
            //checking if statement to find frequency and when found +1 to the frequency
            if (Values.containsKey(card.getNumericValue())) {
                Values.put(nextValue, Values.get(nextValue) + 1);
            } else {
                //number that appeared once will have a frequency to 1
                Values.put(card.getNumericValue(), 1);
            }
        }
        //return the treemap with all the suits frequencies
        return Values;
    }


    //check card if is in order////////////
    public boolean checkAscendingRowOrder (){
        //create an integer type arraylist to store
        ArrayList<Integer> order = new ArrayList<>();
        //add all the card values to the array
        for (Card c : hand){
            //add to the array by only accessing the numericalValue
            //because we don't need any other information
            order.add(c.getNumericValue());
        }
        //once the array is formed with store data
        //don't need to sort the arraylist again because is automatically sorted in ascending order

        //now check if it is in ascending row order
        //initiate a int type first variable for easy access
        //which takes the argument value of order.get position 0;
        int first = order.get(0);
        //initiate a count for later checking if all the card is in ascending order
        //if count < || != 4 || > 4 meaning the cards are not in ascending order
        int count = 0;
        //
        for (int i = 1 ; i < 5 ; i ++){
            //increment the first value by 1 to check if the next position is equal to new expected value
            if ((first + 1) == order.get(i)){
                //increment count
                count ++;
                //increment the value of first so next compare will be n + 1
                first += 1;
            }
        }
        //only return true if count == 4 meaning is in sequence/row ascending order
        //any count != 4 meaning card is not in ascending order
        return count == 4;

    }

    public String getHandRank(){

        if(hand.size() != 5){
            return "Incorrect hand size";
        }
        //sort the hand
        hand.sort(new SortCards());

        //easy access for is ascending order
        boolean isAscendingOrder = checkAscendingRowOrder();

        //easy access for treemap suits
        TreeMap<String,Integer> suits = sortSuits();

        //easy access for treemap values
        TreeMap<Integer,Integer> values = sortValues();


        //one pair ( a pair of cards with the same value e.g. 7D, 7H, 4S, 6H, 8H)
        ////check values.size is == 4 meaning there is at least one pair
        if (values.size () == 4){
            return ranks[8];
        }
        //two pair (2 pairs of matched values e.g. 7D, 7H, 4S, 4C, 2D)
        ////check value.size is == 3 and
        ////values.containsValue (from treemap) dose not contains the value 3
        ////meaning there is no 3 of kinds because 3 of kind also can only have a size of 3
        ////this avoids wrong return to 3 of kinds
        if (values.size () == 3 && !values.containsValue(3)){
            return ranks[7];
        }

        //3 of a kind (3 cards with the same value and two others e.g. 7D, 7H, 7C, 2H, KS)
        if (values.size () == 3 && values.containsValue(3)){
            return ranks[6];
        }

        //royal flush (J,Q,K,A,10 all the same suit)
        ////suits size 1 meaning all same suits, isAscendingOrder
        ////and only if values contains A (this is the only case) then its royal flush
        if (suits.size() == 1 && isAscendingOrder && values.containsKey(14)){
            return ranks[0];
        }

        //straight flush (5 cards in a row all the same suit e.g. 3S, 4S, 5S, 6S, 7S)
        ////suits size 1 meaning all same suits, isAscendingOrder
        ////these are the requirement a straight flush will contain
        if (suits.size() == 1 && isAscendingOrder){
            return ranks[1];
        }

        //full house (3 of a kind and a pair e.g. 7S, 7H, 7D, 4C, 4H)
        if (values.size () == 2 && values.containsValue(2) && values.containsValue(3)) {
            return ranks[3];
        }

        //4 of a kind (4 cards with the same value e.g. 9S, 9C, 9H, 9D, 7D)
        if (values.size () == 2 && values.containsValue(4)){
            return ranks[2];
        }


        //straight (A run of values in different suits e.g. 3H, 4D, 5H, 6C, 7S)
        ////is AscendingOrder == straight
        ////size is no longer require checking as all the complicated case has
        ////been checked already above
        if (isAscendingOrder) {
            return ranks[5];
        }

        //flush (All cards are in the same suit e.g. 3H, 7H, 9H, JH, KH)
        ////suits size == 1 meaning only 1 suit exist
        ////other requirement checking is no longer needed as all the complicated case
        //// has been checked already above
        if (suits.size() == 1){
            return ranks[4];
        }

        //high card (None of the other hands match, the highest value of the card)
        return ranks [9];
    }

    public String toString(){
        String output = "";
        for(Card c: hand){
            if(c.getSuit().equals("Hearts") || c.getSuit().equals("Diamonds")) {
                output += "\u001B[31m[ " + c.getValue() + " , " + c.getSuit() + " ] \u001B[0m";
            }
            else{
                output += "[ " + c.getValue() + " , " + c.getSuit() + " ] ";
            }
        }
        return output;
    }
}
