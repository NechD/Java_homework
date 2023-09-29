package lr6;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        //Определяем два массива целых чисел arr1 и arr2.
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        int[] commonElements = findCommonElements(arr1, arr2);
        System.out.println(Arrays.toString(commonElements)); // [3, 4, 5]
    }
    //Определяем новый массив ArrayList commonElements, который будет хранить общие элементы двух массивов.
    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        //Перебираем элементы обоих массивов arr1 и arr2 и сравниваем их. Если элементы совпадают, добавляем их в commonElements.
        ArrayList<Integer> commonElements = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    commonElements.add(arr1[i]);
                    break;
                }
            }
        }
        // Конвертируем ArrayList commonElements в массив result и возвращаем его как результат выполнения метода findCommonElements.
        int[] result = new int[commonElements.size()];
        for (int i = 0; i < commonElements.size(); i++) {
            result[i] = commonElements.get(i);
        }
        return result;

    }
}

