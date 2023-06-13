package lr4;
//В программе, где требуется из матрицы вывести столбец с номером, заданным с клавиатуры, могут возникать ошибки в следующих случаях:
//        –	ввод строки вместо числа;
//        –	нет столбца с таким номером.

import java.util.Random;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        array();
        Scanner in = new Scanner(System.in);
        boolean numberColumn;
        System.out.print("Введите номер столбца: ");
        do {
            try {
                numberColumn = false;
                print(in.next());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("столбец с таким номером не существует\n" +
                        "введите корректное значение, меньше "+matrix.length);
                numberColumn = true;
            } catch (NumberFormatException e) {
                System.out.println("вы ввели строку вместо целого числа \n" +
                        "введите корректное значение");
                numberColumn = true;
            }
        } while (numberColumn);
    }

    // Генерируем матрицу размером x*y
    private static final int[][] matrix = new int[10][10];

    // Заполняем матрицу случайными значениями
    private static void array() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextInt(200);
            }
        }
    }

    // Выводим запрошенный столбец в матрице
    private static void print(String incomeColumn) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[Integer.parseInt(incomeColumn) - 1][i] + " ");
        }
    }
}
