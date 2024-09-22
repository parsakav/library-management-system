package db;

import db.BookDB;
import exceptions.BookNotAvailableException;
import exceptions.BookNotFoundException;
import model.Book;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class BookDBTest {

    static BookDB  bookDB;

   Book book2= new Book("paya2","paya12345","paya2");
   Book book1= new Book("paya1","paya1234","paya1");
    public static   Set<Book> books;

    @BeforeEach
    public void beforEach(){
    }
    @BeforeAll
    public static void setup(){
        books= new HashSet<>();
        bookDB   = new BookDB(books);

  }
    @Test
    @Order(1)
    public void addBookShoudReturnTrueWhenBookIsnotDuplicate() {
        boolean returnValue = bookDB.addBook(book1);
        assertEquals(returnValue, true);

    }
    @Test
    @Order(2)

public void addBookShoudReturnFalseWhenBookIsDuplicate(){
        boolean returnValue = bookDB.addBook(book1);
        assertEquals(returnValue,false);

    }
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"paya1234"})
    public void findBookTestShoudReturnBook(String isbn){
        BookDB  bookDB = new BookDB(books);
        Optional<Book> book = bookDB.findBook(isbn);
        assertEquals(book.isPresent(),true);

    }
    @Order(4)
    @ParameterizedTest
    @ValueSource(strings = {"x"})
    @NullAndEmptySource
    public void findBookTestShoudNotReturnBook(String isbn){
        Optional<Book> book = bookDB.findBook(isbn);
        assertEquals(book.isPresent(),false);

    }

    @Test()
    @Order(5)
    public void borrowBookShoudoccuresNotFoundException() {
        Assertions.assertThrows(BookNotFoundException.class,
                () -> bookDB.borrowBook("12")
        );
    }
        @Test()
    @Order(6)
    public void borrowBookShoudChangeAvailablityFalse(){
            Book book = bookDB.borrowBook("paya1234");
            assertEquals(book.isAvailable(),false);



    }       @Test()
    @Order(7)
    public void borrowBookShoudOccursBookNotAvailableExceptionWhenBookBorrowed(){
        Assertions.assertThrows(BookNotAvailableException.class,
                () ->      bookDB.borrowBook("paya1234")
        );

    }

}
