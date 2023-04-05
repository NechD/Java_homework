package lr1;

import java.util.Scanner;
public class Example9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите название текущего месяца");
        String month = in.nextLine();

        System.out.println("Введите количество дней в названном ранее месяце");
        int number_day = in.nextInt();

        System.out.printf("В %sе %d дней", month, number_day);
    }
}
