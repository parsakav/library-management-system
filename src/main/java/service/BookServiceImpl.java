package service;

import db.BookDB;
import model.Book;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private final BookDB bookDB;

    public BookServiceImpl(BookDB bookDB) {
        this.bookDB = bookDB;
    }
public BookServiceImpl(){
        this.bookDB=new BookDB();
}
    @Override
    public boolean addBook(Book book) {
        if(book.getIsbn()== null || book.getIsbn().isEmpty()
    || book.getTitle()==null || book.getTitle().isEmpty()
        || book.getAuthor()==null || book.getTitle().isEmpty()){
            throw new NullPointerException("Book field's must be not null and not empty");
        }
        return bookDB.addBook(book);
    }

    @Override
    public Optional<Book> findBook(String isbn) {
       isbnCheck(isbn);
        return bookDB.findBook(isbn);
    }


    @Override
    public Optional<Book> borrowBook(String isbn) {
        isbnCheck(isbn);

        return bookDB.borrowBook(isbn);
    }

    @Override
    public Optional<Book> returnBook(String isbn) {
        isbnCheck(isbn);

        return bookDB.returnBook(isbn);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookDB.getAvailableBooks();
    }
    private final void isbnCheck(String isbn){
        if(isbn==null||isbn.isEmpty()){
            throw new NullPointerException( "Isbn must be not null and not empty");

        }
    }
}
