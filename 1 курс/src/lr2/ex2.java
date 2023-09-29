//2.	Напишите программу, в которой создается двумерный числовой массив и этот массив заполняется «змейкой»:
//        сначала первая строка (слева направо),
//        затем последний столбец (сверху вниз),
//        вторая строка (справа налево) и так далее, как показано на рисунке
package lr2;
import java.util.Arrays;
import java.util.Scanner;
public class ex2  {
    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.print("введите количество строк массива: ");
        int rows = id.nextInt();
        System.out.print("введите количество столбцов массива: ");
        int columns = id.nextInt();
        // Создаем двумерный массив
        int[][] arr = new int[rows][columns];
        // Итерируемся по всем элементам массива поочередно
        for(int n = 0; n < rows*columns; n++) {
            // Тут мы определяем, на какой строке по счету находимся, т.к. тип переменной int, если целое от деление <1 - 0 строка, <2 - 1 строка
            int i = n / columns;
            // Тут используется тернарный оператор, если строка четная -> заполняем в порядке возрастания, как положено. Если нечетная - в обратном от максимального номера колонки
            int j = i % 2 == 0 ? n % columns : columns - 1 - n % columns;
            arr[i][j] = n;
        }

        System.out.println(Arrays.deepToString(arr).replace("], ", "]\n"));
    }
}

