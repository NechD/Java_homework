//В кругу стоят N человек, пронумерованных от 1 до N.
//        При ведении счета по кругу вычеркивается каждый второй человек, пока не останется один.
//        Составить две программы, моделирующие процесс.
//        Одна из программ должна использовать класс ArrayList, а вторая — LinkedList.
//        Какая из двух программ работает быстрее? Почему?

        package lr3;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class ex6 {
//    создается пустой связанный список и заполняется указанным количеством элементов.
    public static void LinkedList(int elements_number) {
        Date currentTime = new Date();
        System.out.println("Метод LinkedList:");
        System.out.println("Количество элементов: " + elements_number + " (от 0 до " + (elements_number - 1) + ")");

        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 0; i < elements_number; i++) circle.add(i); // Заполняем коллекци
        //   в цикле каждый второй элемент списка удаляется до тех пор, пока не останется один элемент.
        int total = 0;
        while (circle.size() > 1) {
            for (int i = 0; i < circle.size(); i++) {
                total++;
                if (total == 2) {
                    circle.remove(i);
                    i--;
                    total = 0;
                }
            }
        }

        System.out.println("Оставшийся элемент: " + circle.get(0));
        Date newTime = new Date();
//        Результат выводится на экран вместе с затраченным на выполнение метода временем.
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Результат в миллисекундах: " + msDelay);
        System.out.println();
    }

    public static void ArrayList(int elements_number) {
        System.out.println("Метод ArrayList:");
        Date currentTime = new Date();

        System.out.println("Количество элементов: " + elements_number + " (от 0 до " + (elements_number - 1) + ")");

        ArrayList<Integer> loop = new ArrayList<>();
        for (int i = 0; i < elements_number; i++) loop.add(i); // Заполняем коллекцию

        int counter = 0;
        while (loop.size() > 1) {
            for (int i = 0; i < loop.size(); i++) {
                counter++;
                if (counter == 2) {
                    loop.remove(i);
                    i--;
                    counter = 0;
                }
            }
        }
        System.out.println("Оставшийся элемент: " + loop.get(0));
        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Результат в миллисекундах: " + msDelay);
    }


    public static void main(String[] args) {
        LinkedList(6666);
        ArrayList(6666);


    }
}
