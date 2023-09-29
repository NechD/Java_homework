package lr6;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>(); // создание списка целых чисел
        Random random = new Random(); // создание объекта класса Random для генерации случайных чисел
        System.out.println("Список целых чисел: " + "\n");
        for (int i = 0; i < 10; i++) { // заполнение списка случайными числами
            integers.add(random.nextInt(1000)); // добавление случайного числа в список
            System.out.print(integers.get(i) + " "); // вывод числа на консоль
        }
        System.out.print("\n" + "Введите число больше которого должны быть полученные числа: ");
        int count = in.nextInt(); // получение числа от пользователя

        List<Integer> integersAfter = filterByLength(integers, count); // фильтрация списка чисел
        System.out.println("Полученные значения : ");
        for (Integer i : integersAfter) { // вывод отфильтрованных чисел на консоль
            System.out.print(i + " ");
        }
    }

    public static List<Integer> filterByLength(List<Integer> integers, int count) {
        return integers.stream() // конвертация списка в поток
                .filter(number -> number > count) // фильтрация чисел, которые больше заданного числа
                .collect(Collectors.toList()); // конвертация потока обратно в список
    }
}

