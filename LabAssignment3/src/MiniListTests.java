public class MiniListTests {

    //add elements to the array
    public static void main(String[] args) {

        MyMiniList<String> ml = new MyMiniList<String>();

        ml.add("aliceblue");//1
        ml.add("antiquewhite");
        ml.add("aqua");
        ml.add("aquamarine");
        ml.add("azure");//5
        ml.add("beige");
        ml.add("bisque");
        ml.add("black");//8  //array position 7
        ml.add("blanchedalmond");//9
        ml.add("blue");//10  //array index position = 9
        ml.add("blueviolet");//11
        ml.add("brown");
        ml.add("burlywood");
        ml.add("cadetblue");
        ml.add("chartreuse");//15
        ml.add("chocolate");//16
        ml.add("coral");//17 //array index position =16
        ml.add("cornflowerblue");
        ml.add("cornsilk");
        ml.add("crimson");//20
        ml.add("cyan");//
        ml.add("darkblue");
        ml.add("darkcyan");
        ml.add("darkgoldenrod");
        ml.add("darkgray");//25
        ml.add("darkgreen");
        ml.add("darkgrey");
        ml.add("darkkhaki");
        ml.add("darkmagenta");
        ml.add("darkolivegreen");//30
        ml.add("coral");// total 31

        //check array
        //System.out.println(String.valueOf(ml));
        //System.out.println("the size of ml is " + ml.size());

        //get element at index
        String atIndex = ml.get(23);
        //checking invalid index
        //String atIndex2 = ml.get(99);

        System.out.println("At the 23rd Location is " + atIndex);

        //checking invalid index
        //System.out.println("At the 99rd Location is " + atIndex2);//should to be null

        //get first occurance of
        int n = ml.getIndex("coral");
        System.out.println("coral is at " + n);

        //set value at an index
        ml.set(9, "testUpdate");
        //System.out.println("testUpdate2 index is at: "+ml.getIndex("testUpdate"));
        //System.out.println("the size of ml is " + ml.size());

        ml.set(23, "testUpdate2");
        //System.out.println("testUpdate2 index is at: "+ml.getIndex("testUpdate2"));
        //System.out.println("the size of ml is " + ml.size());

        //remove by object
        ml.remove("crimson");
        //remove by index
        ml.remove(7);

        //System.out.println("//Section output every element in the array");
        for(int i = 0; i< ml.size(); i++){
            System.out.println(ml.get(i));
        }
        //System.out.println("the size of ml is now " + ml.size());
        //System.out.println("//End Section output every element in the array");

        //clear
        ml.clear();
        System.out.println("the size of ml is " + ml.size());
    }
}

