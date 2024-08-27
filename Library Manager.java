import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }
}

class Library {
    ArrayList<Book> bookList;

    public Library() {
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(String isbn) {
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.isbn.equals(isbn)) {
                iterator.remove();
                break;
            }
        }
    }

    public void displayBooks() {
        for (Book book : bookList) {
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
            System.out.println("Availability: " + book.isAvailable);
            System.out.println();
        }
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter author: ");
                String author = scanner.nextLine();
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("Enter availability (true/false): ");
                boolean isAvailable = scanner.nextBoolean();
                library.addBook(new Book(title, author, isbn, isAvailable));
            } else if (choice == 2) {
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                library.removeBook(isbn);
            } else if (choice == 3) {
                library.displayBooks();
            } else if (choice == 4) {
                break;
            }
        }

        scanner.close();
    }
}
