import java.util.ArrayList;
import java.util.List;

class Book {
    int bookId;
    String title;
    String author;
    int copies;

    Book(int bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "BookId: " + bookId + ", Title: " + title + ", Author: " + author + ", Available Copies: " + copies;
    }

    public boolean borrowBook() {
        if (copies > 0) {
            copies--;
            return true;
        } else {
            System.out.println("The book is not available in the library.");
            return false;
        }
    }

    public void returnBook() {
        copies++;
        System.out.println("Book return was successful.");
    }
}

class Member {
    int memberId;
    String name;
    boolean isSubscribed;
    List<String> members = new ArrayList<>();

    Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.isSubscribed = false;
    }

    public void addSubscription() {
        if (isSubscribed) {
            System.out.println("Member has already subscribed");
        } else {
            members.add(name);
            System.out.println(name + " has subscribed");
            isSubscribed = true;
        }
    }

    public void removeSubscription() {
        if (!isSubscribed) {
            System.out.println("Member has not subscribed before.");
        } else {
            members.remove(name);
            System.out.println(name + " has removed subscription.");
            isSubscribed = false;
        }
    }
}

class Library {
    String name;
    List<Book> books;

    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 5);
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", 9);

        Library library = new Library("My Library");
        library.addBook(book1);
        library.addBook(book2);

        Member member1 = new Member(1, "Alice");
        Member member2 = new Member(2, "Bob");

        member1.addSubscription();
        member2.addSubscription();

        library.displayBooks();
    }
}
