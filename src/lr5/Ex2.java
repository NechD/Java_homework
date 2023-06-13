package lr5;


public class Ex2 extends Thread { // объявление класса MyThread, который наследует класс Thread
    public void run() { // переопределение метода run класса Thread
        for (int i = 1; i <= 10; i++) { // цикл от 1 до 10
            System.out.println(i); // вывод числа на экран
            try {
                Thread.sleep(1000); // задержка на 1 секунду
            } catch (InterruptedException e) { // обработка исключения InterruptedException
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) { // метод main
        Ex2 thread = new Ex2(); // создание объекта потока
        thread.start(); // запуск потока
    }
}