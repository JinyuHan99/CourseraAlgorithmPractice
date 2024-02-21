import java.util.Scanner;

public class LastDigitOfFibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(last(n));
    }
    public static int last(int n){

        if(n<= 1){
            return n;
        }else{
            int f0 = 0;
            int f1 = 1;
            int sum = 0;
            for(int i = 2; i <= n; i++){
                sum = (f0 + f1)%10;
                f0 = f1;
                f1 = sum;
            }
            return sum;

        }
    }
}
