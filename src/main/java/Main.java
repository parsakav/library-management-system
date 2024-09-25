import exceptions.BookNotAvailableException;
import exceptions.BookNotFoundException;
import model.Book;
import service.BookService;
import service.BookServiceImpl;

import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    private static final BookService bookService;
    static {
        bookService=new BookServiceImpl();
    }
    static Scanner scanner
             = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1-Add book");
            System.out.println("2-Borrow book");
            System.out.println("3-Return book");
            System.out.println("4-Find book by isbn");
            System.out.println("5-Show available books");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    addBook();
                    break;
                case 2:
                   borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    findBook();
                    break;
                case 5:
                    bookService.getAvailableBooks().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Command not found");
                    break;
            }
        }

    }

    private static void findBook() {
        System.out.println("Enter isbn or <q> to return:");
        var text=  scanner.nextLine();
        if(text.contains("<q>")){
            return;
        }
        try {
            Optional<Book> book = bookService.findBook(text);
     Book book1 =book.orElseThrow();
            System.out.println(book1);
        } catch (Exception e){
            log.log(Level.SEVERE,e.getMessage());
        }

    }

    private static void returnBook() {
        System.out.println("Enter isbn or <q> to return:");
        var text=  scanner.nextLine();
        if(text.contains("<q>")){
            return;
        }
        try {
            Optional<Book> book = bookService.returnBook(text);
            System.out.println("Book returned successfully");
            System.out.println(book.get());
        } catch (NullPointerException e){
            log.log(Level.SEVERE,e.getMessage());
        }


    }

    private static void borrowBook() {
        System.out.println("Enter isbn or <q> to return:");
        var text=  scanner.nextLine();
        if(text.contains("<q>")){
            return;
        }
        try {
            Optional<Book> book = bookService.borrowBook(text);
            System.out.println("Book borrowed successfully");
            System.out.println(book.get());
        } catch (NullPointerException e){
            log.log(Level.SEVERE,e.getMessage());
        }
        catch (BookNotFoundException e){
            log.log(Level.WARNING,e.getMessage());

        }
        catch (BookNotAvailableException e){
            log.log(Level.WARNING,e.getMessage());

        }


    }

    private static void addBook() {

        System.out.println("Enter title,isbn,author or <q> to return:");
      var title=  scanner.nextLine();
      if(title.contains("<q>")){
          return;
      }
       var isbn= scanner.nextLine();
       var author= scanner.nextLine();
       Book book= new Book(title,isbn,author);
       try {
           bookService.addBook(book);
           System.out.println("Book added successfully");
       } catch (NullPointerException e){
          log.log(Level.SEVERE,e.getMessage());
       }

    }
}
