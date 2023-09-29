package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {
    public static void main(String[] args) throws IOException {
        // Создание объекта BufferedReader для чтения файла
        BufferedReader reader = new BufferedReader(new FileReader("src/lr7/Ex1/input.txt"));

        // Инициализация счетчика строк
        int lineCount = 0;

        // Чтение файла построчно, пока не достигнут конец файла
        while (reader.readLine() != null) {
            lineCount++;
        }

        // Закрытие потока чтения
        reader.close();

        // Вывод количества строк в файле
        System.out.println("Количество строк в файле: " + lineCount);
    }
}
