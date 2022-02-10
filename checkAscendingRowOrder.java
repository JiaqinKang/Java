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
