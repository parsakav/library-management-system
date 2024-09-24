package service;

import model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

   public boolean addBook(Book book);
public Optional<Book> findBook(String isbn);
public Optional<Book> borrowBook(String isbn);
 public Optional<Book>  returnBook(String isbn);
 List<Book> getAvailableBooks();
}
