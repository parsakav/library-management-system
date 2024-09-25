package service;

import db.BookDB;
import model.Book;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
public class BookServiceTest {

    private Book book;
   private BookDB bookDB;
private BookService bookService;

   @BeforeEach
    public void before(){
        this.bookDB = mock(BookDB.class);
        this.book=mock(Book.class);
bookService = new BookServiceImpl(bookDB);
        when(bookDB.addBook(Mockito.notNull(Book.class))).thenReturn(true);
        when(bookDB.borrowBook(Mockito.notNull(String.class))).thenReturn(Optional.of(book));
        when(bookDB.returnBook(Mockito.notNull(String.class))).thenReturn(Optional.of(book));
        when(bookDB.findBook(Mockito.notNull(String.class))).thenReturn(Optional.of(book));
        when(bookDB.getAvailableBooks()).thenReturn(Collections.singletonList(book));
when(book.getTitle()).thenReturn("x");
when(book.getAuthor()).thenReturn("x");
when(book.getIsbn()).thenReturn("x");


   }
   @Test
    public void addBookNullTestShoudOccursNullPointerException(){
       Assertions.assertThrows(NullPointerException.class,()->{
           bookService.addBook(new Book(null,null,null));
       });

   }
   @Test
    public void addBookEmptyTestShoudOccursNullPointerException(){
       Assertions.assertThrows(NullPointerException.class,()->{
           bookService.addBook(new Book("","",""));
       });

   }
   @Test
   public void addBookTestShoudReturnTrue(){
   assertTrue(bookService.addBook(book));

   }   @Test
   public void borrowBookShoudReturnAnObject(){
   assertNotNull(bookService.borrowBook("1234"));

   }
   @Test
    public void borrowBookEmptyInputShoudOccurNullpointerException(){
        Assertions.assertThrows(NullPointerException.class,()->{
            bookService.borrowBook("");
        });
   }
   @Test
   public void borrowBookNullInputShoudOccurNullpointerException(){
        Assertions.assertThrows(NullPointerException.class,()->{
            bookService.borrowBook(null);
        });
   }  @Test
   public void returenBookNullInputShoudOccurNullpointerException(){
        Assertions.assertThrows(NullPointerException.class,()->{
            bookService.returnBook(null);
        });
   }  @Test
   public void returenBookEmptyInputShoudOccurNullpointerException(){
        Assertions.assertThrows(NullPointerException.class,()->{
            bookService.returnBook("");
        });
   }  @Test
   public void returnBookShouldReturnAnObject(){
        assertNotNull(bookService.returnBook("1234"));

    }
}
