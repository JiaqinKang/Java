import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BookCollection {

        private final ArrayList<Book> books = new ArrayList<Book>();

        //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
        //When complete books should have 100 items. Make sure you don't include the header row!
        BookCollection(String path) {
            path = "BookList.csv";
            //calling converter
            converter(path);
        }

        //file converter to be used in question 2 constructor for easy access
        public void converter(String path){
            try {
                //use java scanner to read the file
                Scanner sc = new Scanner(new File(path));
                //skip the first line
                sc.nextLine();
                // while hashNext() loops line-by-line
                while (sc.hasNext()) {
                    //separate the strings by line
                    String line = sc.nextLine();
                    //then separate the strings with split function by ","
                    String[] temp = line.split(",");
                    //create and add new object, push data from stored temp array with correct data types
                    books.add(new Book(temp[0],temp[1],Long.parseLong(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),Integer.parseInt(temp[5])));
                }
                sc.close();//close file read
            } catch (FileNotFoundException e) {//catch error file not found exception
                System.out.println("File not found!");//error message output
                System.exit(0);//then exit the program
            }
        }


    //3, Return a HashSet of all the authors in the book list
    public HashSet getAuthors(){
            //Create a new hashset string to store the information
            HashSet <String> authors = new HashSet<>();
            //iterate through the books with foreach to find
            for (Book a : books){
                //add authors in to the authors hashset
                authors.add(a.getAuthor());
            }
            //return output the hashset of all the authors in the book list
            return authors;
    }


    //4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks(){
            //an arraylist is created to store the data
            ArrayList longBooks = new ArrayList<>();
            //find books page > 750
            //use for each loop to iterate through the books
            for (Book b : books){
                //create a temp variable name pageSize to store and get the book page for easy access
                int pageSize = b.getPages();
                //use if statement to compare the page size and
                //if book page is > 760 then add books to the arraylist
                if ( pageSize > 750){
                    //add books title to the arraylist
                    longBooks.add(b);
                }
            }
            //return the arraylist output with stored book tiles that has pages greater than 750 pages
            return longBooks;
    }

    //5, return the book if the given title is in the list.
    public Book getBookByTitle(String title){
            //iterate through all books in the arraylist
            for (Book c : books){
                //if given title is equal to the object book title then return the object
                if (title.equals(c.getTitle())){
                    return c;//return the book object when is found
                }
            }
            //else title not find, return null
            return null;
    }

    //6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular(){
            //crate a Book object array with length of 10
            // later on to be used to store the most 10 books
            Book[] arr = new Book [10];
            //crate an arraylist
            ArrayList <Book> tenMostPopular = new ArrayList<>();
            //for each loop add books to arraylist
            for (Book d : books){
                //adding all books to the arraylist
                tenMostPopular.add(d);
            }

            //sort the arraylist with copies on loan in reversed order high to low
            tenMostPopular.sort(Comparator.comparingInt((Book::getCopiesOnLoan)).reversed());

            //crate a for loop
            for (int i = 0 ; i < arr.length ; i ++){
                //add most 10 copies to the array
                arr[i] = (tenMostPopular.get(i));
            }

            //output the 10 most popular books
            return arr;
    }
}