package lr3.ex8;

public class ex8 {
    public static void main(String[] args) {
        // создаётся новый узел с помощью метода createHead класса NoteService, который принимает на вход количество узлов в списке.
        Node node = NoteService.headCreate(5);
        //  узел выводится на экран с помощью метода toString класса NoteService.
        System.out.println(NoteService.toString(node));
        //  в созданный список вставляется новый узел, который принимает на вход индекс, по которому нужно вставить новый узел, и сам новый узел.
        node = NoteService.insertNode(3, new Node(345, null), node);
        System.out.println(NoteService.toString(node));
//        в список добавляется новый узел в начало с помощью метода
        node = NoteService.addNodeToBegin(node);
        System.out.println(NoteService.toString(node));
//        с помощью метода removeFirst класса NoteService удаляется первый узел из списка
        node = NoteService.removeFirstNode(node);
        System.out.println(NoteService.toString(node));
//        с помощью метода addLast класса NoteService в конец списка добавляется новый узел
        NoteService.addLast(node);
        System.out.println("-----------------");

//        создаётся новый узел и выводится на экран с помощью метода
        Node node2 = NoteService.headCreate(7);
        System.out.println(NoteService.toString(node2));
//        с помощью метода removeLast класса NoteService удаляется последний узел из списка.
        NoteService.removeLast(node2);
//        с помощью метода remove класса NoteService удаляется узел по его индексу в списке.
        System.out.println(NoteService.toString(node2));
        node2 = NoteService.removeNode(2, node2);
        System.out.println(NoteService.toString(node2));

        System.out.println("-----------------");
//        создаются новые узлы для головы
        Node nodeRec = NoteService.createHeadRec(6);
        assert nodeRec != null;
        System.out.println(NoteService.toStringRec(nodeRec));

        System.out.println("-----------------");
        //        создаются новые узлы для хвоста
        Node nodeRec1 = NoteService.createTailRec(2, null);
        System.out.println(NoteService.toStringRec(nodeRec1));
    }
}
