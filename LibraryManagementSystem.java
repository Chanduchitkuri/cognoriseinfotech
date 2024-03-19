import java.util.ArrayList;

// Book class representing individual books
class Book {
    private String title;
    private String author;r
    private boolean status; // true if available, false if checked out

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = true; // by default, book is available
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

// LibraryCatalog class to manage books
class LibraryCatalog {
    private ArrayList<Book> books;

    // Constructor
    public LibraryCatalog() {
        books = new ArrayList<>();
    }

    // Method to add a book to the catalog
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to search for a book by title
    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // return null if book not found
    }

    // Method to search for books by author
    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to check out a book
    public boolean checkOutBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && book.getStatus()) {
            book.setStatus(false);
            return true; // book checked out successfully
        }
        return false; // book not available or not found
    }

    // Method to return a book
    public boolean returnBook(String title) {
        Book book = searchByTitle(title);
        if (book != null && !book.getStatus()) {
            book.setStatus(true);
            return true; // book returned successfully
        }
        return false; // book not checked out or not found
    }
}

// Main class to test the Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        // Adding some books to the library catalog
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("1984", "George Orwell"));

        // Searching for a book by title
        Book book1 = library.searchByTitle("To Kill a Mockingbird");
        if (book1 != null) {
            System.out.println("Book found: " + book1.getTitle() + " by " + book1.getAuthor());
        } else {
            System.out.println("Book not found.");
        }

        // Searching for books by author
        ArrayList<Book> booksByAuthor = library.searchByAuthor("George Orwell");
        System.out.println("Books by George Orwell:");
        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle());
        }

        // Checking out a book
        boolean checkoutResult = library.checkOutBook("To Kill a Mockingbird");
        if (checkoutResult) {
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Book not available or not found.");
        }

        // Returning a book
        boolean returnResult = library.returnBook("To Kill a Mockingbird");
        if (returnResult) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not checked out or not found.");
        }
    }
}
