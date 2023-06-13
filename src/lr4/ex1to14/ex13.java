package lr4.ex1to14;

public class ex13 {
    public static void main(String[] args) {
        try {
            int argsLength = args.length;
            System.out.println("размер массива " + argsLength);
            int h = 10 / argsLength;
            args[argsLength + 1] = "10";
        } catch (ArithmeticException e) {
            System.out.println(" деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("индекс не сушествует");
        }
    }
}
