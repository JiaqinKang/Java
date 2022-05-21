public class Q3Main {
    public static void main(String[] args) {
        //test password generator
        //System.out.print(Password.Generator(16,4,3));

        //Test validation by examples
        //6,2,1
        String test1= Password.Generator(6,2,1);
        System.out.println("Password: "+ test1 + " is " + Password.validation(test1));

        //14,4,5
        String test2= Password.Generator(14,4,5);
        System.out.println("Password: "+ test2 + " is " + Password.validation(test2));

        //9,2,3
        String test3= Password.Generator(9,2,3);
        System.out.println("Password: "+ test3 + " is " + Password.validation(test3));

        //9,2,2
        String test4= Password.Generator(9,2,2);
        System.out.println("Password: "+ test4 + " is " + Password.validation(test4));

        //18/5/6
        String test5= Password.Generator(18,5,6);
        System.out.println("Password: "+ test5 + " is " + Password.validation(test5));
    }
}
