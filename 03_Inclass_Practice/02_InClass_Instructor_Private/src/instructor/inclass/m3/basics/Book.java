package instructor.inclass.m3.basics;

/** Complete instructor reference based on the Canvas Book starter. */
public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;

    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void read() {
        System.out.println("Reading " + title + " by " + author + ".");
    }

    public static void main(String[] args) {
        Book book = new Book("Core Java", "Cay Horstmann", 928, 59.99);

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Pages: " + book.getPages());
        System.out.println("Price: $" + book.getPrice());

        book.read();
        book.setPrice(49.99);
        System.out.println("Updated price: $" + book.getPrice());
    }
}
