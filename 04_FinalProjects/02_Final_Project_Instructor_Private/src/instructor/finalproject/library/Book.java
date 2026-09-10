package instructor.finalproject.library;

/**
* Immutable book model used by the instructor reference solution.
*/
public record Book(
int id,
String title,
String author,
int availableCopies) {
    public Book {
        if (id <= 0) {
            throw new IllegalArgumentException(
            "Book ID must be greater than 0.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
            "Title is required.");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException(
            "Author is required.");
        }
        if (availableCopies < 0) {
            throw new IllegalArgumentException(
            "Available copies cannot be negative.");
        }
        title = title.trim();
        author = author.trim();
    }
    @Override
    public String toString() {
        return id
        + " | "
        + title
        + " | "
        + author
        + " | copies="
        + availableCopies;
    }
}
