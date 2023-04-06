//8.	Напишите программу для вычисления суммы двух чисел.
// Оба числа вводятся пользователем.
// Для вычисления суммы используйте оператор +

package lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число");
        int first_number = in.nextInt();
        System.out.println("Введите второе число");
        int second_number = in.nextInt();

        System.out.printf("%d + %d = %d", first_number, second_number, first_number + second_number);

    }
}