package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Ex5 {

    public static void main(String[] args) {
        // Создаем массив
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте размер массива: ");
        // Генерируем случайный массив заданного размера
        int[] arr = IntStream.generate(() -> new Random().nextInt(1000000)).limit(in.nextInt()).toArray();
        System.out.println(Arrays.toString(arr));

        // Определяем количество потоков
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество потоков: " + processors);

        // Определяем, по сколько элементов должно быть у каждого потока
        int chunkSize = arr.length / processors;
        System.out.println("Количество элементов на поток: " + chunkSize);

        // Создаем переменную для отслеживания максимального числа
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

        // Создаем потоки
        Thread[] threads = new Thread[processors];

        // Для каждого потока определяем начальный и конечный индекс
        for (int i = 0; i < processors; i++) {
            final int start = i * chunkSize;
            final int end = (i == processors - 1) ? arr.length : (i + 1) * chunkSize;

            // В каждом потоке находим максимальный элемент
            threads[i] = new Thread(() -> {
                int localMax = Arrays.stream(arr, start, end).max().getAsInt();

                // Используем синхронизацию с объектом класса и обновляем максимальное значение, если такое имеется
                synchronized (Ex5.class) {
                    if (localMax > max.get()) {
                        max.set(localMax);
                    }
                }
            });
            threads[i].start();
        }

        // Дожидаемся завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Выводим максимальное значение в массиве
        System.out.println("Максимальное значение в массиве: " + max);
    }
}
