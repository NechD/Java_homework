package timus.task1001;
import java.util.Scanner;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    // Объявляем метод main
    public static void main(String[] str) throws Exception {
        // Создаем экземпляр класса Scanner для чтения ввода от пользователя
        Scanner scanner = new Scanner(System.in);

        // Создаем экземпляр класса Deque для хранения введенных значений, поддерживает вставку с обоих концов
        Deque<Long> deque = new LinkedList<>();

        // Читаем ввод пользователя, добавляем введенные значения в начало списка
        while (scanner.hasNextLong())
            deque.addFirst(scanner.nextLong());

        // Проходимся по всем значениям в списке и используя метод printf, выводим корень квадратный от значения
        for (Long l : deque)
            System.out.printf("%.4f\n", Math.sqrt(l));

    }
}