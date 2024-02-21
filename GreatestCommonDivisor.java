import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(euclidean(a,b));
    }
    public static int euclidean(int a, int b){
        //gcd(a,b) = gcd(b,a mod b)
        if(a%b==0){
            return b;
        }else{
            return euclidean(b,a%b);
        }
    }
}
