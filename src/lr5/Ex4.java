package lr5;

public class Ex4 {
    public static void main(String[] args) {
        // Создаем 10 потоков
        for (int i = 1; i <= 10; i++) {
            // Задаем номер потока
            final int threadNumber = i;
            // Создаем новый поток
            Thread thread = new Thread(new Runnable() {
                // Определяем метод run() для потока
                public void run() {
                    // Выводим номер потока на экран
                    System.out.println("Thread " + threadNumber + " is running.");
                }
            });
            // Запускаем поток
            thread.start();
        }
    }
}