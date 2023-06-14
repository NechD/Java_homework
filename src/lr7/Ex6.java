package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла:");
        String fileName = in.nextLine();
        System.out.println("Введите слово для поиска:");
        String word = in.nextLine();
        BufferedReader reader = null;
        try {
            // Создаем объект класса BufferedReader для чтения файла
            reader = new BufferedReader(new FileReader(fileName));
            // Считываем первую строку из файла
            String line = reader.readLine();
            // Счетчик найденных совпадений
            int count = 0;
            // Цикл по строкам файла
            while (line != null) {
                // Проверяем, содержит ли строка искомое слово
                if (line.contains(word)) {
                    System.out.println(line);
                    // Увеличиваем счетчик найденных совпадений
                    count++;
                }
                // Считываем следующую строку из файла
                line = reader.readLine();
            }
            System.out.println("В файле " + fileName + " найдено " + count + " совпадений");
            // Обработка исключения в случае ошибки чтения файла
        } catch (IOException e) {
            System.out.println("Ошибка при чтении: " + e.getMessage());
            // Блок finally для закрытия потока чтения файла
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
