package lr3;

public class ex1 {

    //  пример 1
    public static void m(int b) {
        System.out.println("b=" + b);
        if ((2 * b + 1) < 20) {
            m(2 * b + 1);
        }
    }

    //  пример 2
    public static void n(int y) {
        if ((2 * y + 1) < 20) {
            n(2 * y + 1);
        }
        System.out.println("y=" + y);
    }

    //  Пример 3
    private static int shag = 0;

    public static void p(int k) {
        space();
        System.out.println(" " + k + "->");
        shag++;
        if ((2 * k + 1) < 20) {
            p(2 * k + 1);
        }
        shag--;
        space();
        System.out.println(" " + k + "<-");
    }

    public static void space() {
        for (int i = 0; i < shag; i++) {
            System.out.print(" ");
        }
    }

    //  Пример 4
    public static int fact(int m) {
        int result;
        if (m == 1) return 1;
        else {
            result = fact(m - 1) * m;
            return result;
        }
    }

    //    пример 5
    public static int chisla_fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return chisla_fibonacci(n - 2) + chisla_fibonacci(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Пример 1");
        m(1);
        System.out.println("Пример 2");
        n(1);
        System.out.println("Пример 3");
        p(1);
        System.out.println("Пример 4");
        System.out.println(fact(5));
        System.out.println("Пример 5");
        System.out.println(chisla_fibonacci(7));

    }
}
