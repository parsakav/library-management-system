package service;

import db.BookDB;
import model.Book;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
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

   }
}
