package lr4.ex1to14;

public class ex1 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException exception) {
            System.out.println("1 " + exception);
        }
        System.out.println("2");
    }

}
