package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        try {
            avgMoreZero();
        } catch (NullPointerException e) {
            System.out.println("Нет элементов больше 0");
        } catch (InputMismatchException e) {
            System.out.println("введенный числовой тип данных не соответствует");
        } catch (NumberFormatException e) {
            System.out.println("Вместо числа введена строка");
        }
    }

    private static final int[] arr = new int[10];

    //вводятся 10 чисел, проверяется, являются ли они числами типа int и сохраняются в массив arr.
    private static void avgMoreZero() throws NullPointerException {
        int b = 0;
        int count = 0;
        int inputNumber;
        Scanner in = new Scanner(System.in);
        System.out.println("Напишите 10 чисел для расчета:");
        for (int i = 0; i < arr.length; i++) {
            inputNumber = Integer.parseInt(in.next());
            if (inputNumber >= 2147483647 || inputNumber <= -2147483648) {
                throw new InputMismatchException();
            }
            arr[i] = inputNumber;
        }
        // поиск положительных чисел и вычисляется их среднее значение.
        for (int anInt : arr) {
            if (anInt >= 0) {
                b += anInt;
                count++;
            }
        }
        // Если в массиве нет положительных чисел, выбрасывается исключение
        if (count == 0) {
            throw new NullPointerException();
        }
        System.out.print("Среднее значение положительных элементов: " + b / count);
    }
}
