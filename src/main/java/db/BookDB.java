package db;

import model.Book;

import java.util.*;
import java.util.List;


/**
 * This class perform crud operation like a database
 */
public class BookDB {


    private Set<Book> books= new HashSet<>();
    private static  BookDB instance=null;
    private BookDB(){

    }


    // thread safe static factory method
    public static BookDB getInstance() {
        if (instance == null) {

            synchronized (BookDB.class) {

                //double-checked locking
                    if (instance == null) {

                    instance = new BookDB();
                }
            }
        }
        return instance;
    }





    private boolean addBook(Book book){

        if(books.contains(book)){
            return false;
        }

        books.add(book);
        return true;
    }
    //We use optional to prevent nullpointerexception
public Optional<Book> findBook(String isbn){
return books.parallelStream().filter(e->e.getIsbn().equals(isbn)).findFirst();
    }


}
