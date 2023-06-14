package lr8.Ex2;

public class Book {
    private final String bookName;
    private final String author;
    private final String year;

    public Book(String title, String author, String year) {
        this.bookName = title;
        this.author = author;
        this.year = year;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "{Название книги ='" + bookName + '\'' +
                ", Автор='" + author + '\'' +
                ", Год выпуска=" + year + "}" + '\n';
    }
}
