package lr5;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex6 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = sumArray(arr);
        System.out.println("Sum of array elements is: " + sum);
    }

    public static int sumArray(int[] arr) {
        // получаем количество процессоров
        int processors = Runtime.getRuntime().availableProcessors();
        // создаем пул потоков с количеством потоков равным количеству процессоров
        ExecutorService executor = Executors.newFixedThreadPool(processors);
        // делим массив на части
        int chunkSize = arr.length / processors;

        // создаем массив для хранения результатов
        int[] results = new int[processors];
        for (int i = 0; i < processors; i++) {
            // вычисляем начальный и конечный индексы для текущей части массива
            int startIndex = i * chunkSize;
            int endIndex = (i == processors - 1) ? arr.length : (i + 1) * chunkSize;
            // запускаем задачу на выполнение в отдельном потоке
            executor.execute(new SumTask(arr, startIndex, endIndex, results, i));
        }

        // завершаем работу пула потоков и ждем, пока все потоки завершат свою работу
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // суммируем все результаты и возвращаем общую сумму
        return Arrays.stream(results).sum();
    }

    // задача для суммирования элементов массива
    private static class SumTask implements Runnable {
        private final int[] arr;
        private final int startIndex;
        private final int endIndex;
        private final int[] results;
        private final int resultIndex;

        public SumTask(int[] arr, int startIndex, int endIndex, int[] results, int resultIndex) {
            this.arr = arr;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.results = results;
            this.resultIndex = resultIndex;
        }

        // метод для выполнения задачи
        public void run() {
            int sum = 0;
            // суммируем элементы массива в заданном диапазоне
            for (int i = startIndex; i < endIndex; i++) {
                sum += arr[i];
            }
            // сохраняем результат в массив результатов
            results[resultIndex] = sum;
        }
    }
}
