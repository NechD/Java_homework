package lr8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
public class Ex5 {
    public static void main(String[] args) {
        // Открываем для чтения
        String filePath = "src/lr8/Ex1/example3.xlsx";
        try {
            FileInputStream inputStream = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Лабудада");

            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

            // Закрытие файла
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            // Обработка ошибки ввода-вывода
            System.out.println("Ошибка ввода вывода");
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // Обработка ошибки неверной структуры или содержимого файла Excel
            System.out.println("Проверьте структуру и содержимое файла Excel");
            e.printStackTrace();
        } catch (NullPointerException e) {
            // Обработка ошибки попытки обращения к несуществующему элементу
            System.out.println("Программа пытается обратиться к несуществующему элементу");
        }
    }
}