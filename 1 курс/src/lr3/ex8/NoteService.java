package lr3.ex8;

public class NoteService {

//    создает голову списка
    public static Node headCreate(int num) {
        Node node = new Node(0, null);
        Node head = node;
        for (int i = 0; i < num - 1; i++) {
            node.setNext(new Node(i + 1, null));
            node = node.getNext();
        }
        return head;
    }
//    преобразует список в строку для вывода на экран.
    public static String toString(Node head) {
        StringBuilder string = new StringBuilder();
        while (head != null) {
            string.append(head.getValue()).append(" ");
            head = head.getNext();
        }
        return string.toString();
    }
//    добавляет новый элемент в начало списка.
    public static Node addNodeToBegin(Node head) {
        return new Node(head.getValue() - 1, head);
    }
//    добавляет новый элемент в конец списка.
    public static void addLast(Node node) {
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new Node(node.getValue() + 1, null));
    }
//    вставляет новый элемент в список на заданную позицию.
    public static Node insertNode(int index, Node node, Node head) {
        int indexMethod = 0;
        Node buffer = head;
        Node headReturn = head;
        while (true) {
            if (index == indexMethod && indexMethod != 0) {
                node.setNext(head);
                buffer.setNext(node);
            } else if (index == indexMethod) {
                node.setNext(head);
                return node;
            }
            indexMethod++;
            buffer = head;
            if (head.getNext() == null) {
                break;
            }
            head = head.getNext();
        }
        return headReturn;
    }
//    удаляет первый элемент из списка.
    public static Node removeFirstNode(Node node) {
        return node.getNext();
    }
//    удаляет последний элемент из списка.
    public static void removeLast(Node node) {
        while (node.getNext() != null) {
            node = node.getNext();
            if (node.getNext().getNext() == null) {
                node.setNext(null);
            }
        }
    }
//    удаляет элемент по указанной позиции в списке
    public static Node removeNode(int index, Node node) {
        int indexMethod = 0;
        Node returnNode = node;
        Node buffer = node;
        while (true) {
            if (index == indexMethod && indexMethod != 0) {
                buffer.setNext(node.getNext());
            } else if (index == indexMethod) {
                return node.getNext();
            }
            indexMethod++;
            buffer = node;
            if (node.getNext() == null) {
                break;
            }
            node = node.getNext();
        }
        return returnNode;
    }
//    следующие 2 метода создают связанный список рекурсивно
    public static Node createHeadRec(int num) {
        if (num == 0) {
            return null;
        }
        return new Node(num - 1, createHeadRec(num - 1));
    }

    public static Node createTailRec(int num, Node node) {
        Node node1 = new Node(num - 1, node);
        if (num == 0) {
            return node;
        }
        return createTailRec(num - 1, node1);
    }
//    преобразует связанный список в строку рекурсивно для вывода на экран.
    public static String toStringRec(Node head) {
        if (head.getNext() == null) {
            return "";
        }
        return head.getValue() + " " + toStringRec(head.getNext());
    }
}
