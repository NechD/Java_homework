package lr6;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // создаем объект класса Scanner для считывания пользовательского ввода
        List<Integer> integers = new ArrayList<>(); // создаем список целых чисел
        Random random = new Random(); // создаем объект класса Random для генерации случайных чисел
        System.out.println("Список целых чисел: ");
        for (int i = 0; i < 10; i++) { // заполняем список случайными числами
            integers.add(random.nextInt(1000));
            System.out.print(integers.get(i) + " "); // выводим элементы списка
        }
        System.out.print("\n" + "Введите число больше которого должны быть полученые числа: ");
        int count = in.nextInt(); // считываем число, больше которого должны быть полученные числа

        List<Integer> integersAfter = filterByLength(integers, count); // вызываем метод filterByLength для фильтрации списка
        System.out.println("Полученые значения : ");
        for (Integer i : integersAfter) { // выводим отфильтрованные числа
            System.out.print(i + " ");
        }
    }

    public static List<Integer> filterByLength(List<Integer> integers, int count) { // метод для фильтрации списка целых чисел
        return integers.stream()
                .filter(number -> number < count) // фильтруем числа, которые меньше заданного числа
                .collect(Collectors.toList()); // возвращаем отфильтрованный список
    }
}
