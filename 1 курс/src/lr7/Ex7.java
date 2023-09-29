package lr7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        System.out.print("Введите текст для записи в файл: ");
        String text = scanner.nextLine();

        try {
            File file = new File(fileName); // создаем объект класса File с указанным именем файла
            FileWriter writer = new FileWriter(file); // создаем объект класса FileWriter для записи в файл
            writer.write(text); // записываем текст в файл
            writer.close(); // закрываем объект FileWriter

            System.out.println("Количество записанных символов: " + text.length()); // выводим количество записанных символов
        } catch (IOException e) { // обрабатываем исключение ввода-вывода
            e.printStackTrace(); // выводим информацию об ошибке
        }
    }
}