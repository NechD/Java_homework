package lr8.Ex2;
import java.util.Scanner;
public class BookSearchAddDelete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ParserXml parserXml = new ParserXml();
        System.out.println();
        System.out.println("Основное меню (Парсинг XML): ");
        System.out.println("Нажмите '1' что бы вывести список книг");
        System.out.println("Нажмите '2' что бы добавить новую книгу");
        System.out.println("Нажмите '3' что бы найти книгу по названию или году выхода");
        System.out.println("Нажмите '4' что бы удалить книгу по названию");
        System.out.println("Нажмите '5' что бы закрыть программу");
        System.out.print("Выбранно: ");

        int choiceOption = in.nextInt();
        in.nextLine();

        switch (choiceOption) {
            case 1 -> ParserXml.printBook(parserXml.parse(), "XML");
            case 2 -> parserXml.addNewBookXml();
            case 3 -> ParserXml.printBook(ParserXml.findBook(parserXml.parse()), "XML с указанным исполнителем");
            case 4 -> parserXml.deleteBook();
            case 5 -> System.exit(0);
        }
    }
}
