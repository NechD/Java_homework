package lr8.Ex3;

import lr8.Ex2.Book;
import lr8.Ex2.ParserXml;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ParserJson {
    private final List<Book> books = new ArrayList<>();
    private static final String TAG_BOOK = "book";
    private static final String TAG_TITLE = "title";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_YEAR = "year";

    private final String filePath = "src/lr8/Ex3/exampleJson.json";

    public List<Book> parser() {
        String title;
        String author;
        String year;

        JSONArray jsonArray = getJson();
        if (jsonArray != null) {
            for (Object o : jsonArray) {
                JSONObject objectJson = (JSONObject) o;
                title = (String) objectJson.get(TAG_TITLE);
                author = (String) objectJson.get(TAG_AUTHOR);
                year = (String) objectJson.get(TAG_YEAR);
                Book book = new Book(title, author, year);
                books.add(book);
            }


        }
        return books;
    }


    public void addNewBook() {
        JSONArray jsonArray = getJson();
        JSONObject jsonNewBook = new JSONObject();
        System.out.println();
        Book newBook = ParserXml.newBook();
        jsonNewBook.put(TAG_TITLE, newBook.getBookName());
        jsonNewBook.put(TAG_AUTHOR, newBook.getAuthor());
        jsonNewBook.put(TAG_YEAR, newBook.getYear());
        assert jsonArray != null;
        jsonArray.add(jsonNewBook);

        writeDate(jsonArray);

        System.out.println("Новая книга добавлена в Json");
    }

    public void deleteBook() {
        Scanner in = new Scanner(System.in);
        JSONArray jsonArray = getJson();

        System.out.println("Введите название книги которую необходимо удалить:");
        String title = in.nextLine();
        assert jsonArray != null;
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
            JSONObject song = (JSONObject) iterator.next();
            if (title.equals(song.get(TAG_TITLE))) {
                iterator.remove();
                writeDate(jsonArray);
                return;
            }
        }
        System.out.println("Книга не найдена");

    }

    private JSONArray getJson() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            return (JSONArray) jsonObject.get(TAG_BOOK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeDate(JSONArray jsonArray) {
        try {
            FileWriter file = new FileWriter(filePath);
            JSONObject library = new JSONObject();

            library.put(TAG_BOOK, jsonArray);
            file.write(library.toString());
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
