import java.util.Scanner;

public class PrimitiveCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        int[] op = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            int min = 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                min = 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                min = 3;
            }
            op[i] = min;
        }
        System.out.println(dp[n]);
        int[] res = new int[dp[n] + 1];
        res[dp[n]] = n;
        int id= dp[n] - 1;
        while(n>1){
            if(op[n]==1){
                n--;
            }else if(op[n]==2){
                n/=2;
            }else{
                n/=3;
            }
            res[id] = n;
            id--;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
