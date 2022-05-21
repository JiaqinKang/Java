import java.util.Arrays;

public class BookMain {
    public static void main(String[] args) {
        BookCollection bCollection = new BookCollection("BookList.csv");

        /////////////Section for testing////////////////////

        //Complete the function getAuthors, so that it returns a HashSet of all the authors in books.
        System.out.println("Book with all authors = "+bCollection.getAuthors());


        //Complete the function getLongBooks, so it returns an ArrayList of Books which have over 750
        //pages in them
        System.out.println("books with more than 750 pages = "+bCollection.getLongBooks());


        //Complete the function getBookByTitle, so it returns the Book object for the given title. If a title not in the list is given return null.
        ////null testing with empty string
        System.out.println("returns the book object for the given title = "+bCollection.getBookByTitle(""));
        ////not null testing with exiting book tile,expect return object
        System.out.println("returns the book object for the given title = "+bCollection.getBookByTitle("Frankenstein; Or The Modern Prometheus"));


        //Complete the function getMostPopularBooks which returns an array of the 10 most popular
        //books (That is those that currently have most copies on loan).

        System.out.println("10 most popular books = " + Arrays.toString(bCollection.mostPopular()));




    }
}
