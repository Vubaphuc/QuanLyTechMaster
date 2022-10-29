package model;

public class Book {
    private String idBook;
    private String nameBook;
    private String themeBook;
    private String bookAuthor;
    private int bookNumber;

    public Book() {
    }

    public Book(String idBook, String nameBook, String themeBook, String bookAuthor, int bookNumber) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.themeBook = themeBook;
        this.bookAuthor = bookAuthor;
        this.bookNumber = bookNumber;
    }


    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getBookTheme() {
        return themeBook;
    }

    public void setBookTheme(String bookTheme) {
        this.themeBook = themeBook;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook='" + idBook + '\'' +
                ", nameBook='" + nameBook + '\'' +
                ", bookTheme='" + themeBook + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookNumber=" + bookNumber +
                '}';
    }
}
