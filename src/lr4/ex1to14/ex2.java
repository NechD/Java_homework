package lr4.ex1to14;

public class ex2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");

        } catch (Exception exception) {
            System.out.println("1");
            System.out.println("2 " + exception);
        }
        System.out.println("3");
    }
}
