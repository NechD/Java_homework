//10.	Напишите программу, в которой Пользователь вводит два числа,
// а программой вычисляется и отображается сумма и разность этих чисел.

package lr1;

import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число");
        int first_number = in.nextInt();
        System.out.println("Введите второе число");
        int second_number = in.nextInt();

        System.out.printf("Сумма first_number и second_number: %d;" +
                "%nРазность first_number и second_number: %d.", first_number + second_number, first_number - second_number);

    }
}