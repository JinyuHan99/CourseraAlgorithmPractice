import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(sumOfDigits(a,b));
        System.out.println(System.nanoTime());

    }
    public static int sumOfDigits(int a, int b){
        return a+b;
    }
}
