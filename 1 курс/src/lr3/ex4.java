//4. Выполнить пример 1 из раздела 2. Отработать код с помощью отладчика и привести скриншоты минимум трех точек, обработанных отладчиком.

package lr3;

//Объявляем класс Node, который имеет два поля: целочисленное значение value и ссылку на следующий узел next.
class Node {
    public int value;
    public Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
public class ex4 {
//    Создаются четыре узла Node с значениями 0, 1, 2 и 3 соответственно, и каждый из них имеет начальное значение next, равное null
    public static void main(String[] args) {
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
//        Устанавливаются ссылки между узлами в порядке 0 -> 1 -> 2 -> 3
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
//        Объявляется узел ref и ему присваивается значение node0.
        Node ref = node0;
//        Запускается цикл while с условием ref != null.
        while (ref != null) {
//            На каждой итерации цикла выводится значение поля value узла ref.
            System.out.println(" " + ref.value);
//            Ссылка ref переходит на следующий узел с помощью значения поля next.
            ref = ref.next;
//            В случае достижения конечного узла (ссылка на следующий узел равна null) цикл завершается.
        }
    }

}
