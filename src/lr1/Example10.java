//5. Напишите программу, в которой по году рождения определяется возраст пользователя.

package lr1;

import java.util.Scanner;
import java.time.LocalDate;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDate current_date = LocalDate.now();
        System.out.println("Введите свой год рождения");
        int birth_year = in.nextInt();
        System.out.printf("Вам %d лет.", current_date.getYear() - birth_year);

    }
}
