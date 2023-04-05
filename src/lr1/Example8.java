package lr1;
//3. Напишите программу, в которой Пользователь последовательно вводит название текущего дня недели, название месяца и дату (номер дня в месяце).
//        Программа выводит сообщение о сегодняшней дате (день недели, дата, месяц).
import java.util.Scanner;
public class Example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите название текущего дня недели ");
        String name_day = in.nextLine();
        System.out.println("Введите название текущего месяца");
        String name_month = in.nextLine();
        System.out.println("Введите номер дня в месяце");
        int day = in.nextInt();

        System.out.printf("%s %d %s", name_day, day, name_month);
    }
}
