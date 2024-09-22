package db;

import db.BookDB;
import model.Book;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class BookDBTest {


    public static Set<Book> booksWithData;
    public static Set<Book> booksWithoutData;
    @BeforeAll
    public static void setup(){
        booksWithData=new HashSet<>();
        booksWithoutData=new HashSet<>();
        booksWithData.add(new Book("paya","paya1234","paya"));
        booksWithData.add(new Book("paya2","paya12345","paya2"));
    }

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"paya1234","paya12345"})
    public void findBookTestShoudReturnBook(String isbn){
        BookDB  bookDB = new BookDB(booksWithData);
        Optional<Book> book = bookDB.findBook(isbn);
        assertEquals(book.isPresent(),true);

    }  @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"x",""})
    public void findBookTestShoudNotReturnBook(String isbn){
        BookDB  bookDB = new BookDB(booksWithData);
        Optional<Book> book = bookDB.findBook(isbn);
        assertEquals(book.isPresent(),false);

    }

}
