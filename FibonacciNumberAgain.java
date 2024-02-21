import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciNumberAgain {
    static ArrayList<Integer> modArr = new ArrayList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();

        System.out.println(getMod(n, m));

    }

    public static long getMod(long n, int m) {
        if (n <= 1) {
            return n;
        } else {
            long period = getPeriod(n, m);
            int count = (int) (n % period);
            return modArr.get(count);

        }

    }

    public static long getPeriod(long n, int m) {
        int mod1;
        int mod2;
        int num = 2;
        BigInteger x0 = new BigInteger("0");
        BigInteger x1 = new BigInteger("1");
        BigInteger sum;

        modArr.add(0);
        modArr.add(1);
        while (num <= n) {
            sum = x0.add(x1);
            x0 = x1;
            x1 = sum;
            mod1 = (sum.mod(BigInteger.valueOf(m))).intValue();
            mod2 = ((sum.add(x1)).mod(BigInteger.valueOf(m))).intValue();

            if (mod1 == 0 & mod2 == 1) {
                break;
            }
            modArr.add(mod1);
            num++;
        }
        return num;

    }

}
