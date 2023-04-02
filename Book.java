/* basic unit of the collection */
public class Book {

    /* INSTANCE VARIABLES */
    // they're private so that they can't be accessed directly from outside the class
    private String title;
    private String author;
    private int yearPublished;

    /* CONSTRUCTOR */
    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    /* GETTERS */
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYearPublished() {
        return yearPublished;
    }

    /* SETTERS */
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
}
