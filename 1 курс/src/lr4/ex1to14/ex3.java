package lr4.ex1to14;

public class ex3 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Ошибка");
        } catch (NullPointerException nullPointerException) {
            System.out.println("1");
        } catch (RuntimeException runtimeException) {
            System.out.println("2");
        } catch (Exception exception) {
            System.out.println("3");
        }
        System.out.println("4");
    }
}
