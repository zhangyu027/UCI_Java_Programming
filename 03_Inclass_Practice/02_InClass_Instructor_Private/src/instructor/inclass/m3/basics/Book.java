package instructor.inclass.m3.basics;

/** Canvas-aligned Module 3 basic class example. */
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public static void main(String[] args) {
        Book book = new Book("Core Java", "Cay Horstmann");
        book.displayInfo();
    }
}
