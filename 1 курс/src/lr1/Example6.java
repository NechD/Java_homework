//1. Напишите программу, в которой Пользователь вводит сначала фамилию, затем имя, затем отчество.
//        После ввода программа выводит сообщение «Hello <фамилия, имя, отчество>».
package lr1;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя");
        String first_name = in.nextLine();

        System.out.println("Введите фамилию");
        String last_name = in.nextLine();

        System.out.println("Введите отчество:");
        String father_name = in.nextLine();

        System.out.println("Hello " + last_name + ", " + first_name + ", " + father_name);
    }
}
