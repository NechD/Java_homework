package lr7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex4 {
    public static void main(String[] args) throws IOException {
        // Создаем объект FileReader для чтения файла input.txt
        FileReader reader = new FileReader("src/lr7/Ex1/input.txt");
        // Создаем объект FileWriter для записи в файл output.txt
        FileWriter writer = new FileWriter("src/lr7/Ex1/output.txt");
        int copier;
        // Читаем файл input.txt и записываем его в файл
        while ((copier = reader.read()) !=-1){
            writer.write(copier);
        }
        reader.close();
        writer.close();
        System.out.println("Файл скопирован успешно!");
    }
}
