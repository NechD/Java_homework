package lr8.Ex1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;


public class ReadExcelFileExample {
    public static void main(String[] args) throws IOException {
        // Открываем файл для чтения
        String filePath = "src/lr8/ex1/example3.xlsx";

        FileInputStream inputStream = new FileInputStream(filePath);

        // Создаем экземпляр книги Excel из файла
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        // Получаем лист из книги из его имени
        XSSFSheet sheet = workbook.getSheet("Товары");

        // Перебераем строки и ячейки листа
        for (Row row : sheet) {
            for (Cell cell : row) {
                // Выводим значения ячейки на экран
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }

        // Закрываем файл и освобождаем ресурсы
        workbook.close();
        inputStream.close();
    }
}
