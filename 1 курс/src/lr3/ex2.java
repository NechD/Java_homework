//2. Создать приложение с использованием рекурсии для перевода целого числа, введенного с клавиатуры, в двоичную систему счисления.

package lr3;

import java.util.Scanner;

public class ex2 {

    public static int DesyatToTwice(int m) {
        if (m == 1) {
            return 1;
        }
        return DesyatToTwice(m / 2) * 10 + m % 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int n = in.nextInt();
        System.out.println("Введенное число в двоичной системе: " + DesyatToTwice(n));
    }
}
