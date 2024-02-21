import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        //System.out.println(gcd(a,b));
        //System.out.println((long)(a*b));
        System.out.println(least(a,b));
    }
    public static long least(long a, long b){

        return a/gcd(a,b)*b;

    }
    public static long gcd(long m, long n){
        if(m%n == 0){
            return n;
        }else{
            return gcd(n,m%n);
        }
    }
}
