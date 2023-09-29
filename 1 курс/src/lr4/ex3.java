package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        eSetArray();
        SumArray(StatArray);
    }

    private static byte[] StatArray;

    private static void eSetArray() {
        try {
            createArray();
        } catch (InputMismatchException mismatchException) {
            System.out.println("введите корректное значение (" + mismatchException + ")");
            eSetArray();
        } catch (Exception exception) {
            System.out.println("ошибка (" + exception + ")");
            eSetArray();
        }

    }

    static class ByteRangeException extends InputMismatchException {
        ByteRangeException() {
            super("число за пределами диапазона byte");
        }
    }

    private static void EInput(int i) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("введите byte элемент массива: " + "[" + (i + 1) + "]");
            int summa = 0;
            try {
                summa = scanner.nextInt();
                if (summa < -128 || summa > 127) {
                    throw new ByteRangeException();
                }
            } catch (ByteRangeException e) {
                System.out.println("значение за пределами диапазона byte (" + e + ")");
                EInput(i);
            }
            StatArray[i] = (byte) summa;
        } catch (InputMismatchException mismatchException) {
            System.out.println("введите число (" + mismatchException + ")");
            EInput(i);
        }
    }

    private static void createArray() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int a = scan.nextInt();
        StatArray = new byte[a];
        for (int i = 0; i < a; i++) {
            EInput(i);
        }
    }

    private static void SumArray(byte[] InputArray) {
        int A = 0;
        for (int j : InputArray) {
            A += j;
        }
        System.out.println("сумма элементов массива = [" + (A) + "]");
    }
}
