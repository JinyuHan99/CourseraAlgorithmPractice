import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //System.out.println(fibonacciNaive(n));
        System.out.println(fibonacciFast(n));

    }
    public static int fibonacciNaive(int n){
        if (n<=1){
            return n;
        }else {
            return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
        }
    }

    public static int fibonacciFast(int n){
        if (n<=1){
            return n;
        }else {
            int x0 = 0;
            int x1 = 1;
            int sum = 0;
            for(int i = 2; i<=n;i++){
                sum = x0 + x1;
                x0 = x1;
                x1 = sum;
            }
            return sum;
        }
    }

    public static int fibonacciMatrix(int n){
        if (n<=1){
            return n;
        }else {
            int[][] a = new int[2][2];
            int[][] b = new int[1][2];
            a[0][0] = 1;
            a[0][1] = 1;
            a[1][0] = 1;
            a[1][1] = 0;
            b[0][0] = 1;
            b[0][1] = 0;
            return 0;

            //Matrix包似乎没有自带的，这个问题先放一放
        }
    }
}
