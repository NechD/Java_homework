package lr5;

public class Ex3 {
    public static void main(String[] args) {
        // Создаем два потока
        Thread evenThread = new Thread(new EvenNumbers());
        Thread oddThread = new Thread(new OddNumbers());

        // Запускаем потоки
        evenThread.start();
        oddThread.start();
    }
}

// Класс EvenNumbers реализует интерфейс Runnable,
// который позволяет создать поток
class EvenNumbers implements Runnable {
    public void run() {
        // Выводим четные числа от 2 до 10
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
        }
    }
}

// Класс OddNumbers также реализует интерфейс Runnable
class OddNumbers implements Runnable {
    public void run() {
        // Выводим нечетные числа от 1 до 9
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(i);
        }
    }
}