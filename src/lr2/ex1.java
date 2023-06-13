//Задание:
//        1.	Напишите программу, в которой создается массив и заполняется случайными числами.
//        Массив отображается в консольном окне. В этом массиве необходимо определить элемент с минимальным значением.
//        В частности, программа должна вывести значение элемента с минимальным значением и индекс этого элемента.
//        Если элементов с минимальным значением несколько, должны быть выведены индексы всех этих элементов.

package lr2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class ex1 {
    public static void main(String[] args) {
        System.out.println("Укажите размер пассива");
        Scanner vhod = new Scanner(System.in);
        int size = vhod.nextInt();
        System.out.println("Размер массива равен " + size);
        int[] mass = new int[size];
        // создаем экземпляр класса Random
        Random random = new Random();
//В цикле у экземпляра Random вызываем метод nextInt, генерирующий случайнео число
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(200);
        }
//Выводим массив  вконсоль
        System.out.println(Arrays.toString(mass));
//Ищем минимальное число. Сначала считаем, что наим - первый элемент массива,
// проходимся по всем массиву, если находим число меньше - меняем наим. элемент на найденный
        int minimal_number = mass[0];
        for (int num : mass) {
            if (num < minimal_number) {
                minimal_number = num;
            }
        }
//У нас есть минимальное число в переменной minimal_number. Проходимся по массиву, если число равно минимальному, выводим индекс
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == minimal_number) {
                System.out.printf("Минимально число %d с индексом [" + i + "]%n", mass[i]);
            }
        }
    }
}