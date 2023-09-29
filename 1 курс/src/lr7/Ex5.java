package lr7;

import java.io.*;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) throws IOException {
        // считываем название файла
        Scanner in = new Scanner(System.in);
        System.out.println("Введите путь к файлу или " +
                "название файла если он находится в директории проекта:");
        String fileName = in.nextLine();
        // создаем переменную и подгружаем в нее файл, затем смотрим его размер
        File file = new File(fileName);
        long fileSizeInBytes = file.length();
        System.out.println("Размер файла: " + fileSizeInBytes + " байт");
    }
}
