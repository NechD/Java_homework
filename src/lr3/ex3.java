//3. Создать приложение, позволяющее ввести и вывести одномерный массив целых чисел.
// Для ввода и вывода массива разработать рекурсивные методы вместо циклов for.
package lr3;

import java.util.Scanner;

public class ex3 {
    // метод вввода значений в массив (рекурсивный)
    public static int[] arrayy = new int[10];
    static Scanner in = new Scanner(System.in);
    public static int c = 0;

    public static int[] Massive(int n) {
        if (c == n) return arrayy;
        else {
            System.out.print("Напишите " + (c + 1) + " элемент массива: ");
            arrayy[c++] = in.nextInt();
        }
        return Massive(n);
    }

    //  метод вывода значений из массива (рекурсивный)
    public static void PrintArray(int[] myArray, int i) {
        if (i < myArray.length) {
            System.out.print(myArray[i] + " ");
            PrintArray(myArray, i + 1);
        }
    }

    public static void main(String[] args) {
        // заполняем массив
        int[] out = Massive(10);
        // выводим массив
        PrintArray(out, 0);
    }

}
