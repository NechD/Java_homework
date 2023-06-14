package lr8.Ex3;

import java.util.Scanner;
import lr8.Ex2.ParserXml;
public class BookSearchAddDelete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ParserJson ParserJson = new ParserJson();
        System.out.println();
        System.out.println("Основное меню (Парсер JSON): ");
        System.out.println("Нажмите '1' что бы вывести список книг");
        System.out.println("Нажмите '2' что бы добавить новую книгу");
        System.out.println("Нажмите '3' что бы найти книгу по названию или автору книги");
        System.out.println("Нажмите '4' что бы удалить книгу по названию");
        System.out.println("Нажмите '5' что бы закрыть программу");
        System.out.print("Выбрано: ");

        int choiceOption = in.nextInt();
        in.nextLine();

        switch (choiceOption) {
            case 1 -> ParserXml.printBook(ParserJson.parser(), "JSON");
            case 2 -> ParserJson.addNewBook();
            case 3 -> ParserXml.printBook(ParserXml.findBook(ParserJson.parser()), "JSON c указанным названием");
            case 4 -> ParserJson.deleteBook();
            case 5 -> System.exit(0);
        }
    }
}
