import java.util.Scanner;

public class MoneyChangeAgain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 2) {
            System.out.println(n);
            return;
        } else if (n == 3 || n == 4) {
            System.out.println(1);
            return;
        }else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 1;
            dp[4] = 1;
            for (int i = 5; i <= n; i++) {
                dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 3], dp[i - 4])) + 1;
            }
            System.out.println(dp[n]);
        }
    }
}
