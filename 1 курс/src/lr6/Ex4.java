package lr6;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.print("Введите числа через пробел: ");
        String input = scanner.nextLine();
        String[] inputNumbers = input.split(" ");
        for (String str : inputNumbers) {
            numbers.add(Integer.parseInt(str));
        }
        List<Integer> squares = new ArrayList<>();
        for (int number : numbers) {
            squares.add(number * number);
        }
        System.out.println("Квадраты чисел: " + squares);
    }
}

