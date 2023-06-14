package lr8.Ex2;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ParserXml {
    private static final String TAG_BOOK = "book";
    private static final String TAG_TITLE = "title";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_YEAR = "year";

    public List<Book> parse(){
        Document doc;
        try {
            doc = buildDocument();
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }

        Node libraryNode = doc.getFirstChild();

        return parseBookTag(libraryNode);
    }



    private Document buildDocument() throws Exception{
        File file = new File("src/lr8/Ex2/exampleAddNewBook.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }

    private List<Book> parseBookTag(Node libraryNode){
        List<Book> listBook = new ArrayList<>();
        NodeList bookChilds = libraryNode.getChildNodes();

        for (int i = 0; i < bookChilds.getLength(); i++){
            if (bookChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            Book book = parseElement(bookChilds.item(i));

            listBook.add(book);
        }
        return listBook;
    }

    private Book parseElement(Node elementNode){
        String title = "";
        String author = "";
        String year = "";

        NodeList elementChilds = elementNode.getChildNodes();

        for (int i = 0; i < elementChilds.getLength(); i++){
            if (elementChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            switch (elementChilds.item(i).getNodeName()) {
                case TAG_TITLE -> title = elementChilds.item(i).getTextContent();
                case TAG_AUTHOR -> author = elementChilds.item(i).getTextContent();
                case TAG_YEAR -> year = elementChilds.item(i).getTextContent();
            }
        }
        return new Book(title, author, year);
    }

    public static void printBook(List<Book> books, String parserType){
        System.out.println();
        System.out.println("Список книг в " + parserType + ":");
        for (Book oneBook : books){
            System.out.println();
            System.out.println("Название книги: " + oneBook.getBookName());
            System.out.println("Автор: " + oneBook.getAuthor());
            System.out.println("Год выхода: " + oneBook.getYear());
        }
    }

    public void addNewBookXml() {


        Book newBook = newBook();
        Document doc = null;
        try {
            doc = buildDocument();
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        // Создаем element Book, в который будем передавать ранее записанные параметры новой книги.
        assert doc != null;
        Element bookElement = doc.createElement(TAG_BOOK);

        // Создаем element для каждого свойства, которое необходимо заполнить для книг
        Element titleElement = doc.createElement(TAG_TITLE);
        Element authorElement = doc.createElement(TAG_AUTHOR);
        Element yearElement = doc.createElement(TAG_YEAR);
        titleElement.appendChild(doc.createTextNode(newBook.getBookName()));
        authorElement.appendChild(doc.createTextNode(newBook.getAuthor()));
        yearElement.appendChild(doc.createTextNode(newBook.getYear()));
        bookElement.appendChild(titleElement);
        bookElement.appendChild(authorElement);
        bookElement.appendChild(yearElement);

        // Добавляем ранее созданый и наполненный элемент book в "библиотеку" элементов
        // Получаем основной, "родительский" элемент и добавляем в него элемент Book
        Element libraryElement = doc.getDocumentElement();
        libraryElement.appendChild(bookElement);

        DOMSource source = new DOMSource(doc);

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("src/lr8/Ex2/exampleAddNewBook.xml");
            transformer.transform(source, result);
        } catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Новая книга добавлена");
    }

    public void deleteBook() {
        Scanner in = new Scanner(System.in);
        Document doc = null;
        try {
            doc = buildDocument();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Введите название книги которую необходимо удалить: ");
        String titleDeleteBook = in.nextLine();

        assert doc != null;
        NodeList bookNodes = doc.getElementsByTagName("book");
        for (int i = 0; i < bookNodes.getLength(); i++){
            if (bookNodes.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            Element bookElement = (Element) bookNodes.item(i);
            Element titleElement = (Element) bookElement.getElementsByTagName(TAG_TITLE).item(0);
            String title = titleElement.getTextContent();
            if (title.equals(titleDeleteBook)) {
                // Удаляем книгу с данным элементoм
                bookElement.getParentNode().removeChild(bookElement);

                // Записываем изменения обратно в файл
                try {
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult("src/lr8/Ex2/exampleAddNewBook.xml");
                    transformer.transform(source, result);

                    System.out.println("Книга удалена из XML");
                    return;
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Книга не найдена");
    }


    public static List<Book> findBook(List<Book> books){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название или автора книги");
        String inputString = in.nextLine();

        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books){
            if (book.getBookName().equalsIgnoreCase(inputString) | book.getAuthor().equalsIgnoreCase(inputString)){
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public static Book newBook() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Введите название книги: ");
        String newTitle = in.nextLine();
        System.out.println("Введите автора книги: ");
        String newAuthor = in.nextLine();
        System.out.println("Введите год выхода: ");
        String newYear = in.nextLine();


        return new Book(newTitle, newAuthor, newYear);
    }
}
