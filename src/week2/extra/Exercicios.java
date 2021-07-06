package week2.extra;

public class Exercicios {
    public static void main(String[] args) {
        // Extra 1.) Dado um array de números inteiros com valores negativos e
        // positivos, encontre o número mais próximo de zero.
        // Se houver valores como 2 e -2, considere o número positivo.

        int[] array = new int[]{-8, -7, -6, -5, -4, -3, -2, -1, 1, 3, 4, 5, 6, 7, 8, 9};
        int closest = array[0];
        for (int num : array) {
            if (Math.abs(num) < Math.abs(closest)) {
                closest = num;
            } else if (Math.abs(num) == Math.abs(closest) && closest < 0) {
                closest = num;
            }
        }
        System.out.printf("Número mais próximo de zero: %d", closest);

    }
}
