package instructor.inclass.m3.basics;

public class Book {
    private String title, author;
    public Book(String t, String a) {
        title=t;
        author=a;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String x) {
        title=x;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String x) {
        author=x;
    }
    public void read() {
        System.out.println("Reading "+title+" by "+author);
    }
}
