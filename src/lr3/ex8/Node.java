package lr3.ex8;

public class Node {
    private final int value;
    private Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
// значение
    public int getValue() {
        return value;
    }

    // следующая нода
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
