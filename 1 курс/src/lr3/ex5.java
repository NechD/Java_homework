//. Заполнить HashMap 10 объектами <Integer, String>.
// Найти строки у которых ключ > 5. Если ключ = 0, вывести строки через запятую.
// Перемножить все ключи, где длина строки>5.


package lr3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class ex5 {
    private static final String ENGLISH_ALPHABITE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    Константы MIN и MAX определяют минимальное и максимальное значение ключа в хэш-таблице
    private static final int MIN = 1;
    private static final int MAX = 20;
    private static final int ELEMENTS_AMOUNT = 10;
//    Метод printStringMod3() выводит значения, где ключ равен 0.
    private static void printStringMod3(Map<Integer, String> map) {
        map.entrySet().stream().filter(e -> e.getKey() == 0).forEach(e -> System.out.print(e.getValue() + ", "));
    }
//    Метод multiplication() возвращает произведение ключей, где значения длиннее 5 символов.
    private static int multiplicationMoreFive(Map<Integer, String> map) {
        return map.entrySet().stream().filter(e -> e.getValue().length() > 5).mapToInt(Map.Entry::getKey).reduce(1, (x, y) -> x * y);
    }

    private static void printMap(Map<Integer, String> map) {
        map.forEach((key, value) -> System.out.println(key + ": " + value + ";"));
    }
//    Метод getMassiveKeyMoreFive() возвращает массив строк, где ключ больше 5.
    private static String[] getMassiveKeyMoreFive(Map<Integer, String> map) {
        return map.entrySet().stream().filter(x -> x.getKey() > 5).map(Map.Entry::getValue).toArray(String[]::new);
    }

//    Метод fillingMap() заполняет хэш-таблицу случайными ключами и значениями, используя метод getRandomString(),
    private static Map<Integer, String> fillMap() {
        Map<Integer, String> map = new HashMap<>();
        Random random = new Random();
        for (int count = 0; count < ELEMENTS_AMOUNT; count++) {
            int key = random.nextInt(MAX - MIN + 1) + MIN;
            map.put(key, getRandomString(key));
        }
        return map;
    }
//    создает случайную строку заданной длины.
    private static String getRandomString(int size) {
        Random random = new Random();
        return IntStream.rangeClosed(1, size).
                mapToObj(i -> String.valueOf(ENGLISH_ALPHABITE.charAt(random.nextInt(ENGLISH_ALPHABITE.length())))).
                reduce("", (x, y) -> x + y);
    }

    public static void main(String[] args) {
        Map<Integer, String> map = fillMap();
        System.out.println("HashMap:");
        printMap(map);
        System.out.println("Значения, где ключ > 5 :" + Arrays.toString(getMassiveKeyMoreFive(map)));
        System.out.print("Values, where key == 0: ");
        printStringMod3(map);
        System.out.println("\nMulti key, where string length > 5: " + multiplicationMoreFive(map));
    }
}
