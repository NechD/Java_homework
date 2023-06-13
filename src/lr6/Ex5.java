package lr6;


import java.util.List;
import java.util.stream.Collectors;

public class Ex5 {
    public static void main(String[] args) {
        // задаем строку
        String string = "Напишите функцию, которая строки принимает на вход, список" +
                " строк и возвращает новый список, содержащий только " +
                "те строки, которые содержат заданную подстроку.";
        // делим строку на части, разделитем является запятая и выводим полученый сплит
        List<String> strings = List.of(string.split(","));
        System.out.println("Строка до: ");
        for (String i : strings) {
            System.out.println(i + " ");
        }
        // Выводим полученые строки в которых имеются заданые подстроки
        System.out.println("Строки после: ");
        List<String> stringsAfter = filterStrings(strings, "принимает");
        for (String i : stringsAfter) {
            System.out.println(i + " ");
        }
    }

    public static List<String> filterStrings(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
