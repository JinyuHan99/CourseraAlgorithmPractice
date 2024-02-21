import java.util.Arrays;
import java.util.Scanner;

public class MaximumAmountOfGold {
    static int optimalWeight(int W, int[] w) {
        int[][] value = new int[w.length + 1][W + 1];
        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    value[i][j] = 0;
                } else {
                    value[i][j] = value[i - 1][j];
                    if (j - w[i-1] >=0) {
                        value[i][j] = Math.max(value[i][j], value[i - 1][j - w[i-1]] + w[i-1]);
                    }
                }
            }
        }
        return value[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
