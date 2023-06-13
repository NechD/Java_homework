package lr5;

import java.time.LocalTime;
import java.util.Date;

public class Ex1 {
    public static void main(String[] args) {
        // Создаем новый объект класса Thread и передаем ему объект Runnable
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        // Создаем второй поток аналогичным образом
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");

        // Запускаем оба потока
        thread1.start();
        thread2.start();

        // Ждем 10 секунд
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Останавливаем оба потока
        thread1.interrupt();
        thread2.interrupt();
    }

    // Класс, реализующий интерфейс Runnable
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // Пока поток не прерван, выводим его имя и текущее время
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " - " + new Date());
                try {
                    // Ждем 1 секунду перед следующей итерацией цикла
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Если поток был прерван, выходим из цикла
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
