import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciNumberAgainNaive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(fibonacciFast(n).mod(BigInteger.valueOf(m)));

    }

    public static BigInteger fibonacciFast(long n){
        if (n<=1){
            return BigInteger.valueOf(n);
        }else {
            int num = 2;
            BigInteger x0 = new BigInteger("0");
            BigInteger x1 = new BigInteger("1");
            BigInteger sum = new BigInteger("0");

            while (num <= n) {
                sum = x0.add(x1);
                x0 = x1;
                x1 = sum;
                num++;
            }
            return sum;

        }
    }

}
