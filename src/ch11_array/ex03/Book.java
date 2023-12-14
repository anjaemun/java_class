package ch11_array.ex03;

public class Book {
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private int bookPrice;
    private String bookPublisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id = " + id +
                ", bookTitle = '" + bookTitle + '\'' +
                ", bookAuthor = '" + bookAuthor + '\'' +
                ", bookPrice = " + bookPrice +
                ", bookPublisher = '" + bookPublisher + '\'' +
                '}';
    }

    public Book(){

    }
    public Book(Long id, String bookTitle, String bookAuthor, String bookPublisher, int bookPrice){
        this.id = id;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookPublisher = bookPublisher;
        this.bookTitle = bookTitle;

    }
}
