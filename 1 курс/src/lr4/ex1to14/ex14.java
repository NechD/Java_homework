package lr4.ex1to14;

public class ex14 {
    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
    }

    public static void main(String[] args) {
        try {


            int l = args.length;
            System.out.println("размер массива равен " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("ошибка деления на ноль");
        }
    }
}
