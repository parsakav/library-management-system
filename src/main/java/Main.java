import java.util.Scanner;

public class Main {
    static Scanner scanner
             = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1-Add book");
            System.out.println("2-Borrow book");
            System.out.println("3-Return book");
            System.out.println("4-Find book by isbn");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    addBook();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Command not found");
                    break;
            }
        }

    }

    private static void addBook() {
    }
}
