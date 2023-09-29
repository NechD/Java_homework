package lr6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите минимальную длину строки: ");
        int minLength = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("world");
        strings.add("Java");
        strings.add("is");
        strings.add("awesome");
        List<String> filteredStrings = filterStrings(strings, minLength);
        System.out.println(filteredStrings);
    }

    public static List<String> filterStrings(List<String> strings, int minLength) {
        List<String> filteredStrings = new ArrayList<>();
        for (String str : strings) {
            if (str.length() > minLength) {
                filteredStrings.add(str);
            }
        }
        return filteredStrings;
    }
}
