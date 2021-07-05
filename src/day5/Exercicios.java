package day5;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Arrays;


public class Exercicios {
    public static void exercicio1() {
        // 1. Dado um array com 20 números, imprima seus valores de trás para frente.
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }

    public static void exercicio2() {
        int[] numbers = {11, 25, 12, 22, 64};
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            int min_id = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[min_id]) {
                    min_id = j;
                }
            }
            int temp = numbers[min_id];
            numbers[min_id] = numbers[i];
            numbers[i] = temp;
        }

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.printf("%d", numbers[i]);
            } else {
                System.out.printf("%d, ", numbers[i]);
            }
        }
        System.out.print("]");
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {-3, 4, 5, -7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
