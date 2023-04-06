//9.Напишите программу, в которой пользователь вводит число, а программой отображается последовательность из четырех чисел:
// число, на единицу меньше введённого, введенное число и число, на единицу больше введенного.
// Четвертое число должно быть квадратом суммы первых трех чисел.
package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите целое число");
        int number = in.nextInt();

        System.out.printf(
                " %nЧисло на 1 меньше: %d;" +
                        " %nВведенное число: %d;" +
                        " %nЧисло на 1 больше: %d;" +
                        " %nКвадрат введенного числа: %d.", number - 1, number, number + 1, number * number);
    }
}