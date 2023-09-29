//7.	Напишите программу, в которой по возрасту определяется год рождения.

package lr1;

import java.util.Scanner;
import java.time.LocalDate;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDate dt = LocalDate.now();
        System.out.println("Введите ваш возраст");

        int age = in.nextInt();

        System.out.printf("Вы  родились в %d году", dt.getYear() - age);
    }
}