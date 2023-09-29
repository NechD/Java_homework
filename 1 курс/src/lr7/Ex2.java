package lr7;

import java.io.*;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fileName = "example_file.txt";
        System.out.println("Введите текст который хотите сохранить в файл: "); // Приглашение пользователя ввести текст

        String data = in.nextLine(); // Чтение текста, введенного пользователем
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) { // Создание объекта BufferedWriter для записи в файл
            writer.write(data); // Запись текста в файл
            System.out.println("Данные записаны в файл: " + fileName); // Вывод сообщения об успешной записи в файл
        } catch (IOException e) { // Обработка исключения, если произошла ошибка при записи в файл
            System.out.println("Ошибка при записи в файл: " + e.getMessage()); // Вывод сообщения об ошибке
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // Создание объекта BufferedReader для чтения из файла
            char[] buffer = new char[1024]; // Создание буфера для чтения данных из файла
            int charRead = reader.read(buffer); // Чтение данных из файла в буфер
            String readData = new String(buffer, 0, charRead); // Создание строки из прочитанных данных
            System.out.println("Прочитанные данные: " + readData); // Вывод прочитанных данных
        } catch (IOException e) { // Обработка исключения, если произошла ошибка при чтении из файла
            System.out.println("Ошибка при чтение файла: " + e.getMessage()); // Вывод сообщения об ошибке
        }
    }
}