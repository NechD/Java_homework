package lr6;


import java.util.*;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите список целых чисел через пробел: ");
        String input = scanner.nextLine();
        System.out.print("Введите число, на которое должны делиться элементы списка: ");
        int divisor = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (String s : input.split(" ")) {
            numbers.add(Integer.parseInt(s));
        }
        List<Integer> divisibleNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % divisor == 0) {
                divisibleNumbers.add(number);
            }
        }
        System.out.println("Числа, которые делятся на " + divisor + " без остатка: " + divisibleNumbers);
    }
}
