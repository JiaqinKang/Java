public class Password {
    //static generator
    public static String Generator(int length, int symbols, int digits) {
        //variables contain the chars for easy analyse
        String num = "0123456789";
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String symList = "~!@#$%^&*()_+{}|<>?";
        //string stores all the chars
        String chars = num + letters + symList;

        //length counting
        int passLength = 0;
        int numCount = 0;
        int lettersCount = 0;
        int symbolCount = 0;

        //define and create an array to store password wit
        char[] password = new char[length];

        //calculate letters left to fill with random letter index
        //this fix the bug that after meeting the requirement for symbols and digits
        //and fill the remaining length space with only letter a
        int fillLetters = length - symbols - digits;

        //debug code to check
        // System.out.println(fillLetters);

        //if remaining fill is less than 0 means will output error then exit the program
        //else generate the password correctly
        if (fillLetters < 0) {
            //output error
            System.out.println("Error, can not meet the requirement as the total count for symbols and digits is greater than total Length");
            //exit program
            System.exit(0);
        }
        else{
            //a while loop to generate password till it reach the requirement length
            while (passLength < length) {
                //create int randomIndex that takes a random
                int randomIndex = (int) (Math.random() * chars.length());
                //check numbs
                if (randomIndex < 10) { //10 is index range for numbers
                    if (numCount < digits) {
                        //add numbs
                        password[passLength] = chars.charAt(randomIndex);
                        //increase number count
                        numCount++;
                        //increase password length count
                        passLength++;
                    }
                }

                //check letters
                //else if check index range of letters in chars
                else if (10 <= randomIndex && randomIndex < 62) { //index range 10 - 62 for letters in chars
                    if (lettersCount < fillLetters) {
                        //add letters
                        password[passLength] = chars.charAt(randomIndex);
                        //increase count and pass length
                        lettersCount++;
                        passLength++;
                    }
                }

                //symbols
                else {
                    //check symbolCount
                    if (symbolCount < symbols) {
                        //add symbol
                        password[passLength] = chars.charAt(randomIndex);
                        //increase count and pass length
                        symbolCount++;
                        passLength++;
                    }
                }
            }
        }
        //return generated password result in String
        return (new String(password));
    }


    //Validation by taking the argument String password
    public static String validation(String password) {
        //creating a length variable for easy coding
        int length = password.length();

        //creating variable counts
        int symCount = 0;
        int numCount = 0;
        int lowerCaseCount = 0;
        int upperCaseCount = 0;

        //creating a for loop to check each index of password and increase count for later checking process
        for(int i=0;i<length;++i) {
            //create a variable char j to define the position of password index for easy coding
            char j = password.charAt(i);
            //check numbers if falls between 0-9
            if('0'<=j && j<='9'){
                //increment counts for numbers
                numCount++;
            }
            //check for lower case by compare char a - z
            else if('a'<=j && j <='z'){
                //increment counts for lower case letters
                lowerCaseCount++;
            }
            //check for upper case by compare char A -Z
            else if('A'<=j && j<='Z'){
                //increment counts for upper case letters
                upperCaseCount++;
            }
            //else it's symbols
            else{
                //increment counts for the remaining (which can only be symbols)
                symCount++;
            }
        }
        //After checking the password Checking password complexity by each count
        //Excellent
        if(length >= 16 && numCount > 4 && symCount > 4 && lowerCaseCount != 0 && upperCaseCount != 0){
            return "Excellent";
        }

        //condition Good
        if(length > 12 && numCount > 3 && symCount > 3  && lowerCaseCount != 0 && upperCaseCount != 0){
            return "Good";
        }

        //condition ok
        if(length > 8 && numCount > 2 && symCount > 1){
            return "ok";
        }

        //else return poor
        else{
            return "Poor";
        }
    }










}