//6.	Напишите программу, в которой Пользователь вводит имя и год рождения,
// в программа отображает сообщение содержащее имя пользователя и его возраст.
package lr1;

import java.util.Scanner;
import java.time.LocalDate;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDate current_date = LocalDate.now();
        System.out.println("Введите имя");
        String name = in.nextLine();
        System.out.println("Введите рождения");
        int birth_year = in.nextInt();

        System.out.printf("Вас зовут %s и вам %d лет!", name, current_date.getYear() - birth_year);

    }
}