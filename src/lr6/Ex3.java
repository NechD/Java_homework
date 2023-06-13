package lr6;


import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;


public class Ex3 {

    // Главный метод программы
    public static void main(String[] args) {
        // Создаем список строк и заполняем его значениями
        List<String> strings = Arrays.asList("Apple", "banana", "Cherry", "date");
        // Вызываем метод filterUpperCase для фильтрации строк, начинающихся с заглавной буквы
        List<String> uppercaseStrings = filterUpperCase(strings);
        // Выводим отфильтрованные строки в консоль
        System.out.println(uppercaseStrings);
    }

    // Метод для фильтрации строк, начинающихся с заглавной буквы
    public static List<String> filterUpperCase(List<String> strings) {
        // Создаем новый список для хранения отфильтрованных строк
        List<String> result = new ArrayList<>();
        // Проходим по каждой строке из переданного списка
        for (String s : strings) {
            // Если первый символ строки является заглавной буквой, то добавляем ее в список отфильтрованных строк
            if (Character.isUpperCase(s.charAt(0))) {
                result.add(s);
            }
        }
        // Возвращаем список отфильтрованных строк
        return result;
    }
}
