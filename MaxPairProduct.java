import java.util.*;
import java.io.*;

public class MaxPairProduct {


    static long getMaxPairwiseProduct(long[] numbers) {
        long product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max(product,
                        numbers[i] * numbers[j]);
            }
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }


}


