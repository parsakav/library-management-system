package db;

import exceptions.BookNotAvailableException;
import exceptions.BookNotFoundException;
import model.Book;

import java.util.*;
import java.util.List;


/**
 * This class perform crud operation like a database
 */
class BookDB {


    private final Set<Book> books;
    public BookDB(Set<Book> books){
        this.books=books;

    }
    public BookDB(){
       this.books= new HashSet<>();;

    }






    public boolean addBook(Book book){

        if(books.contains(book)){
            System.out.println("Contains");
            return false;
        }

        books.add(book);
        return true;
    }
    //We use optional to prevent nullpointerexception
public Optional<Book> findBook(String isbn){
return books.parallelStream().filter(e->e.getIsbn().equals(isbn)).findFirst();
    }

    public Book  borrowBook(String isbn){
       Book book= findBook(isbn).orElseThrow(()->
           new BookNotFoundException());
       if(!book.isAvailable()){
           throw new BookNotAvailableException();
       }
           book.setAvailable(false);
        System.out.println(book.toString());
           return book;


    }


}
