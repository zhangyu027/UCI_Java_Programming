package student.finalproject.library;

/**
* Student starter model for one library book.
*
* The fields and getters are provided so the team can focus on
* JDBC, menu workflow, persistence, and project integration.
*/
public class Book {

    private final int id;
    private final String title;
    private final String author;
    private final int availableCopies;

    public Book(
    int id,
    String title,
    String author,
    int availableCopies) {

        /*
        * TODO / OPTIONAL VALIDATION:
        * - id should be greater than 0
        * - title should not be blank
        * - author should not be blank
        * - availableCopies should not be negative
        *
        * HINT:
        * throw new IllegalArgumentException("message");
        */

        this.id = id;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    @Override
    public String toString() {

        /*
        * TODO / OPTIONAL:
        * Customize the display format if your team wants a different layout.
        */

        return id
        + " | "
        + title
        + " | "
        + author
        + " | copies="
        + availableCopies;
    }
}
