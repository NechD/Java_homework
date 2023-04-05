//2. Напишите программу, в которой Пользователь вводит имя и возраст.
//        Программа отображает сообщение об имени и возрасте пользователя.

package lr1;

import java.util.Scanner;
public class Example7 {
    public static void main(String[] args) {

        System.out.println("Введите свое имя");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("А теперь возраст");
        int age = in.nextInt();

        System.out.printf("Твое имя %s и тебе %d лет(год).",name,age);
    }
}