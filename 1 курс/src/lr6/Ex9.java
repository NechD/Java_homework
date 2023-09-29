package lr6;


import java.util.List;
import java.util.ArrayList;


public class Ex9 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("abc123");
        strings.add("def");
        strings.add("gh&j");
        strings.add("klm");

        List<String> filteredStrings = filterStrings(strings);

        System.out.println(filteredStrings);
    }

    public static List<String> filterStrings(List<String> strings) {
        List<String> filteredStrings = new ArrayList<>();

        for (String s : strings) {
            if (s.matches("[a-zA-Z]+")) {
                filteredStrings.add(s);
            }
        }

        return filteredStrings;
    }
}