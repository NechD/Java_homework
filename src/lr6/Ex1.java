package lr6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");

        int size = in.nextInt();
        // Создаем массив и заполняем рандомными числами
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        // Смотрим какие данные в исходном массиве
        System.out.println("Массив arr : ");
        System.out.println(Arrays.toString(array));
        // Создаем новый массив, содержащий только четные числа из исходного массива
        int[] arrResult = filterEvenNumbers(array);
        System.out.println("Массив arrResult :");
        System.out.println(Arrays.toString(arrResult));
    }

    // Функция, которая фильтрует четные числа из массива и возвращает новый массив, содержащий только четные числа
    public static int[] filterEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }
}

